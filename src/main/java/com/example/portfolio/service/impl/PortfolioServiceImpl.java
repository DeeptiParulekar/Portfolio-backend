package com.example.portfolio.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfolio.dto.PortfolioDTO;
import com.example.portfolio.entity.Portfolio;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.service.PortfolioService;

	@Service
	public class PortfolioServiceImpl implements PortfolioService {

	    @Autowired
	    private PortfolioRepository repository;

	    @Override
	    public PortfolioDTO createPortfolio(PortfolioDTO dto) {
	        Portfolio entity = new Portfolio();
	        entity.setPortfolioName(dto.getPortfolioName());
	        entity.setPortfolioTitle(dto.getPortfolioTitle());
	        entity.setPortfolioDescription(dto.getPortfolioDescription());

	        Portfolio saved = repository.save(entity);
	        return mapToDTO(saved);
	    }

	    @Override
	    public PortfolioDTO updatePortfolio(Long portfolioId, PortfolioDTO dto) {
	        Portfolio existing = repository.findById(portfolioId).orElseThrow(() -> new RuntimeException("Portfolio not found"));
	        existing.setPortfolioName(dto.getPortfolioName());
	        existing.setPortfolioTitle(dto.getPortfolioTitle());
	        existing.setPortfolioDescription(dto.getPortfolioDescription());

	        Portfolio updated = repository.save(existing);
	        return mapToDTO(updated);
	    }

	    @Override
	    public List<PortfolioDTO> getAllPortfolios() {
	        return repository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	    }

	    @Override
	    public PortfolioDTO getPortfolioById(Long portfolioId) {
	        Portfolio entity = repository.findById(portfolioId).orElseThrow(() -> new RuntimeException("Portfolio not found"));
	        return mapToDTO(entity);
	    }

	    @Override
	    public void deletePortfolio(Long portfolioId) {
	        Portfolio entity = repository.findById(portfolioId).orElseThrow(() -> new RuntimeException("Portfolio not found"));
	        repository.delete(entity);
	    }

	    private PortfolioDTO mapToDTO(Portfolio entity) {
	        PortfolioDTO dto = new PortfolioDTO();
	        dto.setPortfolioId(entity.getPortfolioId());
	        dto.setPortfolioName(entity.getPortfolioName());
	        dto.setPortfolioTitle(entity.getPortfolioTitle());
	        dto.setPortfolioDescription(entity.getPortfolioDescription());
	        return dto;
	    }
	}
