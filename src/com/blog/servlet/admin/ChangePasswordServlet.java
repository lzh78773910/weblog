package com.blog.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.Iservice.IAdminuserService;
import com.blog.bean.Adminuser;
import com.blog.service.impl.AdminuserService;
import com.blog.util.MD5Encrypt;

public class ChangePasswordServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String aname = request.getParameter("aname");//ԭ�˺�
		String opass = request.getParameter("opass");
		String cpass = request.getParameter("cpass");
		
		IAdminuserService iAdminuserService = new AdminuserService();
		Adminuser is = iAdminuserService.isAdminUserByname(aname);
		HttpSession session = request.getSession();
		int a_id = (Integer)session.getAttribute("a_id");
		PrintWriter out = response.getWriter();
		
		if (is != null) {
			if(MD5Encrypt.validatePassword(opass, is.getA_pass())){
				Adminuser iss=new Adminuser();
				iss.setA_pass(MD5Encrypt.encryptByMD5(cpass));
				iAdminuserService.Change_a_pass(iss, a_id);
				session.invalidate();
				out.println("<script>alert('�޸ĳɹ�');location.href='/weblog/admin/alogin.jsp'</script>");
			}else{
				 System.out.println("ԭʼ�������");
				 out.println("<script>alert('ԭʼ���������������֤');location.href='/weblog/admin/a_changepassword.jsp'</script>");
				}
		 }else{
			 out.println("<script>alert('������������֤');location.href='/weblog/admin/a_changepassword.jsp'</script>");
		 }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
