package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IDongTaiService;
import com.blog.bean.DongTai;
import com.blog.service.impl.DongTaiService;

/**
  * 发布动态
  */
public class DongTaiAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String atitle = request.getParameter("atitle");
		String acontent = request.getParameter("acontent");
		HttpSession session = request.getSession();
		int a_id=(Integer) session.getAttribute("a_id");
		
		DongTai dongtai =new DongTai();
		dongtai.setD_title(atitle);
		dongtai.setD_content(acontent);
		
		IDongTaiService dongtaiService=new DongTaiService();
		boolean dongtaiAdd = dongtaiService.dongtaiAdd(a_id, dongtai);
		if(dongtaiAdd){
	    response.getWriter().println("<script>alert('添加动态成功');location.href='/weblog/admin/a_dongtaiadd.jsp'</script>");
		}else{
			response.getWriter().println("<script>alert('添加动态失败');location.href='/weblog/admin/a_dongtaiadd.jsp'</script>");	
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
