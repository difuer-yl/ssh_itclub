/**
 * @author chiaki
 *
 */
package com.itclub.ssh.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.itclub.ssh.util.MD5;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class UploadUtilAction extends ActionSupport {  
	private File filedata;// 上传的文件（此名称默认，如想修改请修改uploadify的fileObjName选项）
	private String filedataFileName;// 上传的文件名
	private String filedataContentType;// 上传文件类型的属性
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getFiledata() {
		return filedata;
	}

	public void setFiledata(File filedata) {
		this.filedata = filedata;
	}

	public String getFiledataFileName() {
		return filedataFileName;
	}

	public void setFiledataFileName(String filedataFileName) {
		this.filedataFileName = filedataFileName;
	}

	public String getFiledataContentType() {
		return filedataContentType;
	}

	public void setFiledataContentType(String filedataContentType) {
		this.filedataContentType = filedataContentType;
	}
	/**
	 * 上传文件
	 * @throws IOException 
	 * 
	 * @since 2014-1-16
	 */
	public String uploadFile() throws IOException {

		// 如果有文件
		if (filedata != null) {
			ActionContext ac = ActionContext.getContext();   
			ServletContext sc = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);   
			String path = sc.getRealPath("/");  
			// 创建存放路径
			String filePathDir =path+"\\upload";//需用双反斜杠'\\'			
			//根据路径创建文件夹对象
			File importSaveFile=new File(filePathDir);
			
			if(!importSaveFile.exists()){
				importSaveFile.mkdirs();//如果目录不存在就创建
			}
			boolean b=importSaveFile.setWritable(true);
			System.out.println(b);
			//文件名+后缀
			String saveFileName="itclub_"+MD5.stringMD5(filedataFileName+new Date().getTime())+"."+FilenameUtils.getExtension(filedataFileName);
			
			File tarFile=new File(filePathDir+"//"+saveFileName);
			FileUtils.copyFile(filedata, tarFile);
			System.out.println(tarFile.getAbsolutePath());
			inputStream=new StringBufferInputStream("\\itclub\\upload\\"+saveFileName);
			
		}
		return SUCCESS;
	}
}  