package com.itclub.javaee.action;

import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
  

import com.itclub.javaee.util.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;  
import com.opensymphony.xwork2.ActionSupport;  
  

public class UtilAction extends ActionSupport{  
      
    private static final long serialVersionUID = -7193209177116825032L;  
    private ByteArrayInputStream inputStream;   
      
    private int width;     
    private int height;     
    private int fontSize;     
    private int codeLength;   
    private int disturbType;  
      
    public String validNumGenerate() throws Exception{  
    	fontSize=4;
        RandomNumUtil rdnu=RandomNumUtil.Instance();      
        this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片      
        ActionContext.getContext().getSession().put("random", rdnu.getString());//取得随机字符串放入HttpSession      
        System.out.println(rdnu.getString());
        return SUCCESS;      
    }   
      
      
    public void setInputStream(ByteArrayInputStream inputStream) {      
        this.inputStream = inputStream;      
    }     
      
    public ByteArrayInputStream getInputStream() {      
        return inputStream;      
    }  
      
  
}  
