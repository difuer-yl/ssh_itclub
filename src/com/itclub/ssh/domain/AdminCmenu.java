package com.itclub.ssh.domain;

/**
 * AdminCmenu entity. @author MyEclipse Persistence Tools
 */

public class AdminCmenu implements java.io.Serializable {

	// Fields

	private short id;
	private String title;
	private String url;
	private boolean sort;
	private short displayorder;
	private short clicks;
	private Integer uid;
	private Integer dateline;

	// Constructors

	/** default constructor */
	public AdminCmenu() {
	}

	/** minimal constructor */
	public AdminCmenu(String title, String url, short displayorder,
			Integer uid, Integer dateline) {
		this.title = title;
		this.url = url;
		this.displayorder = displayorder;
		this.uid = uid;
		this.dateline = dateline;
	}

	/** full constructor */
	public AdminCmenu(String title, String url, boolean sort,
			short displayorder, short clicks, Integer uid, Integer dateline) {
		this.title = title;
		this.url = url;
		this.sort = sort;
		this.displayorder = displayorder;
		this.clicks = clicks;
		this.uid = uid;
		this.dateline = dateline;
	}

	// Property accessors

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean getSort() {
		return this.sort;
	}

	public void setSort(boolean sort) {
		this.sort = sort;
	}

	public short getDisplayorder() {
		return this.displayorder;
	}

	public void setDisplayorder(short displayorder) {
		this.displayorder = displayorder;
	}

	public short getClicks() {
		return this.clicks;
	}

	public void setClicks(short clicks) {
		this.clicks = clicks;
	}

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getDateline() {
		return this.dateline;
	}

	public void setDateline(Integer dateline) {
		this.dateline = dateline;
	}

}