package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.ProfileDTO;

public interface ProfileService {

	ProfileDTO createProfile(ProfileDTO profileDTO);

	ProfileDTO updateProfile(Long profileId, ProfileDTO profileDTO);

	List<ProfileDTO> getAllProfiles();

	ProfileDTO getProfileById(Long profileId);

	void deleteProfile(Long profileId);

	ProfileDTO updateProfileImage(Long profileId, String imageUrl);

}
