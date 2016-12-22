/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itclub.ssh.action.admin;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.itclub.ssh.domain.Member;
import com.itclub.ssh.service.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author chiaki
 */
public class MemberAction extends ActionSupport implements ModelDriven<Member> {

	Member member = new Member();
	// HttpServletRequest req = ServletActionContext.getRequest();
	List<Member> list = new ArrayList<Member>();

	private InputStream inputStream;
	private String checkcode;

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	private boolean auto;

	public void setAuto(boolean auto) {
		this.auto = auto;
	}

	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	/**
	 * 邀请码
	 * 
	 * @return
	 */
	public String invite() {

		return "invite";
	}

	/**
	 * 添加邀请码
	 * 
	 * @return
	 */
	public String inviteAdd() {
		InvitationDao itDao = new InvitationDaoImpl();
		itDao.add(1);
		return "invite";
	}

	/**
	 * 用户列表
	 * 
	 * @return
	 */
	public String list() {
		setList(memberService.list(true));
		return "list";
	}

	/**
	 * 逻辑删除用户列表
	 * 
	 * @return
	 */
	public String del_list() {
		setList(memberService.list(false));
		return "list";
	}

	/**
	 * 添加用户
	 * 
	 * @return
	 */
	public String add() {
		return "add";
	}

	/**
	 * 添加用户结果页
	 * 
	 * @return
	 */
	public String add_success() {
		boolean b = memberDao.regist(member, 0, false);
		String ms;
		if (b) {
			ms = ("添加成功！");
		} else {
			ms = ("添加失败！");
		}
		this.addActionMessage(ms);
		return "add_success";
	}

	/**
	 * 修改用户
	 * 
	 * @return
	 */
	public String edit() {
		list.add(memberService.edit(member.getId()));
		return "add";
	}

	/**
	 * 修改用户结果
	 * 
	 * @return
	 */
	public String edit_success() {
		boolean b = memberService.edit_success(member);
		String ms;
		if (b) {
			ms = ("修改成功！");
		} else {
			ms = ("修改失败！");
		}
		this.addActionMessage(ms);
		return "edit_success";
	}

	/**
	 * 逻辑删除用户
	 * 
	 * @return
	 */
	public String del() {
		String ms = memberService.updateStatus(member.getId(), false);
		inputStream = new StringBufferInputStream(ms);
		return "ajax";
	}

	/**
	 * 还原用户
	 * 
	 * @return
	 */
	public String Restore() {
		String id = req.getParameter("id");
		inputStream = new StringBufferInputStream(String.valueOf(memberDao
				.changeStatus(Integer.valueOf(id), true)));
		return "ajax";
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String login() {
		String r = (String) ActionContext.getContext().getSession()
				.get("SESSION_SECURITY_CODE");
		System.out.println(checkcode);
		if (checkcode == null || !checkcode.equalsIgnoreCase(r)) {
			this.addActionError("验证码不正确");
			return "login";
		}
		Member memberInfo = memberService.adminlogin(member.getUsername(),
				member.getPassword());
		if (memberInfo == null) {
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else {
			ActionContext.getContext().getSession()
					.put("ADMIN_MEMBER", memberInfo);
			if (auto) {
				String token = memberService.UpdateToken(memberInfo);
				ServletActionContext.getResponse().addCookie(
						new Cookie("ITCLUB_AUTO_TOKEN", token));
			}
			return SUCCESS;
		}
	}

	/**
	 * 退出
	 * 
	 * @return
	 */
	public String signout() {
		Member member = (Member) ActionContext.getContext().getSession()
				.get("ADMIN_MEMBER");
		ActionContext.getContext().getSession().remove("ADMIN_MEMBER");
		member.setToken("");
		memberService.UpdateToken(member);
		Cookie[] cookies = ServletActionContext.getRequest().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("ITCLUB_AUTO_TOKEN".equals(cookie.getName())) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
				}
			}
			Cookie cooie=new Cookie("ITCLUB_AUTO_TOKEN", null);
			cooie.setMaxAge(0);
			
			ServletActionContext.getResponse().addCookie(cooie);
		}
		return "login";
	}

	public String auto_login() {
		Cookie[] map = ServletActionContext.getRequest().getCookies();
		String m = null;
		for (Cookie c : map) {
			if ("ITCLUB_AUTO_TOKEN".equalsIgnoreCase(c.getName()))
				m = c.getValue();
		}
		if (m != null) {
			Member mb = memberService.autoLogin(m);
			if (mb != null) {
				ActionContext.getContext().getSession().put("ADMIN_MEMBER", mb);
			}else{
				
			}
		}
			return "login";
		
		
	}
	
	

	@Override
	public Member getModel() {
		return member;
	}

	public List<Member> getList() {
		return list;
	}

	public void setList(List<Member> list) {
		this.list = list;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
