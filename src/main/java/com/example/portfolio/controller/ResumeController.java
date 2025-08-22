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

import com.example.portfolio.dto.ResumeDTO;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "http://localhost:3000")
public class ResumeController {

	@Autowired
	private ResumeService resumeService;

	@PostMapping(value = "/createResume", produces = "application/json")
	public ResponseEntity<?> createResume(@RequestBody ResumeDTO resumeDTO) {
		try {
			ResumeDTO created = resumeService.createResume(resumeDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateResume", produces = "application/json")
	public ResponseEntity<?> updateResume(@RequestParam Long resumeId, @RequestBody ResumeDTO resumeDTO) {
		try {
			ResumeDTO updated = resumeService.updateResume(resumeId, resumeDTO);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllResumes", produces = "application/json")
	public ResponseEntity<?> getAllResumes() {
		try {
			List<ResumeDTO> list = resumeService.getAllResumes();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getResumeById", produces = "application/json")
	public ResponseEntity<?> getResumeById(@RequestParam Long resumeId) {
		try {
			ResumeDTO dto = resumeService.getResumeById(resumeId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/deleteResume", produces = "application/json")
	public ResponseEntity<?> deleteResume(@RequestParam Long resumeId) {
		
		try {
			resumeService.deleteResume(resumeId);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Deleted Successfully");
			response.put("deleted resumeId", resumeId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Not Deleted, there is some error");
			errorResponse.put("error", e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
