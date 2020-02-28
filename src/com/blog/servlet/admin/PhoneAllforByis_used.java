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
				System.out.println("ÕÕÆ¬É¾³ý³É¹¦");
				response.getWriter().println("<script>alert('ÕÕÆ¬É¾³ý³É¹¦');location.href='PhotosAllServlet?currentPage="+cPage+"'</script>");
			}else{
				System.out.println("ÕÕÆ¬»Ö¸´³É¹¦");
				response.getWriter().println("<script>alert('ÕÕÆ¬»Ö¸´³É¹¦');location.href='PhotosAllServlet?currentPage="+cPage+"'</script>");
			}
		}else{
			System.out.println("´íÎó");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}