package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IPingLunService;
import com.blog.bean.Albums;
import com.blog.bean.Page;
import com.blog.bean.PingLun;
import com.blog.service.impl.PingLunService;

public class PingLunPastServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int u_id = (Integer) session.getAttribute("u_id");
		
		
		IPingLunService iPingLunService=new PingLunService();
		
		Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount =iPingLunService.PingLunCountpl_author(u_id);                         //总数据数
		page.setTotalCount(totalCount);
	    int pageSize=5;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<PingLun> pinglun =iPingLunService.PingLunBypl_author(currentPage, pageSize, u_id);
	    page.setPinglun(pinglun);
	    
       	request.setAttribute("page", page);
        request.getRequestDispatcher("/user/u_commented.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
