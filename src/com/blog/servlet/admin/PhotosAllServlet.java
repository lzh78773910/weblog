package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IPhotoService;
import com.blog.bean.Page;
import com.blog.bean.Photos;
import com.blog.service.impl.PhotoService;

public class PhotosAllServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IPhotoService iPhotoService =new PhotoService();
	    Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = iPhotoService.getTotalCounttrue();
		page.setTotalCount(totalCount);
	    int pageSize=4;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<Photos> list = iPhotoService.photosByp_albumstrue(currentPage, pageSize);
	    page.setPhotos(list);
	
	    request.setAttribute("page", page);
        request.getRequestDispatcher("/admin/Photosall.jsp").forward(request, response);

}

public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	doGet(request, response);
}

}
