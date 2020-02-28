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
    
    <title>My JSP 'u_update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>/css_js/user/CSS/index.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>/css_js/user/CSS/personalcenter.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/updateheader.js"></script>
  </head>
  
  <body>
     <div id="box">
		 <jsp:include page="u_navigationbar.jsp"></jsp:include>	
   <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
   
   
	<div class="personalcenterbox">
   <jsp:include page="u_centerleft.jsp"></jsp:include>
     
     <div class="personalright">
      <div class="userinformationupdatebox">
        <div class="userinformationupdate">
          <form action="userservlet/UserUpdateServlet" method="post"  enctype="multipart/form-data">
			    <input type="hidden" name="u_touxiang" value="${user.u_touxiang==null?null :  user.u_touxiang}">
          <input type="hidden" name="u_id" value="${user.u_id }">
              <p id="update1">We通行证：<input type="text" value="${user.u_name }" disabled></p>
            <p id="update2">昵称：<input type="text" name="u_nickname" value="${user.u_nickname==null?user.u_name : user.u_nickname }"/></p>
            <div class="updateheader">
            
            		<c:if test="${not empty user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/${user.u_touxiang}" class="header" id="headernow"/>
		</c:if>
		<c:if test="${empty user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/touxaing1.png" class="header" id="headernow"/>
		</c:if>
            
             
             
				<input type="file" value="上传头像"  name="file"  id="file" onchange="showPreview(this)">
			  </div>
			  <button type="submit" id="bt1">修改</button>
			  <button type="reset" id="bt2">重置</button>
          </form>
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
   