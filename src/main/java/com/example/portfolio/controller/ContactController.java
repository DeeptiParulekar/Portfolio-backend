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

import com.example.portfolio.dto.ContactFormDTO;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.service.ContactFormService;

@RestController
@RequestMapping("/api/contactForm")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

	@Autowired
	private ContactFormService contactFormService;

	@PostMapping(value = "/createContactForm", produces = "application/json")
	public ResponseEntity<?> createContactForm(@RequestBody ContactFormDTO contactFormDTO) {
		try {
			ContactFormDTO created = contactFormService.createContactForm(contactFormDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updateContactForm", produces = "application/json")
	public ResponseEntity<?> updateContactForm(@RequestParam Long contactId,
			@RequestBody ContactFormDTO contactFormDTO) {
		try {
			ContactFormDTO updated = contactFormService.updateContactForm(contactId, contactFormDTO);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllContactForm", produces = "application/json")
	public ResponseEntity<?> getAllContactForm() {
		try {
			List<ContactFormDTO> list = contactFormService.getAllContactForm();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getContactById", produces = "application/json")
	public ResponseEntity<?> getContactById(@RequestParam Long contactId) {
		try {
			ContactFormDTO dto = contactFormService.getContactById(contactId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = { "/deleteContactForm" }, produces = "application/json")
	public ResponseEntity<?> deleteContactForm(@RequestParam Long contactId) {
		try {
			contactFormService.deleteContact(contactId);
			Map<String, Object> response = new HashMap<>();
			response.put("message", "Deleted Successfully");
			response.put("deleted contactId", contactId);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> errorResponse = new HashMap<>();
			errorResponse.put("message", "Not Deleted, there is some error");
			errorResponse.put("error", e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
