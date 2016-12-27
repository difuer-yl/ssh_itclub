package com.itclub.ssh.service.impl;

import java.util.List;

import com.itclub.ssh.dao.IndexDao;
import com.itclub.ssh.service.IndexService;

public class IndexServiceImpl implements IndexService {
	private IndexDao indexDao;

	public void setIndexDao(IndexDao indexDao) {
		this.indexDao = indexDao;
	}

	@Override
	public List getFriendlinks() {
		List list=indexDao.findAllFriendlink();
		
		return list;
	}
	
}
