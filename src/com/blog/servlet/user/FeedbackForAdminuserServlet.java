package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAdminuserService;
import com.blog.bean.Adminuser;
import com.blog.service.impl.AdminuserService;

public class FeedbackForAdminuserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             IAdminuserService iAdminuserService=new  AdminuserService();
             List<Adminuser> list = iAdminuserService.adminuserlist();
             
            	request.setAttribute("list", list);
	            request.getRequestDispatcher("/user/u_feedback.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
