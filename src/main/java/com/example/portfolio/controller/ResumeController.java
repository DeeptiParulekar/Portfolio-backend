package com.example.portfolio.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

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

	// Path where files will be stored
	private static final String UPLOAD_DIR = "uploads/";

	@PostMapping("/upload")
	public ResponseEntity<Map<String, String>> uploadResume(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty())
			return ResponseEntity.badRequest().body(Map.of("message", "File is empty"));
		try {
			Files.createDirectories(Paths.get(UPLOAD_DIR));
			Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
			Files.write(path, file.getBytes());
			return ResponseEntity
					.ok(Map.of("message", "PDF uploaded successfully!", "fileName", file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(Map.of("message", "Failed to upload PDF"));
		}
	}

//	@GetMapping("/download")
//	public ResponseEntity<Resource> downloadResume(@RequestParam String fileName) throws IOException {
//		Path path = Paths.get(UPLOAD_DIR + fileName);
//		File file = path.toFile();
//
//		if (!file.exists()) {
//			throw new RuntimeException("Resume PDF not found. Please upload first.");
//		}
//
//		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
//				.contentType(MediaType.APPLICATION_PDF).contentLength(file.length()).body(resource);
//	}

	@GetMapping("/download")
	public ResponseEntity<Resource> downloadResume(@RequestParam String fileName) {
	    try {
	        Path path = Paths.get("uploads").resolve(fileName);
	        if (!Files.exists(path)) {
	            throw new RuntimeException("Resume PDF not found: " + fileName);
	        }

	        Resource resource = new UrlResource(path.toUri());
	        return ResponseEntity.ok()
	                .contentType(MediaType.APPLICATION_PDF)
	                // 👇 inline makes it show in iframe instead of downloading
	                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + fileName + "\"")
	                .body(resource);
	    } catch (Exception e) {
	        return ResponseEntity.status(500).body(null);
	    }
	}
}
