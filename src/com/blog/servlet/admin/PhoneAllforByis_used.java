package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IPhotoService;
import com.blog.service.impl.PhotoService;

public class PhoneAllforByis_used extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int p_id = Integer.parseInt(request.getParameter("p_id"));
		int is_used =Integer.parseInt(request.getParameter("is_used"));
		String cPage = request.getParameter("currentPage");
		
		 IPhotoService photoService=new PhotoService();
		 boolean falg = photoService.PhotosByis_used(p_id, is_used);
		
		if(falg){
			if(is_used==0){
				System.out.println("��Ƭɾ���ɹ�");
				response.getWriter().println("<script>alert('��Ƭɾ���ɹ�');location.href='PhotosAllServlet?currentPage="+cPage+"'</script>");
			}else{
				System.out.println("��Ƭ�ָ��ɹ�");
				response.getWriter().println("<script>alert('��Ƭ�ָ��ɹ�');location.href='PhotosAllServlet?currentPage="+cPage+"'</script>");
			}
		}else{
			System.out.println("����");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}