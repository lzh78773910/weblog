package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IAlbumsService;
import com.blog.Iservice.IDongTaiService;
import com.blog.service.impl.AlbumsService;
import com.blog.service.impl.DongTaiService;

public class AlbumsByis_used extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int al_id = Integer.parseInt(request.getParameter("al_id"));
		int is_used =Integer.parseInt(request.getParameter("is_used"));
		String cPage = request.getParameter("currentPage");
		
		 IAlbumsService albumsService=new AlbumsService();
		 boolean falg = albumsService.updateAlbumsByid(al_id, is_used);
		if(falg){
			if(is_used==0){
				System.out.println("���ɾ���ɹ�");
				response.getWriter().println("<script>alert('���ɾ���ɹ�');location.href='AlbumServlet?currentPage="+cPage+"'</script>");
			}else{
				System.out.println("���ָ��ɹ�");
				response.getWriter().println("<script>alert('���ָ��ɹ�');location.href='AlbumRBServlet?currentPage="+cPage+"'</script>");
			}
		}else{
			System.out.println("����");
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
