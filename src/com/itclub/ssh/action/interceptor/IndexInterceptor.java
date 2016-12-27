package com.itclub.ssh.action.interceptor;

import java.util.Map;

import com.itclub.ssh.service.SystemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * ��管理员登录拦截器
 * @author chiaki
 */
public class IndexInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1L;
	private SystemService systemService;
	
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// ��ȡActionContext
		ActionContext context = invocation.getInvocationContext();
		// ��ȡMap���͵�session
		Map<String, Object> session = context.getSession();
		// �ж��û��Ƿ��¼ 
		if(session.get("SETTINGS") == null){
             Map list=systemService.getSetting();
             session.put("SETTINGS", list);
             
             
		}
		// ���ص�¼
			return invocation.invoke();
	}
}
