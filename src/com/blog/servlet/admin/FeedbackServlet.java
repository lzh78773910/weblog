package com.blog.servlet.admin;

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
import com.blog.bean.Photos;
import com.blog.service.impl.FeedbackService;

public class FeedbackServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IFeedbackService iFeedbackService=new FeedbackService();
		HttpSession session = request.getSession();
		int a_id =  (Integer) session.getAttribute("a_id");
		
		
		Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = iFeedbackService.getTotalCountByYiDu(a_id);//总数据数
		page.setTotalCount(totalCount);
	    int pageSize=8;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<Feedback> list = iFeedbackService.feedbackYiDu(a_id, currentPage, pageSize);
	    page.setFeedback(list);
	    
	    request.setAttribute("page", page);
        request.getRequestDispatcher("/admin/a_feedback.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
