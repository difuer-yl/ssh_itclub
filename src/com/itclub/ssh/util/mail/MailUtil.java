package com.itclub.ssh.util.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MailUtil {
	public static void main(String[] args){   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //这个类主要是设置邮件   
     MailSenderInfo mailInfo = new MailSenderInfo();    
     mailInfo.setMailServerHost("smtp.mxhichina.com");    
     mailInfo.setMailServerPort("25");    
     mailInfo.setValidate(true);    
     mailInfo.setUserName("chiaki@difuer.com");    
     mailInfo.setPassword("luoyu@1314520");//您的邮箱密码    
     mailInfo.setFromAddress("chiaki@difuer.com");    
     mailInfo.setToAddress("3039067847@qq.com");    
     mailInfo.setSubject("itclub帐号注册激活邮件");    
     mailInfo.setContent("<table  style=\"margin:0 auto;color:#555; font:16px/26px '微软雅黑','宋体',Arail; \" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> "
     		+ "<tbody>"
     		+ "<tr> "
     		+ "<td style=\"height:62px; background-color:#019875; padding:10px 0 0 10px;\">"
     		+ " <a href=\"http://itclub.difuer.com:8080\" target=\"_blank\"><img width=\"229\" height=\"43\" style=\"border:none;margin-left:10px;\" src=\"http://itclub.difuer.com:8080/images/LOGO1.png\"></a><span>专业的IT论坛</span> </td> "
     		+ "</tr> "
     		+ "<tr style=\"background-color:#fff;\"> "
     		+ "<td style=\"padding:10px 38px;\"> <div style=\"margin:20px 0;\">"
     		+ "  欢迎加入ITclub"
     		+ "<br> 感谢您申请注册ITclub账号! 请点击链接完成注册：<br/><br/>"
     		+ "<a href=\"\">点击验证</a>"
     		+ "</div> 如果上述文字点击无效，请把下面网页地址复制到浏览器地址栏中打开： <br> "
     		+ "<div style=\" word-break:break-all;word-wrap:break-word;\"> <br>"
     		+ " </div>  <div> 祝你在ITclub过得愉快！</div> "
     		+ "<div style=\"margin:20px 0;\">ITclub管理团队 <br> "
     		+ "<span style=\"border-bottom-color: rgb(204, 204, 204); border-bottom-width: 1px; border-bottom-style: dashed; position: relative;\" t=\"5\" times=\"\">"
     		+  df.format(new Date())
     		+ "</span> </div> "
     		+ "<div style=\"color:#c5c5c5; font-size:12px; border-top:1px solid #e6e6e6; padding:7px 0; line-height:20px;\">"
     		+ "本邮件是用户注册ITclub后系统自动发出，如果你并未注册ITclub，可能是因为其他用户误输入了你的邮箱地址而使你收到了这封邮件，请忽略！</div> "
     		+ "<div style=\"font-size:12px; color:#999;line-height:20px;border-top:1px solid #e6e6e6;padding:10px 0;\">"
     		+ "如有任何问题，可以与我们联系，我们将尽快为你解答。<br> Email：<a href=\"mailto:\" target=\"_blank\">mail</a> "
     		+ "</div> </td> </tr> </tbody></table>  ");  
        //这个类主要来发送邮件   
     SimpleMailSender sms = new SimpleMailSender();   
//         sms.sendTextMail(mailInfo);//发送文体格式    
         sms.sendHtmlMail(mailInfo);//发送html格式   
   }   
	public static void  sendMail(String mialAddress,String url){
		MailSenderInfo mailInfo = new MailSenderInfo();    
	     mailInfo.setMailServerHost("smtp.mxhichina.com");    
	     mailInfo.setMailServerPort("25");    
	     mailInfo.setValidate(true);    
	     mailInfo.setUserName("chiaki@difuer.com");    
	     mailInfo.setPassword("luoyu@1314520");//您的邮箱密码    
	     mailInfo.setFromAddress("chiaki@difuer.com");    
	     mailInfo.setToAddress(mialAddress);    
	     mailInfo.setSubject("itclub帐号注册激活邮件");    
	     mailInfo.setContent("<table  style=\"margin:0 auto;color:#555; font:16px/26px '微软雅黑','宋体',Arail; \" border=\"0\" cellspacing=\"0\" cellpadding=\"0\"> "
	     		+ "<tbody>"
	     		+ "<tr> "
	     		+ "<td style=\"height:62px; background-color:#019875; padding:10px 0 0 10px;\">"
	     		+ " <a href=\"http://itclub.difuer.com:8080\" target=\"_blank\"><img width=\"229\" height=\"43\" style=\"border:none;margin-left:10px;\" src=\"http://itclub.difuer.com:8080/images/LOGO1.png\"></a><span>专业的IT论坛</span> </td> "
	     		+ "</tr> "
	     		+ "<tr style=\"background-color:#fff;\"> "
	     		+ "<td style=\"padding:10px 38px;\"> <div style=\"margin:20px 0;\">"
	     		+ "  欢迎加入ITclub"
	     		+ "<br> 感谢您申请注册ITclub账号! 请点击链接完成注册：<br/><br/>"
	     		+ "<a href="+url+">点击验证</a>"
	     		+ "</div> 如果上述文字点击无效，请把下面网页地址复制到浏览器地址栏中打开： <br> "
	     		+ "<div style=\" word-break:break-all;word-wrap:break-word;\"> <br>"
	     		+url+ " </div>  <div> 祝你在ITclub过得愉快！</div> "
	     		+ "<div style=\"margin:20px 0;\">ITclub管理团队 <br> "
	     		+ "<span style=\"border-bottom-color: rgb(204, 204, 204); border-bottom-width: 1px; border-bottom-style: dashed; position: relative;\" t=\"5\" times=\"\">"
	     		+ new Date().getYear()+"-"+new Date().getMonth()+"-"+new Date().getDay()
	     		+ "</span> </div> <div style=\"height:190px;margin:20px auto 20px auto;width:550px;\"> </div> "
	     		+ "<div style=\"color:#c5c5c5; font-size:12px; border-top:1px solid #e6e6e6; padding:7px 0; line-height:20px;\">"
	     		+ "本邮件是用户注册ITclub后系统自动发出，如果你并未注册ITclub，可能是因为其他用户误输入了你的邮箱地址而使你收到了这封邮件，请忽略！</div> "
	     		+ "<div style=\"font-size:12px; color:#999;line-height:20px;border-top:1px solid #e6e6e6;padding:10px 0;\">"
	     		+ "如有任何问题，可以与我们联系，我们将尽快为你解答。<br> Email：<a href=\"mailto:\" target=\"_blank\">mail</a> "
	     		+ "</div> </td> </tr> </tbody></table>  ");    
	        //这个类主要来发送邮件   
	     SimpleMailSender sms = new SimpleMailSender();   
//	         sms.sendTextMail(mailInfo);//发送文体格式    
	         sms.sendHtmlMail(mailInfo);//发送html格式  
	}
}
