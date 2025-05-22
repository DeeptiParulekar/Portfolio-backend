package com.example.portfolio.service;

import java.util.List;

import com.example.portfolio.dto.PortfolioDTO;

public interface PortfolioService {

	PortfolioDTO createPortfolio(PortfolioDTO portfolioDTO);

	PortfolioDTO updatePortfolio(Long portfolioId, PortfolioDTO portfolioDTO);

	List<PortfolioDTO> getAllPortfolios();

	PortfolioDTO getPortfolioById(Long portfolioId);

	void deletePortfolio(Long portfolioId);

}
