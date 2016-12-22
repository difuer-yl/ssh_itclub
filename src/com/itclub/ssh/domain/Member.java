package com.itclub.ssh.domain;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String email;
	private String mobil;
	private Integer sex;
	private boolean status;
	private String salt;
	private boolean emailstatus;
	private boolean avatarstatus;
	private boolean adminid;
	private short groupid;
	private Integer groupexpiry;
	private String extgroupids;
	private long regdate;
	private Integer credits;
	private short newpm;
	private short newprompt;
	private boolean accessmasks;
	private boolean allowadmincp;
	private boolean onlyacceptfriendpm;
	private boolean conisbind;
	private String token;
	private long lastLoginTime;
	private long tokenCreateTime;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String username, String password, String email,
			boolean status, String salt, long regdate) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.status = status;
		this.salt = salt;
		this.regdate = regdate;
	}

	/** full constructor */
	public Member(String username, String password, String email, String mobil,
			Integer sex, boolean status, String salt, boolean emailstatus,
			boolean avatarstatus, boolean adminid, short groupid,
			Integer groupexpiry, String extgroupids, long regdate,
			Integer credits, short newpm, short newprompt, boolean accessmasks,
			boolean allowadmincp, boolean onlyacceptfriendpm,
			boolean conisbind, String token, long lastLoginTime,
			long tokenCreateTime) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobil = mobil;
		this.sex = sex;
		this.status = status;
		this.salt = salt;
		this.emailstatus = emailstatus;
		this.avatarstatus = avatarstatus;
		this.adminid = adminid;
		this.groupid = groupid;
		this.groupexpiry = groupexpiry;
		this.extgroupids = extgroupids;
		this.regdate = regdate;
		this.credits = credits;
		this.newpm = newpm;
		this.newprompt = newprompt;
		this.accessmasks = accessmasks;
		this.allowadmincp = allowadmincp;
		this.onlyacceptfriendpm = onlyacceptfriendpm;
		this.conisbind = conisbind;
		this.token = token;
		this.lastLoginTime = lastLoginTime;
		this.tokenCreateTime = tokenCreateTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobil() {
		return this.mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean getEmailstatus() {
		return this.emailstatus;
	}

	public void setEmailstatus(boolean emailstatus) {
		this.emailstatus = emailstatus;
	}

	public boolean getAvatarstatus() {
		return this.avatarstatus;
	}

	public void setAvatarstatus(boolean avatarstatus) {
		this.avatarstatus = avatarstatus;
	}

	public boolean getAdminid() {
		return this.adminid;
	}

	public void setAdminid(boolean adminid) {
		this.adminid = adminid;
	}

	public short getGroupid() {
		return this.groupid;
	}

	public void setGroupid(short groupid) {
		this.groupid = groupid;
	}

	public Integer getGroupexpiry() {
		return this.groupexpiry;
	}

	public void setGroupexpiry(Integer groupexpiry) {
		this.groupexpiry = groupexpiry;
	}

	public String getExtgroupids() {
		return this.extgroupids;
	}

	public void setExtgroupids(String extgroupids) {
		this.extgroupids = extgroupids;
	}

	public long getRegdate() {
		return this.regdate;
	}

	public void setRegdate(long regdate) {
		this.regdate = regdate;
	}

	public Integer getCredits() {
		return this.credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public short getNewpm() {
		return this.newpm;
	}

	public void setNewpm(short newpm) {
		this.newpm = newpm;
	}

	public short getNewprompt() {
		return this.newprompt;
	}

	public void setNewprompt(short newprompt) {
		this.newprompt = newprompt;
	}

	public boolean getAccessmasks() {
		return this.accessmasks;
	}

	public void setAccessmasks(boolean accessmasks) {
		this.accessmasks = accessmasks;
	}

	public boolean getAllowadmincp() {
		return this.allowadmincp;
	}

	public void setAllowadmincp(boolean allowadmincp) {
		this.allowadmincp = allowadmincp;
	}

	public boolean getOnlyacceptfriendpm() {
		return this.onlyacceptfriendpm;
	}

	public void setOnlyacceptfriendpm(boolean onlyacceptfriendpm) {
		this.onlyacceptfriendpm = onlyacceptfriendpm;
	}

	public boolean getConisbind() {
		return this.conisbind;
	}

	public void setConisbind(boolean conisbind) {
		this.conisbind = conisbind;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public long getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public long getTokenCreateTime() {
		return this.tokenCreateTime;
	}

	public void setTokenCreateTime(long tokenCreateTime) {
		this.tokenCreateTime = tokenCreateTime;
	}

}