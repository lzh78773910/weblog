package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IDongTaiService;
import com.blog.Iservice.IPingLunService;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.bean.PingLun;
import com.blog.service.impl.DongTaiService;
import com.blog.service.impl.PingLunService;

public class DongTaiDetails extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		  
		    
		    request.setAttribute("pages", page);
	 	request.setAttribute("dongtai", dongtai);
		request.getRequestDispatcher("/admin/a_dongtaidetails.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
