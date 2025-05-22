package com.example.portfolio.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.ContactFormDTO;
import com.example.portfolio.entity.ContactForm;
import com.example.portfolio.repository.ContactFormRepository;
import com.example.portfolio.service.ContactFormService;

@Service
public class ContactFormServiceImpl implements ContactFormService {

	@Autowired
	private ContactFormRepository repository;

	@Override
	public ContactFormDTO createContactForm(ContactFormDTO dto) {
		ContactForm entity = new ContactForm();
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setMessage(dto.getMessage());

		ContactForm saved = repository.save(entity);
		return mapToDTO(saved);
	}

	@Override
	public ContactFormDTO updateContactForm(Long contactId, ContactFormDTO dto) {
		ContactForm existing = repository.findById(contactId)
				.orElseThrow(() -> new RuntimeException("Contact Form not found"));
		existing.setName(dto.getName());
		existing.setEmail(dto.getEmail());
		existing.setMessage(dto.getMessage());

		ContactForm updated = repository.save(existing);
		return mapToDTO(updated);
	}

	@Override
	public List<ContactFormDTO> getAllContactForm() {
		return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	@Override
	public ContactFormDTO getContactById(Long contactId) {
		ContactForm entity = repository.findById(contactId)
				.orElseThrow(() -> new RuntimeException("Contact Form not found"));
		return mapToDTO(entity);
	}

	@Override
	public void deleteContact(Long contactId) {
		ContactForm entity = repository.findById(contactId)
				.orElseThrow(() -> new RuntimeException("Contact Form not found"));
		repository.delete(entity);
	}

	private ContactFormDTO mapToDTO(ContactForm entity) {
		ContactFormDTO dto = new ContactFormDTO();
		dto.setContactId(entity.getContactId());
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setMessage(entity.getMessage());
		return dto;
	}
}
