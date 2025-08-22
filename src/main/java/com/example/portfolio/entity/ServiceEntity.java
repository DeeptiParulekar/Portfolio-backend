package com.example.portfolio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_entity", schema = "myportfolio")
public class ServiceEntity  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serviceEntityId")
	private Long serviceEntityId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "iconUrl")
	private String iconUrl;

	@Column(name = "packageInfo")
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
