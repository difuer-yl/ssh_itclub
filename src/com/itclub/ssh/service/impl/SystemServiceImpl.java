package com.itclub.ssh.service.impl;

import java.util.List;

import com.itclub.ssh.dao.SystemDao;
import com.itclub.ssh.domain.AdminMenu;
import com.itclub.ssh.service.SystemService;

public class SystemServiceImpl implements SystemService {

	private SystemDao systemDao;

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public void addCategory(AdminMenu adminMenu) {
		systemDao.saveCategory(adminMenu);
		
	}

	@Override
	public List getCategory() {
		List list=systemDao.findCategoryByLevel(1);
		return list;
	}
	
}
