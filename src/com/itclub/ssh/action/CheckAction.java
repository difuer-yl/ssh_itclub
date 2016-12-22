/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itclub.ssh.action;

import java.io.InputStream;
import java.io.StringBufferInputStream;

import com.itclub.ssh.dao.MemberDao;
import com.itclub.ssh.dao.impl.MemberDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author chiaki
 */
public class CheckAction extends ActionSupport {

    private String checkNameSuccess = "false";
    private String username = "";
    private String email = "";
    private String invitationCode="";
    private InputStream inputStream;
    MemberDao memberDao = new MemberDaoImpl();
    InvitationDao invitationDao=new InvitationDaoImpl();

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
    /**
     * 验证用户名是否存在
     * @return
     * @throws Exception 
     */
    @Override
    public String execute() throws Exception {
        String s = "false";
        if (!"".equalsIgnoreCase(this.getUsername())) {
            s = memberDao.checkUserName(this.getUsername());
        } else if(!"".equalsIgnoreCase(this.getEmail())){
            s = memberDao.checkEmail(this.getEmail());
        }else{
            s=invitationDao.getStatusByCode(this.getInvitationCode())==0?"false":"true";
        }
        inputStream = new StringBufferInputStream(s);
        return "checkMember";
    }

    public String getCheckNameSuccess() {
        return checkNameSuccess;
    }

    public void setCheckNameSuccess(String checkNameSuccess) {
        this.checkNameSuccess = checkNameSuccess;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }
    
}
