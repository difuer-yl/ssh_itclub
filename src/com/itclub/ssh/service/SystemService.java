package com.itclub.ssh.service;

import java.util.List;
import java.util.Map;

import com.itclub.ssh.domain.AdminMenu;

public interface SystemService {

	void addCategory(AdminMenu adminMenu);

	List getCategory();
	
	Map getSetting();

	List<AdminMenu> getCategoryTopLevel();

	AdminMenu getCategoryById(int id);

	void updateCategory(AdminMenu adminMenu);

	String deleteMenu(int id);

}
