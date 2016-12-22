package com.itclub.ssh.domain;

/**
 * Setting entity. @author MyEclipse Persistence Tools
 */

public class Setting implements java.io.Serializable {

	// Fields

	private String skey;
	private String svalue;

	// Constructors

	/** default constructor */
	public Setting() {
	}

	/** full constructor */
	public Setting(String skey, String svalue) {
		this.skey = skey;
		this.svalue = svalue;
	}

	// Property accessors

	public String getSkey() {
		return this.skey;
	}

	public void setSkey(String skey) {
		this.skey = skey;
	}

	public String getSvalue() {
		return this.svalue;
	}

	public void setSvalue(String svalue) {
		this.svalue = svalue;
	}

}