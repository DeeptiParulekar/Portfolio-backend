package com.example.portfolio.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfolio.dto.HireMeRequestDTO;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.service.HireMeService;

@RestController
@RequestMapping("/api/hireMe")
@CrossOrigin(origins = "http://localhost:3000")
public class HireMeController {

	@Autowired
	private HireMeService hireMeService;

	@PostMapping(value = "/submitHireMe", produces = "application/json")
	public ResponseEntity<?> submitHireMe(@RequestBody HireMeRequestDTO hireMeRequestDTO) {
		try {
			HireMeRequestDTO created = hireMeService.submitHireMe(hireMeRequestDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
