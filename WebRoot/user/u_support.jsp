<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'u_support.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <link href="<%=basePath%>css_js/user/CSS/index.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>css_js/user/CSS/personalcenter.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>css_js/user/JS/updateheader.js"></script>
  </head>
  
  <body>
   <div id="box">
	 	 <jsp:include page="u_navigationbar.jsp"></jsp:include>
	 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
	 
	<div class="personalcenterbox">
   <jsp:include page="u_centerleft.jsp"></jsp:include>
   <div class="personalright">
			
			<div class="usersupportbox">
			
			<c:forEach items="${requestScope.page.albums }" var="albums">
				<div class="usersupport">
				<h3>相册名：《${albums.al_name }》 </h3>
				<input type="image" src="<%=basePath%>/css_js/user/image/agree.png" alt="value" id="support"/>
				<p class="supportdate"><fmt:formatDate value="${albums.createtime }" pattern="yyyy年MM月dd日" /></p>
				</div>
			</c:forEach>	
				
	
			</div>
						<div class="pagelist">
   &nbsp;<a href="userservlet/DianZanPastServlet?currentPage=1">首页
   </a>&nbsp;<a href="userservlet/DianZanPastServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="userservlet/DianZanPastServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}">下一页
	  </a>&nbsp;<a href="userservlet/DianZanPastServlet?currentPage=${page.totalPage}">尾页</a>
	  </div>
			</div>
		
	
	
	</div>
	
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
</div>
</body>
</html>
