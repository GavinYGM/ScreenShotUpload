package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UpLoad extends javax.servlet.http.HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 初始化
		request.setCharacterEncoding("GBK");
		SmartUpload smartUpload = new SmartUpload();
		ServletConfig config = this.getServletConfig();
		smartUpload.initialize(config, request, response);
		String saveDirectory = this.getServletContext().getRealPath("")
              + "\\upload";
		
		try {
			// 上传文件
			smartUpload.upload();
			String stuname = smartUpload.getRequest().getParameter("stuname");
			System.out.println("name:  "+stuname);
			if(!check(stuname)){
				throw new Exception();
			}
			
			
			
			// 得到上传的文件对象
			com.jspsmart.upload.File smartFile = smartUpload.getFiles().getFile(0);
			String message = "";
			String fileName = smartFile.getFileName();
			
			String afterName=fileName.substring(fileName.lastIndexOf("."));
			
//			stuname = new String(stuname.getBytes(),"utf-8");
			
	        System.out.println(afterName);
	        if(!(afterName.toLowerCase().equals(".jpg")||afterName.toLowerCase().equals(".png")||afterName.toLowerCase().equals(".jpeg"))){
	        	throw new Exception();
	        }
	        
	        afterName=stuname+afterName;
	        System.out.println(saveDirectory + "\\"+afterName);
	        
	        
			// 保存文件
			smartFile.saveAs(saveDirectory + "\\"+afterName, SmartUpload.SAVE_AUTO);
			// 传过来的注册数据
			// 只需要new SmartUpload().getRequest().getParameter(""))就能获取到相应的表单数据
			System.out.println(afterName);
			message=afterName;
			request.setAttribute("message", message);
			//int i=1/0;//异常检验
			
			request.getRequestDispatcher("/upload.jsp").forward(request,
                  response);
			
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("/index.jsp").forward(request,
	                  response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("/index.jsp").forward(request,
	                  response);
		}
	}

	
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);
    }
    public boolean check(String name) {
		String[] names={"韩东燊",
				"徐畅",
				"杨梓龙",
				"张志鹏",
				"邓惠东",
				"曾欢",
				"孙懿恺",
				"杨高明",
				"汪志成",
				"燕航",
				"陈浩",
				"罗振纲",
				"姜盛鹏",
				"王彦",
				"刘子晗",
				"徐梓涵",
				"农琛宇",
				"刘耀辉",
				"欧阳涛",
				"钟文汉",
				"郑智茗",
				"方泽宁",
				"杨益",
				"袁昊翔",
				"王嘉玮",
				"翁政",
				"稂腾煌",
				"鄢武",
				"卢金浩",
				"万卉",
				"许瀚元",
				"张如意",
				"韩文丽"};
    	for (String string : names) {
			if (string.equals(name)) {
				return true;
			}
		}
    	return false;
	}
}
