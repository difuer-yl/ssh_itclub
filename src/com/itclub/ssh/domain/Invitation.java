package com.itclub.ssh.domain;

/**
 * Invitation entity. @author MyEclipse Persistence Tools
 */

public class Invitation implements java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private boolean status;

	// Constructors

	/** default constructor */
	public Invitation() {
	}

	/** minimal constructor */
	public Invitation(String code) {
		this.code = code;
	}

	/** full constructor */
	public Invitation(String code, boolean status) {
		this.code = code;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}