package com.example.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.portfolio.audit.Auditable;

@Entity
@Table(name = "hireMeRequest", schema = "myportfolio")
public class HireMeRequest extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hireMeRequestId")
	private Long hireMeRequestId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "service")
	private String service;

	@Column(name = "message", length = 1000)
	private String message;

	@Column(name = "projectTitle")
	private String projectTitle;

	@Column(name = "projectDescription", length = 1000)
	private String projectDescription;

	@Column(name = "budget")
	private String budget;

	@Column(name = "timeline")
	private String timeline;

	@Column(name = "technologyStack")
	private String technologyStack;

	public Long getHireMeRequestId() {
		return hireMeRequestId;
	}

	public void setHireMeRequestId(Long hireMeRequestId) {
		this.hireMeRequestId = hireMeRequestId;
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

}
