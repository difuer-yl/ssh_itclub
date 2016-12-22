package com.itclub.ssh.domain;

/**
 * AdminPermId entity. @author MyEclipse Persistence Tools
 */

public class AdminPermId implements java.io.Serializable {

	// Fields

	private short cpgroupid;
	private String perm;

	// Constructors

	/** default constructor */
	public AdminPermId() {
	}

	/** full constructor */
	public AdminPermId(short cpgroupid, String perm) {
		this.cpgroupid = cpgroupid;
		this.perm = perm;
	}

	// Property accessors

	public short getCpgroupid() {
		return this.cpgroupid;
	}

	public void setCpgroupid(short cpgroupid) {
		this.cpgroupid = cpgroupid;
	}

	public String getPerm() {
		return this.perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdminPermId))
			return false;
		AdminPermId castOther = (AdminPermId) other;

		return (this.getCpgroupid() == castOther.getCpgroupid())
				&& ((this.getPerm() == castOther.getPerm()) || (this.getPerm() != null
						&& castOther.getPerm() != null && this.getPerm()
						.equals(castOther.getPerm())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getCpgroupid();
		result = 37 * result
				+ (getPerm() == null ? 0 : this.getPerm().hashCode());
		return result;
	}

}