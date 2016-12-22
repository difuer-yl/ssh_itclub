package com.itclub.ssh.service;

import java.util.List;

import com.itclub.ssh.domain.AdminMenu;

public interface SystemService {

	void addCategory(AdminMenu adminMenu);

	List getCategory();

}
