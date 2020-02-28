package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IDongTaiService;
import com.blog.Iservice.IPingLunService;
import com.blog.Iservice.IUserService;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.bean.PingLun;
import com.blog.bean.User;
import com.blog.service.impl.DongTaiService;
import com.blog.service.impl.PingLunService;
import com.blog.service.impl.UserService;

public class ShowDongTaiDetails extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("u_name")!=null){
		IUserService iUserService =new UserService();
		String u_name = (String) session.getAttribute("u_name");
		User user = iUserService.UserByname(u_name);
		request.setAttribute("user", user);
	}
		
		String d_ids = request.getParameter("d_id");
		int d_id = Integer.parseInt(d_ids);
		IDongTaiService iDongTaiService=new DongTaiService();
		DongTai dongtai = iDongTaiService.dongtaiDetails(d_id);
		
		IPingLunService iPingLunService=new PingLunService();
	    Page page = new Page();
			String cPage = request.getParameter("currentPage")  ;//
			if(cPage == null) {
				cPage = "1" ;
			}
		    int currentPage = Integer.parseInt( cPage );
		    page.setCurrentPage(currentPage);
			int totalCount = iPingLunService.PingLunCount(d_id);//总数据数
			
			page.setTotalCount(totalCount);
		    int pageSize=5;
		    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		    page.setTotalPage(totalPage);
		    List<PingLun> list = iPingLunService.PingLunByd_id(currentPage, pageSize, d_id);
		    page.setPinglun(list);
		  
		    iDongTaiService.dongtai(d_id);
		    
		    request.setAttribute("d_id", d_id);
		    request.setAttribute("pages", page);
	 	request.setAttribute("dongtai", dongtai);
		request.getRequestDispatcher("/user/u_dongtaidetail.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
