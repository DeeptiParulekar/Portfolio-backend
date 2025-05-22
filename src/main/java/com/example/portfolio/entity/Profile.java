package com.example.portfolio.entity;

import javax.persistence.*;

import com.example.portfolio.audit.Auditable;

@Entity
@Table(name = "profile", schema = "myportfolio")
public class Profile extends Auditable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profileId")
	private Long profileId;

	@Column(name = "profileName")
	private String profileName;

	@Column(name = "profileTitle")
	private String profileTitle;

	@Column(name = "profileDescription", length = 1000)
	private String profileDescription;

	@Column(name = "portfolioUrl")
	private String portfolioUrl;

	@Column(name = "resumeUrl")
	private String resumeUrl;

	@Column(name = "profileImage")
	private String profileImage;
	
	@Column(name = "profileImage2")
	private String profileImage2;

	@Column(name = "base64Image")
	private String base64Image;

	@Column(name = "whatIDo", length = 1000)
	private String whatIDo;

	// Getters and Setters

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getProfileTitle() {
		return profileTitle;
	}

	public void setProfileTitle(String profileTitle) {
		this.profileTitle = profileTitle;
	}

	public String getProfileDescription() {
		return profileDescription;
	}

	public void setProfileDescription(String profileDescription) {
		this.profileDescription = profileDescription;
	}

	public String getPortfolioUrl() {
		return portfolioUrl;
	}

	public void setPortfolioUrl(String portfolioUrl) {
		this.portfolioUrl = portfolioUrl;
	}

	public String getResumeUrl() {
		return resumeUrl;
	}

	public void setResumeUrl(String resumeUrl) {
		this.resumeUrl = resumeUrl;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getWhatIDo() {
		return whatIDo;
	}

	public void setWhatIDo(String whatIDo) {
		this.whatIDo = whatIDo;
	}

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	public String getProfileImage2() {
		return profileImage2;
	}

	public void setProfileImage2(String profileImage2) {
		this.profileImage2 = profileImage2;
	}

	
}
