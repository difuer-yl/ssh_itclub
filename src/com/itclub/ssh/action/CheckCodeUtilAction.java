package com.itclub.ssh.action;

import java.io.ByteArrayInputStream;
import java.util.Map;

import com.itclub.ssh.util.CheckCodeUtil;
import com.itclub.ssh.util.SecurityCodeUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 获得验证码
 * @author luoyu <chiaki@difuer.com>
 */
public class CheckCodeUtilAction extends ActionSupport {
    //图片流

    private ByteArrayInputStream imageStream;
    private String timestamp;//得到时间戳

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;

    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
//System.out.println("时间戳timestamp:"+this.timestamp);
    }

    @Override
    public String execute() throws Exception {
// TODO Auto-generated method stub
//如果开启Hard模式，可以不区分大小写
//String securityCode = SecurityCode.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();

//获取默认难度和长度的验证码
        String securityCode = SecurityCodeUtil.getSecurityCode();
        imageStream = CheckCodeUtil.getImageAsInputStream(securityCode);
        System.out.println("code=" + securityCode);
        //放入session中
        Map session = ActionContext.getContext().getSession();
        session.put("SESSION_SECURITY_CODE", securityCode);
        return SUCCESS;
    }

}
