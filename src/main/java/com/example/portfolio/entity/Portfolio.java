package com.example.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.portfolio.audit.Auditable;

@Entity
@Table(name = "portfolio", schema = "myportfolio")
public class Portfolio extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "portfolioId")
	private Long portfolioId;

	@Column(name = "portfolioName")
	private String portfolioName;

	@Column(name = "portfolioTitle")
	private String portfolioTitle;

	@Column(name = "portfolioDescription", length = 500)
	private String portfolioDescription;

	@Column(name = "category")
	private String category;

	@Column(name = "client")
	private String client;

	public Long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(Long portfolioId) {
		this.portfolioId = portfolioId;
	}

	public String getPortfolioName() {
		return portfolioName;
	}

	public void setPortfolioName(String portfolioName) {
		this.portfolioName = portfolioName;
	}

	public String getPortfolioTitle() {
		return portfolioTitle;
	}

	public void setPortfolioTitle(String portfolioTitle) {
		this.portfolioTitle = portfolioTitle;
	}

	public String getPortfolioDescription() {
		return portfolioDescription;
	}

	public void setPortfolioDescription(String portfolioDescription) {
		this.portfolioDescription = portfolioDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

}