package com.itclub.ssh.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.itclub.ssh.domain.AdminMenu;
import com.itclub.ssh.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SystemAcion extends ActionSupport implements
		ModelDriven<AdminMenu> {

	AdminMenu adminMenu = new AdminMenu();
	List<AdminMenu> adminMenuList=new ArrayList();
	

	public void setAdminMenuList(List<AdminMenu> adminMenuList) {
		this.adminMenuList = adminMenuList;
	}

	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public String category() {

		return "category";
	}

	public String category_add() {
		
		adminMenuList=systemService.getCategory();
		return "category_add";
	}

	public String category_add_success() {
		systemService.addCategory(adminMenu);
		return "category_add";
	}

	@Override
	public AdminMenu getModel() {
		return adminMenu;
	}
}
