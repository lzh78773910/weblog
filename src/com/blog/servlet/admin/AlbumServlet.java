package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAlbumsService;
import com.blog.bean.Albums;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.service.impl.AlbumsService;

public class AlbumServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 
		  
		
		  IAlbumsService albumsService=new AlbumsService();
		  Page page = new Page();
			String cPage = request.getParameter("currentPage")  ;//
			if(cPage == null) {
				cPage = "1" ;
			}
		    int currentPage = Integer.parseInt( cPage );
		    page.setCurrentPage(currentPage);
			int totalCount = albumsService.getTotalCount() ;//总数据数
			page.setTotalCount(totalCount);
		    int pageSize=4;
		    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		    page.setTotalPage(totalPage);
		    List<Albums> list = albumsService.albumsByPage(currentPage, pageSize);
		    page.setAlbums(list);
		
		    request.setAttribute("page", page);
	        request.getRequestDispatcher("/admin/a_Album.jsp").forward(request, response);
		    
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
