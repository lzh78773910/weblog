package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAlbumsService;
import com.blog.Iservice.IPhotoService;
import com.blog.bean.Albums;
import com.blog.bean.Page;
import com.blog.bean.Photos;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.PhotoService;

public class AlbumDetailsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String al_ids = request.getParameter("al_id");
		int al_id=Integer.parseInt(al_ids);
		
		IAlbumsService albumsService=new AlbumsService();
		int dianzan = albumsService.getTotalCountBydianzan(al_id);
		
		IPhotoService iPhotoService =new PhotoService();
		  Page page = new Page();
			String cPage = request.getParameter("currentPage")  ;//
			if(cPage == null) {
				cPage = "1" ;
			}
		    int currentPage = Integer.parseInt( cPage );
		    page.setCurrentPage(currentPage);
			int totalCount = iPhotoService.getTotalCountByp_albums(al_id);//总数据数
			page.setTotalCount(totalCount);
		    int pageSize=4;
		    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		    page.setTotalPage(totalPage);
		    List<Photos> list = iPhotoService.photosByp_albums(al_id, currentPage, pageSize);
		    page.setPhotos(list);
		
		    request.setAttribute("al_id", al_id);
		    request.setAttribute("dianzan", dianzan);
		    request.setAttribute("page", page);
	        request.getRequestDispatcher("/admin/a_albumDetails.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
