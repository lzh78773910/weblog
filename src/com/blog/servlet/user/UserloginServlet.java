package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.blog.Iservice.IUserService;
import com.blog.bean.User;
import com.blog.service.impl.UserService;
import com.blog.util.MD5Encrypt;

public class UserloginServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String u_name = request.getParameter("u_name");
		String u_pass = request.getParameter("u_pass");
		JSONObject jsonObject =null;
		IUserService iUserService=new UserService();
		User user = iUserService.UserByname(u_name);
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
	
		if (user != null) {
			if(MD5Encrypt.validatePassword(u_pass, user.getU_pass())){
				
				//response.sendRedirect("user/u_index.jsp");
				if(user.getIs_used()==false){
					jsonObject = new JSONObject("{flag:ÕËºÅ±»Í£ÓÃ}");
					out.print(jsonObject);
					return;
				}
				session.setAttribute("u_id", user.getU_id());
				session.setAttribute("u_name", user.getU_name());
				session.setAttribute("u_nickname",user.getU_nickname());
				jsonObject = new JSONObject("{flag:true}");
				
			}else{
				System.out.println("ÃÜÂë´íÎó");
				jsonObject = new JSONObject("{flag:ÕËºÅ»òÕßÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼}");
				//out.println("<script>alert('ÕËºÅ»òÕßÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼');location.href='/weblog/user/u_index.jsp'</script>");
			}
		} else {
			System.out.println("ÕËºÅ´íÎó");
			jsonObject = new JSONObject("{flag:ÕËºÅ»òÕßÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼}");
			//out.println("<script>alert('ÕËºÅ»òÕßÃÜÂë´íÎó£¬ÇëÖØĞÂµÇÂ¼');location.href='/weblog/user/u_index.jsp'</script>");
		}
		out.print(jsonObject);
	    }

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doGet(request, response);
	}

}
