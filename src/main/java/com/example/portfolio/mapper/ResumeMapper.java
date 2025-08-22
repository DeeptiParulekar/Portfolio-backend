package com.example.portfolio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.portfolio.dto.ResumeDTO;
import com.example.portfolio.entity.Resume;

@Component
public class ResumeMapper {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Resume  toResume(ResumeDTO resumeDTO) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		Resume map = modelMapper.map(resumeDTO, Resume.class);
		return map;
	}

	public ResumeDTO toResumeDTO(Resume resume) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		ResumeDTO map = modelMapper.map(resume, ResumeDTO.class);
		return map;
	}

	public List<ResumeDTO> mapResumeDTOsList(List<Resume> resumes) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		List<ResumeDTO> dtos = new ArrayList<ResumeDTO>();
		for (Resume resume : resumes) {
			ResumeDTO dto = modelMapper.map(resume, ResumeDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}
}
