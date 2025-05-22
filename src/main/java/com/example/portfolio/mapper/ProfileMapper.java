package com.example.portfolio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.portfolio.dto.ProfileDTO;
import com.example.portfolio.entity.Profile;

@Component
public class ProfileMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Profile toProfile(ProfileDTO profileDTO) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		Profile map = modelMapper.map(profileDTO, Profile.class);
		return map;
	}

	public ProfileDTO toProfileDTO(Profile profile) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ProfileDTO map = modelMapper.map(profile, ProfileDTO.class);
		return map;
	}

	public List<ProfileDTO> mapProfileDTOsList(List<Profile> profiles) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		List<ProfileDTO> dtos = new ArrayList<ProfileDTO>();
		for (Profile profile : profiles) {
			ProfileDTO dto = modelMapper.map(profile, ProfileDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
}
