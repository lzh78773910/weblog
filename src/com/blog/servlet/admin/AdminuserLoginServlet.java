package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.blog.Iservice.IAdminuserService;
import com.blog.bean.Adminuser;
import com.blog.service.impl.AdminuserService;
import com.blog.util.MD5Encrypt;

public class AdminuserLoginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a_name = request.getParameter("adminname");
		String a_pass = request.getParameter("adminpass");
		
		IAdminuserService login = new AdminuserService();
		Adminuser islogin = login.isAdminUserByname(a_name);
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		JSONObject jsonObject =null;
		if (islogin != null) {
			if(MD5Encrypt.validatePassword(a_pass, islogin.getA_pass())){
				session.setAttribute("a_id", islogin.getA_id());
				session.setAttribute("aname", islogin.getA_name());
				session.setAttribute("sname", islogin.getA_nickname());
				jsonObject = new JSONObject("{flag:true}");
			}else{
				System.out.println("√‹¬Î¥ÌŒÛ");
				jsonObject = new JSONObject("{flag:false}");
			}
		} else {
			System.out.println("’À∫≈¥ÌŒÛ");
			jsonObject = new JSONObject("{flag:false}");
			// out.println("<script>alert('√‹¬Î¥ÌŒÛ£¨«Î÷ÿ–¬µ«¬º');location.href='admin/adminlogin.jsp'</script>");
		}
		out.print(jsonObject);
	    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
