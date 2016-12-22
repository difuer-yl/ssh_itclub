package com.itclub.ssh.action.interceptor;

import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.itclub.ssh.dao.MemberDao;
import com.itclub.ssh.dao.impl.MemberDaoImpl;
import com.itclub.ssh.domain.Member;
import com.itclub.ssh.service.MemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * ��管理员登录拦截器
 * 
 * @author chiaki
 */
public class UserLoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		
		
		// ��ȡActionContext
		ActionContext context = invocation.getInvocationContext();
		MemberDao memberDao = new MemberDaoImpl();
		// ��ȡMap���͵�session
		Map<String, Object> session = context.getSession();
		// �ж��û��Ƿ��¼
		if ("POST".equalsIgnoreCase(ServletActionContext.getRequest()
				.getMethod()) || session.get("ADMIN_MEMBER") != null) {
			// ����ִ�з���
			return invocation.invoke();
		}
		Cookie[] map = ServletActionContext.getRequest().getCookies();
		String m = null;
		for (Cookie c : map) {
			if ("ITCLUB_AUTO_TOKEN".equalsIgnoreCase(c.getName())) {
				m = c.getValue();
				break;
			}
		}
		if (m != null){
			String ip=ServletActionContext.getRequest().getHeader("HOST");
			System.out.println(ip);
			Member mb = memberService.autoLogin(m);
			if (mb != null) {
				ActionContext.getContext().getSession().put("ADMIN_MEMBER", mb);
				return invocation.invoke();
			}
		}

		return "login";

		// ���ص�¼

	}
}
