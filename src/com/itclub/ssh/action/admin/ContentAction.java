package com.itclub.ssh.action.admin;

import com.itclub.ssh.service.ContentService;
import com.opensymphony.xwork2.ActionSupport;

public class ContentAction extends ActionSupport {
	
	private ContentService contentService;

	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}
	 
	
}
