/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itclub.ssh.action.admin;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author chiaki
 */
public class IndexAction extends ActionSupport{

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }
    
    public String top(){
        return "top";
    }
    public String menu(){
        return "menu";
    }
    public String main(){
        return "main";
    }
    public String welcome(){
        return SUCCESS;
    }
}
