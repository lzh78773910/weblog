package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IUserService;
import com.blog.bean.User;
import com.blog.service.impl.UserService;
import com.blog.util.MD5Encrypt;

public class ZhaoHuiPassServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u_name = request.getParameter("u_name");
		String u_pass = request.getParameter("u_pass");//新密码
		String u_problem = request.getParameter("u_problem");   
		String u_answer = request.getParameter("u_answer");

		IUserService iUserService=new UserService();
		User user = iUserService.UserByname(u_name);
		if(user.getU_problem().equals(u_problem)&&user.getU_answer().equals(u_answer)){
			User user2=new User();
			user2.setU_pass(MD5Encrypt.encryptByMD5(u_pass));
			user2.setU_id(user.getU_id());
			boolean falg = iUserService.Change_a_pass(user2, user.getU_id());
			if(falg){
				System.out.println("密码修改成功");
				out.println("<script>alert('密码修改成功');location.href='UserIndexServlet'</script>");
			}else{
				System.out.println("密码修改失败");
				out.println("<script>alert('密码修改失败');location.href='/weblog/user/u_retrieve.jsp'</script>");
			}
		}else{
			out.println("<script>alert('密保校验错误');location.href='/weblog/user/u_retrieve.jsp'</script>");
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
