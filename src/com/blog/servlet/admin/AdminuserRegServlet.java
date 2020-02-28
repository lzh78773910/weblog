package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.blog.Iservice.IAdminuserService;
import com.blog.bean.Adminuser;
import com.blog.service.impl.AdminuserService;
import com.blog.util.MD5Encrypt;

public class AdminuserRegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_name = request.getParameter("adminname");
		String a_pass = request.getParameter("adminpass");
		String a_nickname = request.getParameter("adminnickname");
		IAdminuserService dao = new AdminuserService();
		Adminuser adminuser =new Adminuser();
		adminuser.setA_name(a_name);
		adminuser.setA_pass(MD5Encrypt.encryptByMD5(a_pass) );
		adminuser.setA_nickname(a_nickname);
		JSONObject jsonObject =null;
		PrintWriter out = response.getWriter();
		boolean regAdminUser = dao.isRegAdminUser(adminuser);
		if(regAdminUser){
			System.out.println("×¢²á³É¹¦");
			jsonObject = new JSONObject("{flag:true}");
		}else{
			System.out.println("×¢²áÊ§°Ü");
			jsonObject = new JSONObject("{flag:false}");
		}
		out.print(jsonObject);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
