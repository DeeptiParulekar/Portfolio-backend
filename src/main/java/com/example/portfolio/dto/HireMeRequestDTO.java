package com.example.portfolio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "hireMeRequestId", "name", "email", "projectTitle", "projectDescription", "budget", "timeline",
		"technologystack" })
public class HireMeRequestDTO {

	@JsonProperty("hireMeRequestId")
	private Long hireMeRequestId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("service")
	private String service;

	@JsonProperty("message")
	private String message;

	@JsonProperty("projectTitle")
	private String projectTitle;

	@JsonProperty("projectDescription")
	private String projectDescription;

	@JsonProperty("budget")
	private String budget;

	@JsonProperty("timeline")
	private String timeline;

	@JsonProperty("technologyStack")
	private String technologyStack;

	public Long getHireMeRequestId() {
		return hireMeRequestId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	public String getTechnologyStack() {
		return technologyStack;
	}

	public void setTechnologyStack(String technologyStack) {
		this.technologyStack = technologyStack;
	}

	public void setHireMeRequestId(Long hireMeRequestId) {
		this.hireMeRequestId = hireMeRequestId;
	}

}
