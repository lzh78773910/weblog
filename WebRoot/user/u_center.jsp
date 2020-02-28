<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'u_my.jsp' starting page</title>
    
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
<script type="text/javascript" src="<%=basePath%>css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>css_js/user/JS/updateheader.js"></script>
  </head>
  
  <body>
   <div id="box">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>
	 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>

	<div class="personalcenterbox">
   <jsp:include page="u_centerleft.jsp"></jsp:include>
   <div class="personalright">
			<div class="userinformationbox">
				<div class="userinformation">
				
		<c:if test="${not empty user.u_touxiang }">
		
		<img src="<%=basePath%>/css_js/user/touxiang/${user.u_touxiang}" class="personalHeadportrait"/>
		</c:if>
		<c:if test="${empty user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/touxaing1.png" class="personalHeadportrait"/>
		</c:if>
					
					<a href="userservlet/UserInformationServlet">${user.u_nickname==null?user.u_name : user.u_nickname }:的明信片</a>
					
					<p>We通行证：${user.u_name }</p>
					<p>出生时间：<fmt:formatDate value="${user.createtime }" pattern="yyyy年MM月dd日HH点mm分ss秒" /></p>
				
				</div>
			</div>
		</div>
	
	
	</div>
	
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
</div>
</body>
</html>
