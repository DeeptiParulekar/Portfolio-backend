package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.ServiceEntityDTO;

public interface ServiceService {

	ServiceEntityDTO createServices(ServiceEntityDTO serviceEntityDTO);

	ServiceEntityDTO updateServices(Long serviceEntityId, ServiceEntityDTO serviceEntityDTO);

	List<ServiceEntityDTO> getAllServices();

	ServiceEntityDTO getServiceById(Long serviceEntityId);

	void deleteService(Long serviceEntityId);

}
