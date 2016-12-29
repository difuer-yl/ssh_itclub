/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itclub.ssh.action;


import java.io.InputStream;

import com.itclub.ssh.domain.Invitation;
import com.itclub.ssh.domain.Member;
import com.itclub.ssh.service.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 前台用户Action
 * @author luoyu <chiaki@difuer.com>
 */
public class MemberAction extends ActionSupport implements ModelDriven<Member> {

    /**
     *
     */
    Member member = new Member();
    private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	private String invitationCode;
	
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	private String agree;
	public void setAgree(String agree) {
		this.agree = agree;
	}
	
	private String code;
	
	public void setCode(String code) {
		this.code = code;
	}
	
	private InputStream inputStream;
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	/**
     * 登录页
     * @return 
     */
    public String login() {
        return "login";
    }
    /**
     * 登录
     * @return 
     */
    public String login_success() {

        String r = (String) ActionContext.getContext().getSession().get("SESSION_SECURITY_CODE");
        if (!r.equalsIgnoreCase(checkcode)) {
            this.addActionError("验证码不正确");
            return "login";
        }
         Member mb = memberService.login(member.getUsername(), member.getPassword());
         if(mb!=null){
        	 ActionContext.getContext().getSession().put("MEMBER_INFO", mb);
        	 return "login_success";
         }else{
        	 this.addActionError("用户名或密码错误");
        	 return INPUT;
         }

    }
    /**
     * 注册页
     * @return 
     */
    public String regist() {
        return "regist";
    }
    /**
     * 注册
     * @return 
     */
    public String regist_success() {
    	Invitation invitation =memberService.getInvitationCode(invitationCode);
        if (invitation == null) {
            this.addActionError("请输入正确的邀请码");
            return "regist";
        }
        String r = (String) ActionContext.getContext().getSession().get("SESSION_SECURITY_CODE");
        if (!r.equalsIgnoreCase(checkcode)) {
            this.addActionError("验证码不正确");

            return "regist";
        }
        if (!"on".equalsIgnoreCase(agree)) {
            this.addActionError("请同意用户协议");
            return "regist";
        }
        System.out.println(agree);
        if (memberService.regist(member, invitation,true)) {

            return "regist_success";
        } else {
            this.addActionError("注册失败");
            return "regist";
        }
    }

	/**
     * 邀请码
     * @return 
     */
    public String invite(){
        
        return "invite";
    }
    
    
    
    /**
     * 退出
     * @return 
     */
    public String signout() {
        ActionContext.getContext().getSession().remove("MEMBER_INFO");
        return "signout";
    }
    
    public String activate(){
    	
    	if(memberService.activateMember(member.getUsername(),code)){
    		this.addActionMessage("激活成功！<a href='http://itclub.difuer.com:8080/member_login'>前去登录</a>");
    	}else{
    		this.addActionMessage("链接已失效！<a href='http://itclub.difuer.com:8080/member_login'>前去登录</a>");
    	}
    	
    	return "activate";
    }
    
    
    @Override
    public Member getModel() {
        return member;
    }

}
