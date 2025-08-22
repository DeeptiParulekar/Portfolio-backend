package com.example.portfolio.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.portfolio.audit.Auditable;

@Entity
@Table(name = "resumeEntity", schema = "myportfolio")
public class Resume extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resumeId")
	private long resumeId;

	@Column(name = "bio")
	private String bio;

	@Column(name = "resumeDescription")
	private String resumeDescription;

	@Column(name = "experience")
	private String experience;

	@Column(name = "dob")
	private String dob;

	@Column(name = "email")
	private String email;

	@Column(name = "mobileNumber")
	private String mobileNumber;

	@Column(name = "jobTitle")
	private String jobTitle;

	@Column(name = "linkedIn")
	private String linkedIn;

	@Column(name = "github")
	private String github;

	@Column(name = "address")
	private String address;

	@Column(name = "projects")
	private String projects;

	@Column(name = "date")
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
