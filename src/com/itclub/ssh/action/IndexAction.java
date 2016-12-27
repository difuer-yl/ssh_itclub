package com.itclub.ssh.action;

import java.util.ArrayList;
import java.util.List;

import com.itclub.ssh.domain.Friendlink;
import com.itclub.ssh.service.IndexService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	private IndexService indexService;
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	private List<Friendlink> friendlinks=new ArrayList<Friendlink>();
	


	public List<Friendlink> getFriendlinks() {
		return friendlinks;
	}



	public void setFriendlinks(List<Friendlink> friendlinks) {
		this.friendlinks = friendlinks;
	}



	@Override
	public String execute() throws Exception {
		//friendlinks=indexService.getFriendlinks();
		List list =indexService.getFriendlinks();
		System.out.println(list.size());
		setFriendlinks(list);
		return SUCCESS;
	}
 
	

}
