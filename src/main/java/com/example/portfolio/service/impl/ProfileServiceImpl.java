package com.example.portfolio.service.impl;

import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.portfolio.dto.ProfileDTO;
import com.example.portfolio.entity.Profile;
import com.example.portfolio.mapper.ProfileMapper;
import com.example.portfolio.repository.ProfileRepository;
import com.example.portfolio.service.ProfileService;

import java.nio.file.Path;
import java.util.Base64;
import java.nio.file.Files;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private ProfileMapper profileMapper;

	@Override
	public ProfileDTO createProfile(ProfileDTO profileDTO) {
		Profile profile = new Profile();
		profile.setProfileName(profileDTO.getProfileName());
		profile.setProfileTitle(profileDTO.getProfileTitle());
		profile.setProfileDescription(profileDTO.getProfileDescription());
		profile.setPortfolioUrl(profileDTO.getPortfolioUrl());
		profile.setResumeUrl(profileDTO.getResumeUrl());

		if (profileDTO.getProfileImage() != null && profileDTO.getProfileImage().startsWith("data:image")) {
			String imageUrl = saveBase64Image(profileDTO.getProfileImage());
			profile.setProfileImage(imageUrl);
		} else {
			profile.setProfileImage(profileDTO.getProfileImage());
		}

		profile.setWhatIDo(profileDTO.getWhatIDo());

		Profile savedProfile = profileRepository.save(profile);
		return mapToDTO(savedProfile);
	}

	private String saveBase64Image(String base64Image) {
		try {
			String[] parts = base64Image.split(",");
			String imageData = parts.length > 1 ? parts[1] : parts[0];
			byte[] imageBytes = Base64.getDecoder().decode(imageData);

			Path uploadPath = Paths.get("uploads").toAbsolutePath();
			Files.createDirectories(uploadPath);

			String fileName = UUID.randomUUID().toString() + ".png";
			Path filePath = uploadPath.resolve(fileName);
			Files.write(filePath, imageBytes);

			String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(fileName)
					.toUriString();

			return imageUrl;
		} catch (Exception e) {
			throw new RuntimeException("Failed to save profile image", e);
		}
	}

	@Override
	public ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO) {
		Profile existing = profileRepository.findById(profileId)
				.orElseThrow(() -> new RuntimeException("profileId not found"));

		existing.setProfileName(profileDTO.getProfileName());
		existing.setProfileTitle(profileDTO.getProfileTitle());
		existing.setProfileDescription(profileDTO.getProfileDescription());
		existing.setPortfolioUrl(profileDTO.getPortfolioUrl());
		existing.setResumeUrl(profileDTO.getResumeUrl());

		if (profileDTO.getProfileImage() != null && profileDTO.getProfileImage().startsWith("data:image")) {
			String imageUrl = saveBase64Image(profileDTO.getProfileImage());
			existing.setProfileImage(imageUrl);
		}

		existing.setWhatIDo(profileDTO.getWhatIDo());

		Profile updated = profileRepository.save(existing);
		return mapToDTO(updated);
	}

	@Override
	public List<ProfileDTO> getAllProfiles() {
		return profileRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public ProfileDTO getProfileById(Long profileId) {
		Profile entity = profileRepository.findById(profileId)
				.orElseThrow(() -> new RuntimeException("Profile not found"));
		return mapToDTO(entity);
	}

	@Override
	public void deleteProfile(Long profileId) {
		Profile entity = profileRepository.findById(profileId)
				.orElseThrow(() -> new RuntimeException("Portfolio not found"));
		profileRepository.delete(entity);

	}

	private ProfileDTO mapToDTO(Profile entity) {
		ProfileDTO dto = new ProfileDTO();
		dto.setProfileId(entity.getProfileId());
		dto.setProfileName(entity.getProfileName());
		dto.setProfileTitle(entity.getProfileTitle());
		dto.setProfileDescription(entity.getProfileDescription());
		dto.setPortfolioUrl(entity.getPortfolioUrl());
		dto.setResumeUrl(entity.getResumeUrl());
		dto.setProfileImage(entity.getProfileImage());
		dto.setProfileImage2(entity.getProfileImage2());
		dto.setWhatIDo(entity.getWhatIDo());
		return dto;
	}

	public ProfileDTO updateProfileImage(Long profileId, String imageUrl) {
		Profile profile = profileRepository.findById(profileId)
				.orElseThrow(() -> new RuntimeException("Profile not found"));

		profile.setProfileImage(imageUrl);
		profileRepository.save(profile);

		return profileMapper.toProfileDTO(profile); 
	}

}
