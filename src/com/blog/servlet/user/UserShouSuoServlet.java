package com.blog.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IDongTaiService;
import com.blog.Iservice.IUserService;
import com.blog.bean.DongTai;
import com.blog.bean.Page;
import com.blog.bean.User;
import com.blog.service.impl.DongTaiService;
import com.blog.service.impl.UserService;

public class UserShouSuoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		 PrintWriter out = response.getWriter();
		if(session.getAttribute("u_name")!=null){
		IUserService iUserService =new UserService();
		String u_name = (String) session.getAttribute("u_name");
		User user = iUserService.UserByname(u_name);
		request.setAttribute("user", user);
	}
		String shousuo = request.getParameter("shousuo");
		
		IDongTaiService dongTaiService=new DongTaiService();
	    Page page = new Page();
		String cPage = request.getParameter("currentPage")  ;//
		if(cPage == null) {
			cPage = "1" ;
		}
	    int currentPage = Integer.parseInt( cPage );
	    page.setCurrentPage(currentPage);
		int totalCount = dongTaiService.getTotalCountShouSuo(shousuo);//总数据数
		page.setTotalCount(totalCount);
	    int pageSize=5;
	    int totalPage =totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	    page.setTotalPage(totalPage);
	    List<DongTai> queryDongTaiAll = dongTaiService.dongtaiShouSuo(shousuo, currentPage, pageSize);
	    page.setDongtai(queryDongTaiAll);
	    
	    //热度排序
		Page page0 = new Page();
		
		int ranking =1;
		List<DongTai> queryDongTaiAll0 = dongTaiService.dongtaiByd_liulang(ranking, pageSize);
		page0.setDongtai(queryDongTaiAll0);
	    
		request.setAttribute("shousuo", shousuo);
	    request.setAttribute("page", page);
	    request.setAttribute("page0", page0);
	    
        if(queryDongTaiAll.size()==0){
        out.println("<script>alert('没有相关的动态');location.href='UserIndexServlet'</script>");
        return;
        }
	    
        request.getRequestDispatcher("user/u_shousuo.jsp").forward(request, response);
		
	}
		
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
