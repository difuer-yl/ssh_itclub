package com.itclub.ssh.dao;

import java.util.List;

import com.itclub.ssh.domain.AdminMenu;

public interface SystemDao {

	void saveCategory(AdminMenu adminMenu);

	List findCategoryByLevel(int i);

}
