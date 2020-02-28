package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IAlbumsService;
import com.blog.Iservice.IDongTaiService;
import com.blog.Iservice.IUserService;
import com.blog.bean.Albums;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.bean.User;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.DongTaiService;
import com.blog.service.impl.UserService;

public class UserIndexServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("u_name")!=null){
			
		IUserService iUserService =new UserService();
		String u_name = (String) session.getAttribute("u_name");
		User user = iUserService.UserByname(u_name);
		request.setAttribute("user", user);
	}
		IAlbumsService iAlbumsServic=new AlbumsService();
		Albums albumsFirst = iAlbumsServic.albumsFirst();
		
		
		IDongTaiService dongTaiService=new DongTaiService();
	    Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = dongTaiService.getTotalCount() ;//总数据数
		page.setTotalCount(totalCount);
	    int pageSize=5;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<DongTai> queryDongTaiAll = dongTaiService.dongtaiByPage(currentPage, pageSize);
	    page.setDongtai(queryDongTaiAll);
	    
	    //热度排序
		Page page0 = new Page();
		
		int ranking =1;
		List<DongTai> queryDongTaiAll0 = dongTaiService.dongtaiByd_liulang(ranking, pageSize);
		page0.setDongtai(queryDongTaiAll0);
	    
		
		
		
		request.setAttribute("albumsFirst", albumsFirst);
	    request.setAttribute("page", page);
	    request.setAttribute("page0", page0);
        request.getRequestDispatcher("user/u_index.jsp").forward(request, response);
		
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
