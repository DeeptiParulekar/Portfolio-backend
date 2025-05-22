package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.ContactFormDTO;

public interface ContactFormService {

	ContactFormDTO createContactForm(ContactFormDTO contactFormDTO);

	ContactFormDTO updateContactForm(Long contactId, ContactFormDTO contactFormDTO);

	List<ContactFormDTO> getAllContactForm();

	ContactFormDTO getContactById(Long contactId);

	void deleteContact(Long contactId);

}
