package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IFeedbackService;
import com.blog.Iservice.IFeedbackanwerService;
import com.blog.bean.Feedback;
import com.blog.bean.Feedbackanwer;
import com.blog.service.impl.FeedbackService;
import com.blog.service.impl.FeedbackanwerService;

public class ShowFeedbackDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IFeedbackService iFeedbackService=new FeedbackService();
		int f_id =Integer.parseInt(request.getParameter("f_id"));
		Feedback feedback = iFeedbackService.feedbackDao(f_id);
		
		IFeedbackanwerService iFeedbackanwerService=new FeedbackanwerService();
		
	    List<Feedbackanwer> list = iFeedbackanwerService.feedbackanwer(f_id);
		
	    request.setAttribute("feedback", feedback);
	    request.setAttribute("list", list);
        request.getRequestDispatcher("/user/u_personfeedbackdetail.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
