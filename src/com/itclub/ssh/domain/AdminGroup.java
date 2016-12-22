package com.itclub.ssh.domain;

/**
 * AdminGroup entity. @author MyEclipse Persistence Tools
 */

public class AdminGroup implements java.io.Serializable {

	// Fields

	private int cpgroupid;
	private String cpgroupname;

	// Constructors

	/** default constructor */
	public AdminGroup() {
	}

	/** full constructor */
	public AdminGroup(String cpgroupname) {
		this.cpgroupname = cpgroupname;
	}

	// Property accessors

	public int getCpgroupid() {
		return this.cpgroupid;
	}

	public void setCpgroupid(int cpgroupid) {
		this.cpgroupid = cpgroupid;
	}

	public String getCpgroupname() {
		return this.cpgroupname;
	}

	public void setCpgroupname(String cpgroupname) {
		this.cpgroupname = cpgroupname;
	}

}