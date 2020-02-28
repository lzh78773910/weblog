package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IFeedbackService;
import com.blog.bean.Feedback;
import com.blog.service.impl.FeedbackService;

public class FeedbackAddServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		if(request.getParameter("a_id")==null||request.getParameter("a_id").equals("")){
			out.println("<script>alert('请选择管理员发送');location.href='/weblog/FeedbackForAdminuserServlet'</script>");
			return;
			}
		
		HttpSession session = request.getSession();
		int u_id =  (Integer) session.getAttribute("u_id");
		int a_id =Integer.parseInt(request.getParameter("a_id")) ;
		String f_content = request.getParameter("f_content");
		
		Feedback feedback=new Feedback();
		feedback.setF_user(u_id);
		feedback.setF_adminuser(a_id);
		feedback.setF_content(f_content);
		
		IFeedbackService iFeedbackService=new FeedbackService();
		boolean falg = iFeedbackService.insertFeedback(feedback);
		if(falg){
	out.println("<script>alert('已发送成功');location.href='/weblog/FeedbackForAdminuserServlet'</script>");
		}else{
	out.println("<script>alert('发送失败');location.href='/weblog/FeedbackForAdminuserServlet'</script>");	
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
	}

}
