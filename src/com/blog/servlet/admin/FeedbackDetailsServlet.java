package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IFeedbackService;
import com.blog.Iservice.IFeedbackanwerService;
import com.blog.bean.DongTai;
import com.blog.bean.Feedback;
import com.blog.bean.Feedbackanwer;
import com.blog.bean.Page;
import com.blog.service.impl.FeedbackService;
import com.blog.service.impl.FeedbackanwerService;

public class FeedbackDetailsServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IFeedbackService iFeedbackService=new FeedbackService();
		int f_id =Integer.parseInt(request.getParameter("f_id"));
		Feedback feedback = iFeedbackService.feedbackDao(f_id);
		
		if(request.getParameter("is_used_0")!=null){
			int is_used_0 =Integer.parseInt(request.getParameter("is_used_0"));
			iFeedbackService.updateFeedback(is_used_0, f_id);
		}
		
		IFeedbackanwerService iFeedbackanwerService=new FeedbackanwerService();
		
		Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = iFeedbackanwerService.getTotalCountByfa_feedback(f_id); //总数据数
		page.setTotalCount(totalCount);
	    int pageSize=2;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<Feedbackanwer> list = iFeedbackanwerService.feedbackanwerByfeedback(f_id, currentPage, pageSize);
	    page.setFeedbackanwer(list);
		
	    request.setAttribute("feedback", feedback);
	    request.setAttribute("page", page);
        request.getRequestDispatcher("/admin/a_feedbackdetails.jsp").forward(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
