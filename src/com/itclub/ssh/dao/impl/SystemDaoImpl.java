package com.itclub.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itclub.ssh.dao.SystemDao;
import com.itclub.ssh.domain.AdminMenu;

public class SystemDaoImpl extends HibernateDaoSupport implements SystemDao {

	@Override
	public void saveCategory(AdminMenu adminMenu) {
		this.getHibernateTemplate().save(adminMenu);
		
	}

	@Override
	public List findCategoryByLevel(int level) {
		List list=getHibernateTemplate().find("from AdminMenu where level=? ", level);
		
		return list;
	}

}
