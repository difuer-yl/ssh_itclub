package com.itclub.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itclub.ssh.dao.IndexDao;

public class IndexDaoImpl extends HibernateDaoSupport implements IndexDao {

	@Override
	public List findAllFriendlink() {
		List list=getHibernateTemplate().find("from Friendlink");
		return list;
	}

}
