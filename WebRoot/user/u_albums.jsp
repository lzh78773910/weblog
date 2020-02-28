<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'u_albums.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
		<link href="<%=basePath%>css_js/admin/css/we.css" type="text/css" rel="stylesheet" />
<link href="<%=basePath%>css_js/user/CSS/index.css" rel="stylesheet">
<link href="<%=basePath%>css_js/user/CSS/albums-photo.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>css_js/user/JS/jquery-3.4.0.min.js"></script>
  </head>
  
  <body>
    <div id="box">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>	
   <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
   <div class="albums1">
  	<div class="albmusbox">
  	<c:forEach items="${requestScope.page.albums }" var="albums">
	<div class="albums" title="该相册于${albums.createtime }创建，创建人：${albums.adminuser.a_nickname }">
		 <a href="ShowAlbumDetailsServlet?al_id=${albums.al_id }"><img src="<%=basePath%>css_js/admin/Albums/${albums.al_url }" width="250" height="220" class="photostyle" ></a>
		<p class="albumstitle">${albums.al_name }(${albums.count })</p>
	</div>
	</c:forEach>

	
	</div>
	</div>
	
		   <div class="pagelist">
   &nbsp;<a href="ShowAlbumServlet?currentPage=1">首页
   </a>&nbsp;<a href="ShowAlbumServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="ShowAlbumServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}">下一页
	  </a>&nbsp;<a href="ShowAlbumServlet?currentPage=${page.totalPage}">尾页</a>
	  </div>

  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
	</div>  

</body>

</html>