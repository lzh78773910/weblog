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
    
    <title>My JSP 'u_feedback.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link href="<%=basePath%>css_js/user/CSS/index.css" rel="stylesheet">
<link href="<%=basePath%>css_js/user/CSS/feedback.css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>css_js/user/JS/jquery-3.4.0.min.js"></script>
	<script type="text/javascript">
			function admin(type,content,a_id){
			document.getElementById(type).innerHTML = content;
			document.getElementById("a_id").value=a_id;
			}
	</script>

  </head>
  
   <body>
     <div id="box">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>	
   <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
	
	
	<div class="message">
	<div class="messageleft"><li class="fontawesome-envelope"> 私信消息</li>
		<hr><p>请选择管理员发送消息</p> <hr>
		<div class="admin">
		
		  <c:forEach items="${requestScope.list }" var="adminuser">
		
		<li>
		<input type="button" value="${adminuser.a_nickname }" onclick="admin('admin',value,${adminuser.a_id })">
		</li>
		</c:forEach>
		</div>
	 </div>
	 <div class="messageright">
	 
		 <h3>发送给‘<span id="admin"></span>’</h3>
		 
		 <form action="userservlet/FeedbackAddServlet">
		 <input type="hidden" id="a_id" name="a_id">
	     <textarea class="textarea" name="f_content"></textarea>
	     <button type="submit">发送</button>
		 </form>
		 
	 </div>
	</div>
	  
	
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
	  
</div>
</body>
</html>
