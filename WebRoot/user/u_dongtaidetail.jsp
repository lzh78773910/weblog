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
    
    <title>My JSP 'u_dongtaidetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>/css_js/user/CSS/index.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>/css_js/user/CSS/login.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>/css_js/user/CSS/dongtaidetail.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/login.js"></script>

  </head>
  
  <body>
<div id="box">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>
	 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
	
	
  <div class="left" >
		
			
<!--	未登录状态			-->	
<c:if test="${empty sessionScope.u_id }">
		<div class="login1" >
  <h3>欢迎来到We Blog</h3>
  <button id="Button1" type="submit" title="登录账号" onclick="ShowDiv('MyDiv','fade')" >登录</button>
  <br/>
  <br/>
  <a href="user/u_reg.jsp">
  <button type="submit" title="注册账号">注册</button>
  </a>
  <p>没有账号？</p>
  <img src="<%=basePath%>/css_js/user/image/tu1.png" id="tu1"/> </div>
	</c:if>
<!--	登陆状态		  -->	
<c:if test="${not empty sessionScope.u_id }">	
		<div class="login2">
			<div class="indexusercontent">
		<a href="userservlet/UserInformationServlet">
		<c:if test="${not empty user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/${user.u_touxiang}" class="Headportrait"/>
		</c:if>
		<c:if test="${empty user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/touxaing1.png" class="Headportrait"/>
		</c:if>
		</a>
		<h3><a id="username" href="userservlet/UserInformationServlet">${sessionScope.u_nickname }</a>,欢迎你</h3>
				<a href="userservlet/UserInformationServlet">个人中心</a> / <a href="FeedbackForAdminuserServlet">反馈客服</a><br/>
				<a href="userservlet/ShowiFeedbackServlet">查看反馈</a> / <a href="user/u_zhuxiao.jsp">退出登录</a>
			</div>
	  </div>
	</c:if>
	
	  </div>
	

	
	<div class="PersonalSignature">
		<p>时光只解催人老，不信多情，长恨离亭，泪滴春衫酒易醒。</p>
		<br><hr>
	</div>
	<div class="dongtaidetailbox">
	<div class="dongtaidetail">
		<h3>${dongtai.d_title }</h3>
		<p class="detailcentent">${dongtai.d_content }</p>
		<ul class="dongtaibottom">
			<li class="author fontawesome-user">作者：${dongtai.adminuser.a_nickname}</li>
			<li class="createtime fontawesome-time">发布时间：2019-06-19 21:50:00</li>
			</ul>
	</div>
	<div class="comment">
	<form action="userservlet/PingLunAddServlet" method="post">
	<input type="hidden" value="${d_id }" name="d_id"> 
		<textarea  class="detailcomment" name="pl_content" placeholder="请输入想评论的内容"></textarea>
		<button type="submit">评论</button>
	</form>
	</div>
	<div class="usercommentsbox">
			<p>全部评论</p>
			<c:forEach items="${requestScope.pages.pinglun }" var="pinglun">
		<div class="usercomments">
			<a href="UserPersonalCenter.html">
				<c:if test="${not empty pinglun.user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/${pinglun.user.u_touxiang}" class="detailheader"/>
		</c:if>
		<c:if test="${empty pinglun.user.u_touxiang }">
		<img src="<%=basePath%>/css_js/user/touxiang/touxaing1.png" class="detailheader"/>
		</c:if>
			<p class="username">${pinglun.user.u_nickname }</p></a>
			<div class="displaycomment"><p>
			${pinglun.pl_content }
			</p></div>
		</div>
		</c:forEach>
	</div>
	</div>
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
	  </div>







	<!--登录隐藏层-->
	
		<div id="fade" class="black_overlay"  onclick="CloseDiv('MyDiv','fade')"> </div>	
		<div id="MyDiv" class="white_content">
		 <div style="text-align: right;"><span class="entypo-cancel" style="font-size: 16px;" onclick="CloseDiv('MyDiv','fade')">关闭</span></div>	
		<div class="bg"></div>
		<div class="user"><span class="uesrtitle">用户登录</span></div>
		<div id="login_form">
			
			<div id="form-itemGroup">
			<input name="u_name" type="text" onBlur="checkAccount()" placeholder="请输入账号" class="account" id="userAccount" autofocus><br/><span class="sp" id="accountErr"></span>
			</div>
			<br/><br/>
			<div id="form-itemGroup">
			<input name="u_pass" type="password" onBlur="checkPassword()" placeholder="请输入密码" class="pass" id="userPasword"/><br/><span class="sp" id="passwordErr"></span>
			</div>
			<br/>
			<input type="button" class="loginbutton" id="ulogin" value="登录"></input>	
			 <a href="#" class="r_float">忘记密码？</a>
			</div>
		<div class="register"><p>没有账号?点击<a href="user/u_reg.jsp">注册</a></p></div>
		</div>

<script type="text/javascript">
		$("#ulogin").click(function(){
			 var accounttip = checkAccount();
			 var passtip = checkPassword();
			if(!(accounttip && passtip)){
			return;
			}
			$.ajax({
				url:"UserloginServlet",
				type:"post",
				data:{
					u_name:$("input[name=u_name]").val(),
					u_pass:$("input[name=u_pass]").val()
				},
				dataType:"json",
				success:function(result){
					var flag = result.flag;
					if(flag==true){
						//如果登录成功则跳转到成功页面
						window.location.href="UserIndexServlet";
					}else{
						//跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
						alert(flag);
					}
				}
			});
			//}
		});
	</script>


</body>
</html>
