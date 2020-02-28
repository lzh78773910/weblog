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

public class MiBaoUpdateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String u_answer = request.getParameter("u_answer");//原来密保答案
		String u_problem = request.getParameter("up_problem");//要修改的密保
		String up_answer = request.getParameter("up_answer");//要修改的密保答案
		
		HttpSession session = request.getSession();
		String u_name =  (String) session.getAttribute("u_name");
		IUserService iUserService =new UserService();
		User user = iUserService.UserByname(u_name);
		
		String Dbu_answer = user.getU_answer();
		
		if(Dbu_answer.equals(u_answer)){
			User user2=new User();
			user2.setU_problem(u_problem);
			user2.setU_answer(up_answer);
			user2.setU_id(user.getU_id());
			boolean falg = iUserService.userByu_answer(user2);
			if(falg){
				System.out.println("密保修改成功");
				out.println("<script>alert('密保修改成功');location.href='UserObtainProtectServlet'</script>");
			}else{
				System.out.println("密保修改失败");
				out.println("<script>alert('密保修改失败');location.href='UserObtainProtectServlet'</script>");
			}
			
		}else{
			System.out.println("密保校验失败");
			out.println("<script>alert('密保校验失败');location.href='UserObtainProtectServlet'</script>");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	
	}

}
