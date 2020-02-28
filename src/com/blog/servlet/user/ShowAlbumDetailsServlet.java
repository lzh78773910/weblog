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
import com.blog.Iservice.IDianZanService;
import com.blog.Iservice.IPhotoService;
import com.blog.bean.Albums;
import com.blog.bean.DianZan;
import com.blog.bean.Page;
import com.blog.bean.Photos;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.DianZanService;
import com.blog.service.impl.PhotoService;

public class ShowAlbumDetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String al_ids = request.getParameter("al_id");
		int al_id=Integer.parseInt(al_ids);
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("u_id")!=null){
		int u_id = (Integer) session.getAttribute("u_id");
		 IDianZanService iDianZanService=new DianZanService();
		    DianZan dianzanxinxi = iDianZanService.dianzan(u_id, al_id);
		    request.setAttribute("dianzanxinxi", dianzanxinxi);
		}
		    
		    
		IAlbumsService albumsService=new AlbumsService();
		int dianzancount = albumsService.getTotalCountBydianzan(al_id);
		Albums albums = albumsService.Albums(al_id);
		 
		
		
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
		    int pageSize=16;
		    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		    page.setTotalPage(totalPage);
		    List<Photos> list = iPhotoService.photosByp_albums(al_id, currentPage, pageSize);
		    page.setPhotos(list);
		    
		   
		
		    request.setAttribute("al_id", al_id);
		    request.setAttribute("albums", albums);
		    request.setAttribute("dianzan", dianzancount);
		    request.setAttribute("page", page);
	        request.getRequestDispatcher("/user/u_photo.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
