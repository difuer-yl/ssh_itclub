package com.itclub.ssh.domain;

/**
 * MemberActionLog entity. @author MyEclipse Persistence Tools
 */

public class MemberActionLog implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer uid;
	private String action;
	private boolean dateline;
	private long time;
	private String ip;

	// Constructors

	/** default constructor */
	public MemberActionLog() {
	}

	/** full constructor */
	public MemberActionLog(Integer uid, String action, boolean dateline,
			long time, String ip) {
		this.uid = uid;
		this.action = action;
		this.dateline = dateline;
		this.time = time;
		this.ip = ip;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public boolean getDateline() {
		return this.dateline;
	}

	public void setDateline(boolean dateline) {
		this.dateline = dateline;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}