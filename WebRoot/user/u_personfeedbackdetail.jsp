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
    
    <title>My JSP 'u_personfeedbackdetail.jsp' starting page</title>
    
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
			 <div class="messageright">
		  <h3>发送给‘ ${feedback.adminuser.a_nickname} <span id="admin"></span>’</h3>
		 <hr>
		 <div class="feedbackcontent">
			
			 
			 
			<div class="isuserbox">
			<div class="userbox" > <p  class="isuser">主题：${feedback.f_content }</p></div></div>
		
			     <c:forEach items="${requestScope.list }" var="feedbackanwer">
			  
			     	 <c:if test="${feedbackanwer.fa_leixin==1 }">
			<div class="isuserbox"> 
			<div class="userbox"> <p class="isuser">${feedbackanwer.fa_content }</p></div>
			</div>
			</c:if>
			 <c:if test="${feedbackanwer.fa_leixin==0 }">
			  <div class="isadminbox">
				<div class="adminbox"><p class="isadmin">${feedbackanwer.fa_content }</p>
				</div>
			 </div>
			 </c:if>
			 </c:forEach>
				 	 
			
		 </div>
		 
		 
		 
		<form action="userservlet/FeedbackHuiFuServlet"  method="get">
		<input type="hidden" name="fa_feedback" value="${feedback.f_id}">
	 <textarea class="textarea" name="fa_content"> </textarea>
	  <button type="submit">发送</button>	</form>	
	 </div>
				
				
			</div>
		</div>
	
	
	
	
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
	</div>
</body>
</html>
	