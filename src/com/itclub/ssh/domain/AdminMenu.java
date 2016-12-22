package com.itclub.ssh.domain;

/**
 * AdminMenu entity. @author MyEclipse Persistence Tools
 */

public class AdminMenu implements java.io.Serializable {

	// Fields

	private int id;
	private String name;
	private String path;
	private int parentId;
	private int lft;
	private int rght;
	private int level;
	private String intro;
	private int status;
	private String icon;
	private int sort;

	// Constructors

	/** default constructor */
	public AdminMenu() {
	}

	/** minimal constructor */
	public AdminMenu(String name, String path, int parentId, int level,
			int status) {
		this.name = name;
		this.path = path;
		this.parentId = parentId;
		this.level = level;
		this.status = status;
	}

	/** full constructor */
	public AdminMenu(String name, String path, int parentId, int lft,
			int rght, int level, String intro, int status, String icon,
			int sort) {
		this.name = name;
		this.path = path;
		this.parentId = parentId;
		this.lft = lft;
		this.rght = rght;
		this.level = level;
		this.intro = intro;
		this.status = status;
		this.icon = icon;
		this.sort = sort;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getParentId() {
		return this.parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getLft() {
		return this.lft;
	}

	public void setLft(int lft) {
		this.lft = lft;
	}

	public int getRght() {
		return this.rght;
	}

	public void setRght(int rght) {
		this.rght = rght;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getIntro() {
		return this.intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}