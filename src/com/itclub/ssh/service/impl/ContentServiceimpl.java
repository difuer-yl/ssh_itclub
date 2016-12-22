package com.itclub.ssh.service.impl;

import com.itclub.ssh.dao.ContentDao;
import com.itclub.ssh.service.ContentService;

public class ContentServiceimpl implements ContentService {
	
	private ContentDao contentDao;

	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	
	
	 
}
