package com.example.portfolio.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.ResumeDTO;
import com.example.portfolio.entity.Resume;
import com.example.portfolio.mapper.ResumeMapper;
import com.example.portfolio.repository.ResumeRepository;
import com.example.portfolio.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {
	
	@Autowired
	private ResumeMapper resumeMapper;

	@Autowired
	private ResumeRepository resumeRepository;

	private static final Logger log = LoggerFactory.getLogger("ResumeServiceImpl");

	@Override
	public ResumeDTO createResume(ResumeDTO resumeDTO) {
		log.info("Start Creating Resume");
		Resume resume = new Resume();
		resume.setBio(resumeDTO.getBio());
		resume.setAddress(resumeDTO.getAddress());
		resume.setResumeDescription(resumeDTO.getResumeDescription());
		resume.setProjects(resumeDTO.getProjects());
		resume.setMobileNumber(resumeDTO.getMobileNumber());
		resume.setLinkedIn(resumeDTO.getLinkedIn());
		resume.setJobTitle(resumeDTO.getJobTitle());
		resume.setDob(resumeDTO.getDob());
		resume.setExperience(resumeDTO.getExperience());
		resume.setGithub(resumeDTO.getGithub());
		resume.setEmail(resumeDTO.getEmail());
		Resume save = resumeRepository.save(resume);
		ResumeDTO resumeDTO2 = resumeMapper.toResumeDTO(save);
		return resumeDTO2;
	}

	@Override
	public ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO) {
		log.info("Start: Create update Resume");
		
		return null;
	}

	@Override
	public List<ResumeDTO> getAllResumes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResumeDTO getResumeById(Long resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteResume(Long resumeId) {
		// TODO Auto-generated method stub

	}

}
