package com.blog.servlet.user;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.naming.SizeLimitExceededException;
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



public class UserRegServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u_name = request.getParameter("u_name");
		String u_pass = request.getParameter("u_pass");
		String u_problem = request.getParameter("u_problem");   
		String u_answer = request.getParameter("u_answer");
		String ValidateCode = request.getParameter("ValidateCode");
		String u_nickname=u_name;
		
	  	HttpSession session = request.getSession();
     	String ValidateCodesession = (String) session.getAttribute("ValidateCodesession");
		if(ValidateCodesession.equalsIgnoreCase(ValidateCode)){
		User user=new User();
		user.setU_nickname(u_nickname);
		user.setU_name(u_name);
		user.setU_pass(MD5Encrypt.encryptByMD5(u_pass));
		user.setU_problem(u_problem);
		user.setU_answer(u_answer);
		IUserService iUserService=new UserService();
		boolean regUser = iUserService.isRegUser(user);
		if(regUser){
			
			System.out.println("注册成功");
			response.getWriter().println("<script>alert('注册成功');location.href='UserIndexServlet'</script>");
		}else{
			response.getWriter().println("<script>alert('该用户名存在，注册失败');location.href='user/u_reg.jsp'</script>");
		}
		}else{
			response.getWriter().println("<script>alert('验证码错误，注册失败');location.href='user/u_reg.jsp'</script>");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
