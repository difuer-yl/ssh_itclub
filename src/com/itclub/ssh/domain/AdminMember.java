package com.itclub.ssh.domain;

/**
 * AdminMember entity. @author MyEclipse Persistence Tools
 */

public class AdminMember implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer cpgroupid;
	private String customperm;

	// Constructors

	/** default constructor */
	public AdminMember() {
	}

	/** minimal constructor */
	public AdminMember(Integer id, Integer cpgroupid) {
		this.id = id;
		this.cpgroupid = cpgroupid;
	}

	/** full constructor */
	public AdminMember(Integer id, Integer cpgroupid, String customperm) {
		this.id = id;
		this.cpgroupid = cpgroupid;
		this.customperm = customperm;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCpgroupid() {
		return this.cpgroupid;
	}

	public void setCpgroupid(Integer cpgroupid) {
		this.cpgroupid = cpgroupid;
	}

	public String getCustomperm() {
		return this.customperm;
	}

	public void setCustomperm(String customperm) {
		this.customperm = customperm;
	}

}