package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IUserService;
import com.blog.bean.User;
import com.blog.service.impl.UserService;
import com.blog.util.MD5Encrypt;

public class PassUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u_pass = request.getParameter("u_pass");//原来密码答案
		String up_pass = request.getParameter("up_pass");//要修改的密码
		
		HttpSession session = request.getSession();
		String u_name =  (String) session.getAttribute("u_name");
		IUserService iUserService =new UserService();
		User user = iUserService.UserByname(u_name);
		
		if(MD5Encrypt.validatePassword(u_pass, user.getU_pass())){
			User user2=new User();
			user2.setU_pass(MD5Encrypt.encryptByMD5(up_pass));
			user2.setU_id(user.getU_id());
			boolean falg = iUserService.Change_a_pass(user2, user.getU_id());
			if(falg){
				System.out.println("密码修改成功");
				out.println("<script>alert('密码修改成功');location.href='UserObtainProtectServlet'</script>");
			}else{
				System.out.println("密码修改失败");
				out.println("<script>alert('密码修改失败');location.href='UserObtainProtectServlet'</script>");
			}
		}else{
			System.out.println("密码校验失败");
			out.println("<script>alert('密码校验失败');location.href='UserObtainProtectServlet'</script>");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
