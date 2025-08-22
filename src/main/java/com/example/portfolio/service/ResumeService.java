package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.ResumeDTO;

public interface ResumeService {

	ResumeDTO createResume(ResumeDTO resumeDTO);

	ResumeDTO updateResume(Long resumeId, ResumeDTO resumeDTO);

	List<ResumeDTO> getAllResumes();

	ResumeDTO getResumeById(Long resumeId);

	void deleteResume(Long resumeId);

}
