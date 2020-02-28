package com.blog.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class Filterutf8 implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		String URI = request.getRequestURI();
		
		if(URI.contains("ValidateCodeServlet")){
			arg2.doFilter(arg0, arg1);
		}else{
		arg0.setCharacterEncoding("utf-8");
		arg1.setContentType("text/html; charset=utf-8");
		arg1.setCharacterEncoding("utf-8");
		arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
