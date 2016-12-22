package com.itclub.ssh.util;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport{
	// 保存文件的目录
		private static String PATH_FOLDER = "/";
		// 存放临时文件的目录
		private static String TEMP_FOLDER = "/";
		@Override
		public String execute() throws Exception {
			HttpServletRequest request;
//			request.setCharacterEncoding("utf-8"); // 设置编码
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("text/html;charset=UTF-8");
			// 获得磁盘文件条目工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			
			// 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
			// 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
			/**
			 * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem
			 * 格式的 然后再将其真正写到 对应目录的硬盘上
			 */
			factory.setRepository(new File(TEMP_FOLDER));
			// 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
			factory.setSizeThreshold(1024 * 1024);

			// 高水平的API文件上传处理
			ServletFileUpload upload = new ServletFileUpload(factory);
			
			try {
				// 提交上来的信息都在这个list里面
				// 这意味着可以上传多个文件
				// 请自行组织代码
				List<FileItem> list = upload.parseRequest(request);
				// 获取上传的文件
				FileItem item = getUploadFileItem(list);
				// 获取文件名
				String filename = getUploadFileName(item);
				// 保存后的文件名
				String saveName = new Date().getTime() + filename.substring(filename.lastIndexOf("."));
				// 保存后图片的浏览器访问路径
				String picUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/upload/"+saveName;

				System.out.println("存放目录:" + PATH_FOLDER);
				System.out.println("文件名:" + filename);
				System.out.println("浏览器访问路径:" + picUrl);

				// 真正写到磁盘上
				item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的
				
				PrintWriter writer = response.getWriter();
				
				writer.print("{");
				writer.print("msg:\"文件大小:"+item.getSize()+",文件名:"+filename+"\"");
				writer.print(",picUrl:\"" + picUrl + "\"");
				writer.print("}");
				
				writer.close();
			
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		private FileItem getUploadFileItem(List<FileItem> list) {
			for (FileItem fileItem : list) {
				if(!fileItem.isFormField()) {
					return fileItem;
				}
			}
			return null;
		}
		
		private String getUploadFileName(FileItem item) {
			// 获取路径名
			String value = item.getName();
			// 索引到最后一个反斜杠
			int start = value.lastIndexOf("/");
			// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
			String filename = value.substring(start + 1);
			
			return filename;
		}
}
