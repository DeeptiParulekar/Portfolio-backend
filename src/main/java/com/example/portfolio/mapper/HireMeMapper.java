package com.example.portfolio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.example.portfolio.dto.HireMeRequestDTO;
import com.example.portfolio.entity.HireMeRequest;

@Component
public class HireMeMapper {
	
	private ModelMapper modelMapper;

	
	public HireMeRequest toHireMeRequest(HireMeRequestDTO hireMeRequestDTO) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		HireMeRequest map = modelMapper.map(hireMeRequestDTO, HireMeRequest.class);
		return map;
	}

	public HireMeRequestDTO toHireMeRequestDTO(HireMeRequest hireMeRequest) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		HireMeRequestDTO map = modelMapper.map(hireMeRequest, HireMeRequestDTO.class);
		return map;
	}

	public List<HireMeRequestDTO> mapHireMeRequestDTOsList(List<HireMeRequest> hireMeRequests) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		List<HireMeRequestDTO> dtos = new ArrayList<HireMeRequestDTO>();
		for (HireMeRequest hireMeRequest : hireMeRequests) {
			HireMeRequestDTO dto = modelMapper.map(hireMeRequest, HireMeRequestDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
}
