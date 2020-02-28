<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
 <base href="<%=basePath%>">
<head>
<meta charset="utf-8">
<title>有关“${shousuo}”的关键词动态</title>
<link href="<%=basePath%>/css_js/user/CSS/index.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>/css_js/user/CSS/login.css" rel="stylesheet" type="text/css"/>
<link href="<%=basePath%>/css_js/admin/css/we.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/css_js/user/JS/login.js"></script>


</head>

<body>
	
<div id="box">
	<div class="headbg"></div>
		 <jsp:include page="u_navigationbar.jsp"></jsp:include>
	 <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
		
		  <div class="indexcontent">
<div class="left" id="left">
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
	 
    <div class="middle"> 
    <h3 class="shousuo">有关“${shousuo}”的关键词动态如下：</h3>
    	<c:forEach items="${requestScope.page.dongtai }" var="dongtai">
		<div class="dongtai">
			<h3 class="dongtaititle"><a href="ShowDongTaiDetails?d_id=${dongtai.d_id }">${dongtai.d_title }</a></h3>
			<p class="dongtaicontent">${dongtai.d_content }</p>
			<ul class="dongtaibottom">
			<li class="author entypo-user">作者：${dongtai.adminuser.a_nickname}</li>
			<li class="createtime entypo-clock">发布时间：${dongtai.createtime }</li>
			<li class="people entypo-users">${dongtai.d_liulang }人已阅读</li>
			</ul>
		</div>
		</c:forEach>
		
	
	</div>
	     
    <div class="right"> 
	 
     <div class="dongtaiRanking">
		 <h3>动态排行榜<img src="<%=basePath%>/css_js/user/image/paihang.png"></h3>
     	<ul>
     	<li><p class="number1">1</p> <p class="Rankcontent"><a href="ShowDongTaiDetails?d_id=${page0.dongtai[0].d_id }">${page0.dongtai[0].d_title }</a></p><p class="Browsing">访问量：${page0.dongtai[0].d_liulang }</p></li>
			<li><p class="number2">2</p> <p class="Rankcontent"><a href="ShowDongTaiDetails?d_id=${page0.dongtai[1].d_id }">${page0.dongtai[1].d_title }</a></p><p class="Browsing">访问量：${page0.dongtai[1].d_liulang }</p></li>
        	<li><p class="number3">3</p> <p class="Rankcontent"><a href="ShowDongTaiDetails?d_id=${page0.dongtai[2].d_id }">${page0.dongtai[2].d_title }</a></p><p class="Browsing">访问量：${page0.dongtai[2].d_liulang }</p></li>
        	<li><p class="numberother">4</p> <p class="Rankcontent"><a href="ShowDongTaiDetails?d_id=${page0.dongtai[3].d_id }">${page0.dongtai[3].d_title }</a></p><p class="Browsing">访问量：${page0.dongtai[3].d_liulang }</p></li>
			<li><p class="numberother">5</p> <p class="Rankcontent"><a href="ShowDongTaiDetails?d_id=${page0.dongtai[4].d_id }">${page0.dongtai[4].d_title }</a></p><p class="Browsing">访问量：${page0.dongtai[4].d_liulang }</p></li>
        </ul>
     </div>
	  <div class="photohighestagree">
		<a href="/"><img src="<%=basePath%>/css_js/user/image/1.jpg" />
		  <h3>最受欢迎的相册:《海洋》</h3></a>
	  </div>
		
   </div>

</div>
	   <div class="pagelist">
   &nbsp;<a href="UserShouSuoServlet?currentPage=1&shousuo=${shousuo}">首页
   </a>&nbsp;<a href="UserShouSuoServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}&shousuo=${shousuo}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="UserShouSuoServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}&shousuo=${shousuo}">下一页
	  </a>&nbsp;<a href="UserShouSuoServlet?currentPage=${page.totalPage}&shousuo=${shousuo}">尾页</a>
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
