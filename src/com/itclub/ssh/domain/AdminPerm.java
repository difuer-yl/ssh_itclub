package com.itclub.ssh.domain;

/**
 * AdminPerm entity. @author MyEclipse Persistence Tools
 */

public class AdminPerm implements java.io.Serializable {

	// Fields

	private AdminPermId id;

	// Constructors

	/** default constructor */
	public AdminPerm() {
	}

	/** full constructor */
	public AdminPerm(AdminPermId id) {
		this.id = id;
	}

	// Property accessors

	public AdminPermId getId() {
		return this.id;
	}

	public void setId(AdminPermId id) {
		this.id = id;
	}

}