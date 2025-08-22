package com.example.portfolio.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "resumeId", "resumeName", "resumeDescription", "experience", "dob", "email", "mobileNumber",
		"jobTitle", "linkedIn", "github", "address", "projects", "date" })
public class ResumeDTO {

	@JsonProperty("resumeId")
	private long resumeId;

	@JsonProperty("bio")
	private String bio;

	@JsonProperty("resumeDescription")
	private String resumeDescription;

	@JsonProperty("experience")
	private String experience;

	@JsonProperty("dob")
	private String dob;

	@JsonProperty("email")
	private String email;

	@JsonProperty("mobileNumber")
	private String mobileNumber;

	@JsonProperty("jobTitle")
	private String jobTitle;

	@JsonProperty("linkedIn")
	private String linkedIn;

	@JsonProperty("github")
	private String github;

	@JsonProperty("address")
	private String address;

	@JsonProperty("projects")
	private String projects;

	@JsonProperty("date")
	private Date date;

	public long getResumeId() {
		return resumeId;
	}

	public void setResumeId(long resumeId) {
		this.resumeId = resumeId;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getResumeDescription() {
		return resumeDescription;
	}

	public void setResumeDescription(String resumeDescription) {
		this.resumeDescription = resumeDescription;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
