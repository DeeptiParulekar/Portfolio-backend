package com.example.portfolio.service.impl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
		log.info("Start: Update Resume with ID {}", resumeId);
		Resume resume = resumeRepository.findById(resumeId)
				.orElseThrow(() -> new RuntimeException("Resume not found with id: " + resumeId));

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
		resume.setDate(resumeDTO.getDate());

		Resume updated = resumeRepository.save(resume);
		return resumeMapper.toResumeDTO(updated);
	}

	@Override
	public List<ResumeDTO> getAllResumes() {
		log.info("Fetching all resumes");
		return resumeRepository.findAll().stream().map(resumeMapper::toResumeDTO).collect(Collectors.toList());
	}

	@Override
	public ResumeDTO getResumeById(Long resumeId) {
		log.info("Fetching resume with ID {}", resumeId);
		Resume resume = resumeRepository.findById(resumeId)
				.orElseThrow(() -> new RuntimeException("Resume not found with id: " + resumeId));
		return resumeMapper.toResumeDTO(resume);
	}

	@Override
	public void deleteResume(Long resumeId) {
		log.info("Deleting resume with ID {}", resumeId);
		if (!resumeRepository.existsById(resumeId)) {
			throw new RuntimeException("Resume not found with id: " + resumeId);
		}
		resumeRepository.deleteById(resumeId);
	}

	private static final String UPLOAD_DIR = "uploads";
	private static final String FILE_NAME = "Random_Resume.pdf";

	@PostMapping("/upload")
	public ResponseEntity<Map<String, String>> uploadFile(@RequestParam("file") MultipartFile file) {
		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body(Map.of("message", "No file selected"));
			}

			// Save file to local storage (optional)
			String fileName = file.getOriginalFilename();
			Path path = Paths.get("uploads/" + fileName);
			Files.createDirectories(path.getParent());
			Files.write(path, file.getBytes());

			// ✅ Return JSON response
			return ResponseEntity.ok(Map.of("message", "Resume uploaded successfully", "fileName", fileName));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(Map.of("message", "Upload failed: " + e.getMessage()));
		}
	}

	@GetMapping("/download")
	public ResponseEntity<Resource> downloadResume() {
		try {
			Path path = Paths.get(UPLOAD_DIR).resolve(FILE_NAME);

			if (!Files.exists(path)) {
				throw new RuntimeException("Resume PDF not found. Please upload first.");
			}

			Resource resource = new UrlResource(path.toUri());

			return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF)
					.header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + FILE_NAME + "\"").body(resource);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(null);
		}
	}

}
