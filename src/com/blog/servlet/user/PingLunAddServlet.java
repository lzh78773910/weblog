package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IPingLunService;
import com.blog.bean.PingLun;
import com.blog.service.impl.PingLunService;

public class PingLunAddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int pl_author = (Integer) session.getAttribute("u_id");
		int pl_dongtai = Integer.parseInt(request.getParameter("d_id"));
		String pl_content = request.getParameter("pl_content");

		if(pl_content==null){
			out.println("<script>alert('评论失败,评论不能为空');location.href='/weblog/ShowDongTaiDetails?d_id="+pl_dongtai+"'</script>");
		}
		
		
		PingLun pinglun=new PingLun();
		pinglun.setPl_author(pl_author);
		pinglun.setPl_dongtai(pl_dongtai);
		pinglun.setPl_content(pl_content);
		
		IPingLunService iPingLunservice=new PingLunService();
		boolean falg = iPingLunservice.addpinglun(pinglun);
		
		if(falg){
			out.println("<script>alert('评论成功');location.href='/weblog/ShowDongTaiDetails?d_id="+pl_dongtai+"'</script>");	
		}else{
			out.println("<script>alert('评论失败');location.href='/weblog/ShowDongTaiDetails?d_id="+pl_dongtai+"'</script>");
		}
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
