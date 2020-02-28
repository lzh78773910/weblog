package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IFeedbackanwerService;
import com.blog.bean.Feedbackanwer;
import com.blog.service.impl.FeedbackanwerService;

public class FeedbackHuiFuServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int u_id =  (Integer) session.getAttribute("u_id"); 
		int fa_feedback =Integer.parseInt(request.getParameter("fa_feedback")) ;
		String fa_content = request.getParameter("fa_content");
		int fa_leixin=1;//回复类型 1为用户回复
		
		Feedbackanwer feedbackanwer=new Feedbackanwer();
		feedbackanwer.setFa_user(u_id);
		feedbackanwer.setFa_feedback(fa_feedback);
		feedbackanwer.setFa_content(fa_content);
		feedbackanwer.setFa_leixin(fa_leixin);
		
		IFeedbackanwerService iFeedbackanwerService=new FeedbackanwerService();
		boolean falg = iFeedbackanwerService.insertfa_user(feedbackanwer);
		
		if(falg){
			response.sendRedirect("ShowFeedbackDetailsServlet?f_id="+fa_feedback);
			//out.println("<script>alert('回复成功');location.href='ShowFeedbackDetailsServlet?f_id="+fa_feedback+"'</script>");
				}else{
			out.println("<script>alert('回复失败');location.href='ShowFeedbackDetailsServlet?f_id="+fa_feedback+"'</script>");	
				}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

}
