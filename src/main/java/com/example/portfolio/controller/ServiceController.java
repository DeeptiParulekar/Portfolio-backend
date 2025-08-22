package com.example.portfolio.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.portfolio.dto.ServiceEntityDTO;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.service.ServiceService;

@RestController
@RequestMapping("/api/service")
@CrossOrigin(origins = "http://localhost:3000")
public class ServiceController {

	
	@Autowired
	private ServiceService serviceService;

	@PostMapping(value = "/createServices", produces = "application/json")
	public ResponseEntity<?> createServices(@RequestBody ServiceEntityDTO serviceEntityDTO) {
		try {
			ServiceEntityDTO created = serviceService.createServices(serviceEntityDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateServices", produces = "application/json")
	public ResponseEntity<?> updateContactForm(@RequestParam Long serviceEntityId,
			@RequestBody ServiceEntityDTO serviceEntityDTO) {
		try {
			ServiceEntityDTO updated = serviceService.updateServices(serviceEntityId, serviceEntityDTO);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllServices", produces = "application/json")
	public ResponseEntity<?> getAllServices() {
		try {
			List<ServiceEntityDTO> list = serviceService.getAllServices();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getServiceById", produces = "application/json")
	public ResponseEntity<?> getServiceById(@RequestParam Long serviceEntityId) {
		try {
			ServiceEntityDTO dto = serviceService.getServiceById(serviceEntityId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = { "/deleteService" }, produces = "application/json")
	public ResponseEntity<?> deleteService(@RequestParam Long serviceEntityId) {
		try {
			serviceService.deleteService(serviceEntityId);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Deleted Successfully");
			response.put("deleted contactId", serviceEntityId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Not Deleted, there is some error");
			errorResponse.put("error", e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
