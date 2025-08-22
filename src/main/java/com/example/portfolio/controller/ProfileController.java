package com.example.portfolio.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.dto.ImageUploadRequestDTO;
import com.example.portfolio.dto.ProfileDTO;
import com.example.portfolio.entity.Profile;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.repository.ProfileRepository;
import com.example.portfolio.service.ProfileService;


@RestController
@RequestMapping("/api/profile")
@CrossOrigin(origins = "http://localhost:3000")
public class ProfileController {

	@Autowired
	private ProfileService profileService;
	
	@Autowired
	private ProfileRepository profileRepository;

	@PostMapping(value = "/createProfile", produces = "application/json")
	public ResponseEntity<?> createProfile(@RequestBody ProfileDTO profileDTO) {
		try {
			ProfileDTO created = profileService.createProfile(profileDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateProfile", produces = "application/json")
	public ResponseEntity<?> updateProfile(@RequestParam Long profileId, @RequestBody ProfileDTO profileDTO) {
		try {
			ProfileDTO updated = profileService.updateProfile(profileId, profileDTO);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllProfiles", produces = "application/json")
	public ResponseEntity<?> getAllProfiles() {
		try {
			List<ProfileDTO> list = profileService.getAllProfiles();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getProfileById", produces = "application/json")
	public ResponseEntity<?> getProfileById(@RequestParam Long profileId) {
		try {
			ProfileDTO dto = profileService.getProfileById(profileId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/deleteProfile", produces = "application/json")
	public ResponseEntity<?> deleteProfile(@RequestParam Long profileId) {
		try {
			profileService.deleteProfile(profileId);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Deleted Successfully");
			response.put("deleted profileId", profileId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Not Deleted, there is some error");
			errorResponse.put("error", e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@PostMapping(value = "/uploadProfileImage", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> uploadProfileImage(@RequestBody ProfileDTO profileDTO) {
//	    try {
//	        String base64Image = profileDTO.getBase64Image();
//	        Long profileId = profileDTO.getProfileId();
//
//	        if (base64Image == null || profileId == null) {
//	            return new ResponseEntity<>("Profile ID or Image is missing", HttpStatus.BAD_REQUEST);
//	        }
//
//	        // Decode base64 image
////	        byte[] imageBytes = Base64.getDecoder().decode(base64Image.split(",")[1]);// remove data:image/...;base64,
//	        byte[] imageBytes = Base64.getDecoder().decode(base64Image);
//
//
//	        // Create upload directory
//	        String uploadDir = "uploads/";
//	        Path uploadPath = Paths.get(uploadDir);
//	        if (!Files.exists(uploadPath)) {
//	            Files.createDirectories(uploadPath);
//	        }
//
//	        // Generate file name
//	        String fileName = UUID.randomUUID() + ".png";
//	        Path filePath = uploadPath.resolve(fileName);
//	        Files.write(filePath, imageBytes);
//
//	        // Construct image URL
//	        String imageUrl = "http://localhost:8080/uploads/" + fileName;
//
//	        // Update profile
//	        ProfileDTO updated = profileService.updateProfileImage(profileId, imageUrl);
//
//	        return new ResponseEntity<>(updated, HttpStatus.OK);
//	    } catch (Exception e) {
//	        return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}
	
	@PostMapping("/uploadProfileImage")
	public ResponseEntity<Profile> uploadProfileImage(@RequestBody ImageUploadRequestDTO imageUploadRequestDTO) {
	    try {
	        // Decode base64 image
	        byte[] imageBytes = Base64.getDecoder().decode(imageUploadRequestDTO.getBase64Image());
	        String fileName = "profile_" + UUID.randomUUID().toString() + ".jpg";
	        Path uploadDir = Paths.get("uploads");

	        // Create directory if it doesn't exist
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }

	        // Save image to filesystem
	        Path filePath = uploadDir.resolve(fileName);
	        Files.write(filePath, imageBytes);

	        // Fetch the Profile entity (Optional orElseThrow recommended)
	        Optional<Profile> optionalProfile = profileRepository.findById(imageUploadRequestDTO.getProfileId());
	        if (!optionalProfile.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        Profile profile = optionalProfile.get();

	        // Save relative image path
	        profile.setProfileImage("/uploads/" + fileName);

	        // Save updated profile
	        Profile updatedProfile = profileRepository.save(profile); // correct method is save(), not saveProfile()

	        return ResponseEntity.ok(updatedProfile);

	    } catch (IOException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


	@PostMapping("/uploadProfileImage2")
	public ResponseEntity<Profile> uploadProfileImage2(@RequestBody ImageUploadRequestDTO imageUploadRequestDTO) {
	    try {
	        // Decode base64 image
	        byte[] imageBytes = Base64.getDecoder().decode(imageUploadRequestDTO.getBase64Image());
	        String fileName = "profile_" + UUID.randomUUID().toString() + ".jpg";
	        Path uploadDir = Paths.get("uploads");

	        // Create directory if it doesn't exist
	        if (!Files.exists(uploadDir)) {
	            Files.createDirectories(uploadDir);
	        }

	        // Save image to filesystem
	        Path filePath = uploadDir.resolve(fileName);
	        Files.write(filePath, imageBytes);

	        // Fetch the Profile entity (Optional orElseThrow recommended)
	        Optional<Profile> optionalProfile = profileRepository.findById(imageUploadRequestDTO.getProfileId());
	        if (!optionalProfile.isPresent()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }

	        Profile profile = optionalProfile.get();

	        // Save relative image path
	        profile.setProfileImage2("/uploads/" + fileName);

	        // Save updated profile
	        Profile updatedProfile = profileRepository.save(profile); // correct method is save(), not saveProfile()

	        return ResponseEntity.ok(updatedProfile);

	    } catch (IOException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}


}