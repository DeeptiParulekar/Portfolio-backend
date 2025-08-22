package com.example.portfolio.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "serviceEntityId", "title", "description", "iconUrl", "packageInfo" })
public class ServiceEntityDTO {

	@JsonProperty("serviceEntityId")
	private Long serviceEntityId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("description")
	private String description;

	@JsonProperty("iconUrl")
	private String iconUrl;

	@JsonProperty("packageInfo")
	private String packageInfo;

	public Long getServiceEntityId() {
		return serviceEntityId;
	}

	public void setServiceEntityId(Long serviceEntityId) {
		this.serviceEntityId = serviceEntityId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getPackageInfo() {
		return packageInfo;
	}

	public void setPackageInfo(String packageInfo) {
		this.packageInfo = packageInfo;
	}

}
