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
import com.blog.Iservice.IUserService;
import com.blog.bean.Albums;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.bean.User;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.UserService;

public class DianZanPastServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String u_name = (String) session.getAttribute("u_name");
		IUserService iUserService=new UserService();
		User user = iUserService.UserByname(u_name);
		int u_id=user.getU_id();
		IAlbumsService iAlbumsService=new AlbumsService();
			    Page page = new Page();
				String cPage = request.getParameter("currentPage")  ;//
				if(cPage == null) {
					cPage = "1" ;
				}
			    int currentPage = Integer.parseInt( cPage );
			    page.setCurrentPage(currentPage);
				int totalCount =iAlbumsService.getTotalCountBydz_user(u_id);                         //总数据数
				page.setTotalCount(totalCount);
			    int pageSize=5;
			    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
			    page.setTotalPage(totalPage);
			    List<Albums> albums = iAlbumsService.albumsYiWang(u_id, currentPage, pageSize);
			    page.setAlbums(albums);
			    
	           	request.setAttribute("page", page);
	            request.getRequestDispatcher("/user/u_support.jsp").forward(request, response);

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
