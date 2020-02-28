<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
            <div class="title">
			<div class="tu"></div>
			<div class="tubiao"><input type="image" id="tubiao" src="<%=basePath%>css_js/admin/images/tubiao.png" onclick='location.href=("admin/a_index.jsp")'></div>
			<div class="home"><a href="admin/a_index.jsp">Home</a></div>
			<div class="yhname"> 
			管理员 : ${aname }<a href="admin/a_zhuxiao.jsp" >退出登录</a></div>
			</div>	

			