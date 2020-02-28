package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAlbumsService;
import com.blog.Iservice.IUserService;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.UserService;

public class UserByis_used extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		int is_used =Integer.parseInt(request.getParameter("is_used"));
		String cPage = request.getParameter("currentPage");
		
		 IUserService Service=new UserService();
		 
		boolean falg = Service.userByis_used(u_id, is_used);
		if(falg){
			if(is_used==0){
				System.out.println("’À∫≈Õ£”√≥…π¶");
				response.getWriter().println("<script>alert('’À∫≈Õ£”√≥…π¶');location.href='UserListServlet?currentPage="+cPage+"'</script>");
			}else{
				System.out.println("’À∫≈ª÷∏¥≥…π¶");
				response.getWriter().println("<script>alert('’À∫≈ª÷∏¥≥…π¶');location.href='UserListServlet?currentPage="+cPage+"'</script>");
			}
		}else{
			System.out.println("¥ÌŒÛ");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
