package com.example.portfolio.controller;

import java.util.Date;
import java.util.List;

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

import com.example.portfolio.dto.PortfolioDTO;
import com.example.portfolio.payloads.ErrorDetails;
import com.example.portfolio.service.PortfolioService;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "http://localhost:3000") 
public class PortfolioController {

	@Autowired
	private PortfolioService portfolioService;

	@PostMapping(value = "/createPortfolio", produces = "application/json")
	public ResponseEntity<?> createPortfolio(@RequestBody PortfolioDTO portfolioDTO) {
		try {
			PortfolioDTO created = portfolioService.createPortfolio(portfolioDTO);
			return new ResponseEntity<>(created, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping(value = "/updatePortfolio", produces = "application/json")
	public ResponseEntity<?> updatePortfolio(@RequestParam Long portfolioId, @RequestBody PortfolioDTO portfolioDTO) {
		try {
			PortfolioDTO updated = portfolioService.updatePortfolio(portfolioId, portfolioDTO);
			return new ResponseEntity<>(updated, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getAllPortfolio", produces = "application/json")
	public ResponseEntity<?> getAllPortfolios() {
		try {
			List<PortfolioDTO> list = portfolioService.getAllPortfolios();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getByIdPortfolio", produces = "application/json")
	public ResponseEntity<?> getPortfolioById(@RequestParam Long portfolioId) {
		try {
			PortfolioDTO dto = portfolioService.getPortfolioById(portfolioId);
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping(value = "/deletePortfolio", produces = "application/json")
	public ResponseEntity<?> deletePortfolio(@RequestParam Long portfolioId) {
		try {
			portfolioService.deletePortfolio(portfolioId);
			return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetails(new Date(), e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
