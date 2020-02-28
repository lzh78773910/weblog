package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAlbumsService;
import com.blog.bean.Albums;
import com.blog.service.impl.AlbumsService;

public class AlbumObtainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String al_ids = request.getParameter("al_id");
		int al_id = Integer.parseInt(al_ids);
		IAlbumsService albumsService=new AlbumsService();
		Albums albums = albumsService.Albums(al_id);
		request.setAttribute("albums", albums);
		request.getRequestDispatcher("/admin/a_Albumsmodify.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}