package com.itclub.ssh.domain;

/**
 * Friendlink entity. @author MyEclipse Persistence Tools
 */

public class Friendlink implements java.io.Serializable {

	// Fields

	private short id;
	private short displayorder;
	private String name;
	private String url;
	private String description;
	private String logo;
	private short type;

	// Constructors

	/** default constructor */
	public Friendlink() {
	}

	/** full constructor */
	public Friendlink(short displayorder, String name, String url,
			String description, String logo, short type) {
		this.displayorder = displayorder;
		this.name = name;
		this.url = url;
		this.description = description;
		this.logo = logo;
		this.type = type;
	}

	// Property accessors

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(short displayorder) {
		this.displayorder = displayorder;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

}