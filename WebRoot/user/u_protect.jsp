<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'u_protect.jsp' starting page</title>
    
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
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/updateheader.js"></script>
  </head>
  
  <body>
   <div id="box">
	 	 <jsp:include page="u_navigationbar.jsp"></jsp:include>
	 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
	 
	<div class="personalcenterbox">
   <jsp:include page="u_centerleft.jsp"></jsp:include>
	<div class="personalright">
			<h3 class="useraccountprotecttitle" onclick="show2()">修改密码</h3>
			<h3 class="useraccountprotecttitle" onclick="show1()">修改密保</h3>
			
		
			<div class="userpassquestionbox" id="nameId" style="display:block">
				<div class="userpassquestion">
				  <form action="userservlet/MiBaoUpdateServlet" method="post" onSubmit="return checkForm()">
				<div class="useroldquestion">
					原密保问题：<input type="text" value="${user.u_problem}" class="old1"disabled/>
					<div id="form-oldanswer">
					<label for="olduserAnswer">原密保答案：</label>
					<input name="u_answer" type="text" id="olduserAnswer" placeholder="请输入你的密保答案" onBlur="oldAnswer()"  autofocus> 
						<span id="oldanswerErr" class="Verification"></span>
					  </div>
					</div>
				<div class="usernewquestion">
					<div id="form-question" >新密保问题：
					  <select name="up_problem" class="PasswordProtection">
						<option value="你的梦想是什么？">你的梦想是什么？</option>
						<option value="你的学号是什么？">你的学号是什么？</option>
						<option value="你的生日是何时？">你的生日是何时？</option>
						<option value="你的母亲叫什么？">你的母亲叫什么？</option>
					  </select>
					  <div id="form-newanswer">
						<label for="newuserAnswer">新密保答案：</label>
						 <input name="up_answer" type="text" id="newuserAnswer" onBlur="newAnswer()" placeholder="请输入密保答案">
						<span id="newanswerErr" class="Verification"></span>
					  </div>
					  </div>				
				</div>
					  <button type="submit">确认</button>
					  <button type="reset">重置</button>
				</form>
			</div>
			</div>
			<div class="userpassupdatebox" id="nameId2" style="display:none">
				<div class="userpassupdate">
					<form action="userservlet/PassUpdateServlet" method="post" onSubmit="return checkForm2()">
					<div id="form-oldpass">
					<label for="olduserPass">原密码：</label>
					<input name="u_pass" type="text" id="olduserPass" placeholder="请输入你的密码" onBlur="oldPass()"  > 
						<span id="oldpassErr" class="Verification"></span></div>
						<div id="form-newpass">
					  <label for="userPassword">密码：</label>
					  <input name="up_pass" type="password" id="userPasword" onBlur="checkPassword()" placeholder="请输入6到8位的密码"/>
					  <span id="passwordErr" class="Verification"></span> </div>
					<div id="form-itemGroup">
					  <label for="userConfirmPasword">确认密码：</label>
					  <input type="password" id="userConfirmPasword" onBlur="ConfirmPassword()" placeholder="请再输入一遍密码">
					  <span id="conPasswordErr" class="Verification"></span> </div>
					
					 <button type="submit">确认</button>
					  <button type="reset">重置</button>
					
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