package com.example.portfolio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "profileId", "profileName", "profileTitle", "profileDescription", "portfolioUrl", "resumeUrl",
		"profileImage", "whatIDo", "base64Image" })
public class ProfileDTO {

	@JsonProperty("profileId")
	private Long profileId;

	@JsonProperty("profileName")
	private String profileName;

	@JsonProperty("profileTitle")
	private String profileTitle;

	@JsonProperty("profileDescription")
	private String profileDescription;

	@JsonProperty("portfolioUrl")
	private String portfolioUrl;

	@JsonProperty("resumeUrl")
	private String resumeUrl;

	@JsonProperty("profileImage")
	private String profileImage;
	
	@JsonProperty("profileImage2")
	private String profileImage2;

	@JsonProperty("whatIDo")
	private String whatIDo;

	@JsonProperty("base64Image")
	private String base64Image;

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
