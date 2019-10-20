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
		// ��ʼ��
		request.setCharacterEncoding("GBK");
		SmartUpload smartUpload = new SmartUpload();
		ServletConfig config = this.getServletConfig();
		smartUpload.initialize(config, request, response);
		String saveDirectory = this.getServletContext().getRealPath("")
              + "\\upload";
		
		try {
			// �ϴ��ļ�
			smartUpload.upload();
			String stuname = smartUpload.getRequest().getParameter("stuname");
			System.out.println("name:  "+stuname);
			if(!check(stuname)){
				throw new Exception();
			}
			
			
			
			// �õ��ϴ����ļ�����
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
	        
	        
			// �����ļ�
			smartFile.saveAs(saveDirectory + "\\"+afterName, SmartUpload.SAVE_AUTO);
			// ��������ע������
			// ֻ��Ҫnew SmartUpload().getRequest().getParameter(""))���ܻ�ȡ����Ӧ�ı�����
			System.out.println(afterName);
			message=afterName;
			request.setAttribute("message", message);
			//int i=1/0;//�쳣����
			
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
		String[] names={"������",
				"�쳩",
				"������",
				"��־��",
				"�˻ݶ�",
				"����",
				"��ܲ��",
				"�����",
				"��־��",
				"�ຽ",
				"�º�",
				"�����",
				"��ʢ��",
				"����",
				"������",
				"������",
				"ũ���",
				"��ҫ��",
				"ŷ����",
				"���ĺ�",
				"֣����",
				"������",
				"����",
				"Ԭ���",
				"������",
				"����",
				"���ڻ�",
				"۳��",
				"¬���",
				"���",
				"���Ԫ",
				"������",
				"������"};
    	for (String string : names) {
			if (string.equals(name)) {
				return true;
			}
		}
    	return false;
	}
}
