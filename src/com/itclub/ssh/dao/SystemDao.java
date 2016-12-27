package com.itclub.ssh.dao;

import java.util.List;

import com.itclub.ssh.domain.AdminMenu;

public interface SystemDao {

	void saveCategory(AdminMenu adminMenu);

	List findCategoryByLevel(int i);

	List findSettingAll();

	List findCategoryAll();

	int findMenuMaxRght();

	AdminMenu finMenuById(int id);

	void updateMenu(int key);

	void saveMenu(AdminMenu adminMenu);

	void moveMenu(AdminMenu adminMenu,int key);

	void deleteMenu(int lft, int rght);

	void updateMenuByDelete(int lft, int skew, int rght);

}
