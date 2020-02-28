package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.Iservice.IDongTaiService;
import com.blog.bean.DongTai;
import com.blog.service.impl.DongTaiService;

public class DongTaiObtainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String d_ids = request.getParameter("d_id");
		int d_id = Integer.parseInt(d_ids);
		IDongTaiService iDongTaiService=new DongTaiService();
		DongTai dongtai = iDongTaiService.dongtaiDetails(d_id);
		request.setAttribute("dongtai", dongtai);
		request.getRequestDispatcher("/admin/a_dongtaimodify.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
