package com.example.portfolio.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.ServiceEntityDTO;
import com.example.portfolio.entity.ServiceEntity;
import com.example.portfolio.repository.ServiceRepository;
import com.example.portfolio.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository repository;

	@Override
	public ServiceEntityDTO createServices(ServiceEntityDTO dto) {
		ServiceEntity entity = new ServiceEntity();
		entity.setTitle(dto.getTitle());
		entity.setDescription(dto.getDescription());
		entity.setIconUrl(dto.getIconUrl());
		entity.setPackageInfo(dto.getPackageInfo());

		ServiceEntity saved = repository.save(entity);
		return mapToDTO(saved);
	}

	@Override
	public ServiceEntityDTO updateServices(Long serviceEntityId, ServiceEntityDTO dto) {
		ServiceEntity existing = repository.findById(serviceEntityId)
				.orElseThrow(() -> new RuntimeException("Service not found"));

		existing.setTitle(dto.getTitle());
		existing.setDescription(dto.getDescription());
		existing.setIconUrl(dto.getIconUrl());
		existing.setPackageInfo(dto.getPackageInfo());

		ServiceEntity updated = repository.save(existing);
		return mapToDTO(updated);
	}

//	@Override
//	public List<ServiceEntityDTO> getAllServices() {
//		return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
//	}
	
	
	@Override
	public List<ServiceEntityDTO> getAllServices() {
	    return repository.findAll()
	        .stream()
	        .map(entity -> {
	            ServiceEntityDTO dto = new ServiceEntityDTO();
	            dto.setServiceEntityId(entity.getServiceEntityId());
	            dto.setTitle(entity.getTitle());
	            dto.setDescription(entity.getDescription());
	            dto.setIconUrl(entity.getIconUrl());
	            dto.setPackageInfo(entity.getPackageInfo());
	            return dto;
	        })
	        .collect(Collectors.toList());
	}


	@Override
	public ServiceEntityDTO getServiceById(Long serviceEntityId) {
		ServiceEntity entity = repository.findById(serviceEntityId)
				.orElseThrow(() -> new RuntimeException("Service not found"));
		return mapToDTO(entity);
	}

	@Override
	public void deleteService(Long serviceEntityId) {
		ServiceEntity entity = repository.findById(serviceEntityId)
				.orElseThrow(() -> new RuntimeException("Service not found"));
		repository.delete(entity);
	}

	private ServiceEntityDTO mapToDTO(ServiceEntity entity) {
		ServiceEntityDTO dto = new ServiceEntityDTO();
		dto.setServiceEntityId(entity.getServiceEntityId());
		dto.setTitle(entity.getTitle());
		dto.setDescription(entity.getDescription());
		dto.setIconUrl(entity.getIconUrl());
		dto.setPackageInfo(entity.getPackageInfo());
		return dto;
	}

}
