package com.example.portfolio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.HireMeRequestDTO;
import com.example.portfolio.entity.HireMeRequest;
import com.example.portfolio.repository.HireMeRepository;
import com.example.portfolio.service.HireMeService;

@Service
public class HireMeServiceImpl implements HireMeService {

	@Autowired
	private HireMeRepository hireMeRepository;

	@Override
	public HireMeRequestDTO submitHireMe(HireMeRequestDTO hireMeRequestDTO) {
		HireMeRequest hireMeRequest = new HireMeRequest();
		hireMeRequest.setName(hireMeRequestDTO.getName());
		hireMeRequest.setEmail(hireMeRequestDTO.getEmail());
		hireMeRequest.setService(hireMeRequestDTO.getService());
		hireMeRequest.setMessage(hireMeRequestDTO.getMessage());

		HireMeRequest saved = hireMeRepository.save(hireMeRequest);

		// Optionally return saved data in response DTO
		HireMeRequestDTO responseDTO = new HireMeRequestDTO();
		responseDTO.setName(saved.getName());
		responseDTO.setEmail(saved.getEmail());
		responseDTO.setService(saved.getService());
		responseDTO.setMessage(saved.getMessage());

		return responseDTO;
	}
}
