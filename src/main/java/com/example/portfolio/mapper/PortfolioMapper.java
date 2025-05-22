package com.example.portfolio.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.portfolio.dto.PortfolioDTO;
import com.example.portfolio.entity.Portfolio;

@Component
public class PortfolioMapper {

	@Autowired
	private ModelMapper modelMapper;

	public Portfolio toPortfolio(PortfolioDTO portfolioDTO) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		Portfolio map = modelMapper.map(portfolioDTO, Portfolio.class);
		return map;
	}

	public PortfolioDTO toPortfolioDTO(Portfolio portfolio) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		PortfolioDTO map = modelMapper.map(portfolio, PortfolioDTO.class);
		return map;
	}

	public List<PortfolioDTO> mapPortfolioDTOsList(List<Portfolio> portfolios) {
		modelMapper.getConfiguration().setAmbiguityIgnored(true);
		List<PortfolioDTO> dtos = new ArrayList<PortfolioDTO>();
		for (Portfolio portfolio : portfolios) {
			PortfolioDTO dto = modelMapper.map(portfolio, PortfolioDTO.class);
			dtos.add(dto);
		}
		return dtos;
	}

}
