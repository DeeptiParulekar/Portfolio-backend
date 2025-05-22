package com.example.portfolio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "portfolioId", "allowanceTypeName" })
public class PortfolioDTO {

	@JsonProperty("portfolioId")
	private long portfolioId;;

	@JsonProperty("portfolioName")
	private String portfolioName;

	@JsonProperty("portfolioTitle")
	private String portfolioTitle;

	@JsonProperty("portfolioDescription")
	private String portfolioDescription;

	public long getPortfolioId() {
		return portfolioId;
	}

	public void setPortfolioId(long portfolioId) {
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

}
