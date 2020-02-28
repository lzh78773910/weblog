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
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link href="<%=basePath%>css_js/user/CSS/register.css" type="text/css" rel="stylesheet" />
    <link href="<%=basePath%>css_js/user/CSS/index.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/register.js"></script>
  </head>
  
  <body>
<div id="box">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>
 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
	
	
  <div class="register">
  <h3>用户找回密码</h3>
	 <br/>
  <div class="registercontent" >
  <form action="ZhaoHuiPassServlet" onSubmit="return checkForm()">
    <div id="form-itemGroup">
      <label for="userName">用户名</label>
      <input name="u_name"type="text" id="userName" onBlur="checkUserName()" placeholder="请输入用户名" autofocus>
      <span id="nameErr" class="Verification"></span> </div>
	
   <div id="form-question" >密保问题:
      <select name="u_problem" class="PasswordProtection">
        <option value="你的梦想是什么？">你的梦想是什么？</option>
        <option value="你的学号是什么？">你的学号是什么？</option>
        <option value="你的生日是何时？">你的生日是何时？</option>
        <option value="你的母亲叫什么？">你的母亲叫什么？</option>
      </select>
	  <div id="form-answer">
		<label for="userAnswer">答案:</label>
		 <input name="u_answer" type="text" id="userAnswer" onBlur="Answer()" placeholder="请输入密保答案">
		<span id="answerErr" class="Verification1"></span></div>
	  </div>   <br/>
	  <div id="form-itemGroup">
      <label for="userPassword">密码</label>
      <input name="u_pass" type="password" id="userPasword" onBlur="checkPassword()" placeholder="请输入6到8位的新密码"/>
      <span id="passwordErr" class="Verification"></span> </div>
    <br/>
    <div id="form-itemGroup">
      <label for="userConfirmPasword">确认密码</label>
      <input type="password" id="userConfirmPasword" onBlur="ConfirmPassword()" placeholder="请再输入一遍密码">
      <span id="conPasswordErr" class="Verification"></span> </div>
	  
    <div>
      <button type="submit" class="divBtn">确定</button>
    </div>
	
  </form>
</div>
</div>
	  

 <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
  </div>
</body>

</html>
