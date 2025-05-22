package com.example.portfolio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.portfolio.dto.ContactFormDTO;
import com.example.portfolio.entity.ContactForm;

@Component
public class ContactFormMapper {

	@Autowired
	private ModelMapper modelMapper;

	public ContactForm toContactForm(ContactFormDTO contactFormDTO) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ContactForm map = modelMapper.map(contactFormDTO, ContactForm.class);
		return map;
	}

	public ContactFormDTO toContactFormDTO(ContactForm contactForm) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ContactFormDTO map = modelMapper.map(contactForm, ContactFormDTO.class);
		return map;
	}

	public List<ContactFormDTO> mapContactFormDTOsList(List<ContactForm> contactForms) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		List<ContactFormDTO> dtos = new ArrayList<ContactFormDTO>();
		for (ContactForm contactForm : contactForms) {
			ContactFormDTO dto = modelMapper.map(contactForm, ContactFormDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
}
