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

public class DongTaiModifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String d_ids = request.getParameter("d_id");
		int d_id = Integer.parseInt(d_ids);
		String atitle = request.getParameter("atitle");
		String acontent = request.getParameter("acontent");
		
		DongTai dongtai=new DongTai();
		dongtai.setD_id(d_id);
		dongtai.setD_title(atitle);
		dongtai.setD_content(acontent);
		
		IDongTaiService iDongTaiService=new DongTaiService();
		iDongTaiService.dongtaiXiuGai(dongtai);
		
		response.getWriter().println("<script>alert('动态修改成功');location.href='/weblog/adminservlet/DongTaiObtainServlet?d_id="+d_ids+"'</script>");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
