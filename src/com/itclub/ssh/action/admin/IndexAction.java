/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itclub.ssh.action.admin;

import java.util.ArrayList;
import java.util.List;

import com.itclub.ssh.domain.AdminMenu;
import com.itclub.ssh.service.SystemService;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author chiaki
 */
public class IndexAction extends ActionSupport{

	private SystemService systemService;
    public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
    List<AdminMenu> menus=new ArrayList<>();
    
    
	public void setMenus(List<AdminMenu> menus) {
		this.menus = menus;
	}

	@Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String top(){
        return "top";
    }
    public String menu(){
    	List<AdminMenu> am=systemService.getCategory();
    	setMenus(am);
        return "menu";
    }
    public String main(){
        return "main";
    }
    public String welcome(){
        return SUCCESS;
    }
}
