package com.itclub.ssh.action.admin;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import com.itclub.ssh.domain.AdminMenu;
import com.itclub.ssh.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SystemAcion extends ActionSupport implements ModelDriven<AdminMenu> {

	AdminMenu adminMenu = new AdminMenu();
	public List<AdminMenu> adminMenuList = new ArrayList();

	public void setAdminMenuList(List<AdminMenu> adminMenuList) {
		this.adminMenuList = adminMenuList;
	}

	private SystemService systemService;

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public AdminMenu menu=new AdminMenu();
	public void setMenu(AdminMenu menu) {
		this.menu = menu;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String category() {
		List<AdminMenu> adminmenus = systemService.getCategory();
		setAdminMenuList(adminmenus);
		return "category";
	}

	public String category_add() {

		List<AdminMenu> adminmenus = systemService.getCategoryTopLevel();
		setAdminMenuList(adminmenus);
		return "category_add";
	}

	public String category_add_success() {
		systemService.addCategory(adminMenu);
		return "category_add";
	}
	
	public String category_edit() {
		setMenu(systemService.getCategoryById(adminMenu.getId()));
		List<AdminMenu> adminmenus = systemService.getCategoryTopLevel();
		setAdminMenuList(adminmenus);
		return "category_add";
	}

	public String category_edit_success() {
		systemService.updateCategory(adminMenu);
		return "category_add";
	}
	
	public String category_del() {
		String ms = systemService.deleteMenu(adminMenu.getId());
		inputStream = new StringBufferInputStream(ms);
		return "ajax";
	}
	
	
	
	public String base() {

		return "base";
	}

	@Override
	public AdminMenu getModel() {
		return adminMenu;
	}
}
