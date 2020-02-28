package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IFeedbackService;
import com.blog.bean.Feedback;
import com.blog.bean.Page;
import com.blog.service.impl.FeedbackService;

public class ShowiFeedbackServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IFeedbackService iFeedbackService=new FeedbackService();
		HttpSession session = request.getSession();
		int u_id =  (Integer) session.getAttribute("u_id");
		
		
		Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = iFeedbackService.getTotalCountf_user(u_id);//总数据数
		page.setTotalCount(totalCount);
	    int pageSize=4;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<Feedback> list = iFeedbackService.feedbackf_user(u_id, currentPage, pageSize);
	    page.setFeedback(list);
	    
	    request.setAttribute("page", page);
        request.getRequestDispatcher("/user/u_personfeedback.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
