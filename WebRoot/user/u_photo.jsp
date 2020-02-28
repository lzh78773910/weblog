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
    
    <title>My JSP 'u_photo.jsp' starting page</title>
    
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
    <div id="box" style="height: 550px">
	 <jsp:include page="u_navigationbar.jsp"></jsp:include>	
   <jsp:include page="u_leftnavigationbar.jsp"></jsp:include>
   
   <div class="photosupportbox">
      <c:if test="${empty sessionScope.u_id }">
	  <p class="like" id="dianzanid" >&#10084;</p> 
	  </c:if>
	     <c:if test="${not empty sessionScope.u_id }">
   <c:if test="${dianzanxinxi.is_used }">
<p class="like1" id="dianzanid" >&#10084;</p> 
</c:if>
   <c:if test="${!dianzanxinxi.is_used }">
<p class="like" id="dianzanid" >&#10084;</p> 
</c:if>
</c:if>
	  
	  
		<div class="albumscontent">
		<p>该相册姓名：《${albums.al_name }》</p>
		<p>该相册于<fmt:formatDate value="${albums.createtime }" pattern="yyyy年MM月dd日"/>创建</p>
		<p>创建人：${albums.adminuser.a_nickname }</p>
		<p>已有点赞数<span id="count">(${dianzan })</span></p>
		</div>
	</div>
	
<input name="al_id" type="hidden" value="${al_id}"> 
<input name="u_id"  type="hidden" value="${sessionScope.u_id }"> 



   <div class="container">
       <c:forEach items="${requestScope.page.photos }" var="photos">
    <img class="pic" src="<%=basePath%>css_js/admin/Albums/photos/${photos.p_url }" >
    </c:forEach>
	</div>
	
	
	<div class="pagelist pagebg">
   &nbsp;<a href="ShowAlbumDetailsServlet?currentPage=1&al_id=${al_id}">首页
   </a>&nbsp;<a href="ShowAlbumDetailsServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}&al_id=${al_id}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="ShowAlbumDetailsServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}&al_id=${al_id}">下一页
	  </a>&nbsp;<a href="ShowAlbumDetailsServlet?currentPage=${page.totalPage}&al_id=${al_id}">尾页</a>
	  </div>
	
  <div class="footer">
    <p>©2019 广东科贸软件二班 We team版权所有</p>
  </div>
	  </div> 
	<script type="text/javascript">
		$("#dianzanid").click(function(){
		var $u_id=$("input[name=u_id]").val();
		if($u_id==null||$u_id == ""){
		alert("请先登录，再点赞");
		window.location.href="UserIndexServlet";
		return;
		}
		
			$.ajax({
				url:"userservlet/DianZanAlbumServlet",
				type:"post",
				data:{
					al_id:$("input[name=al_id]").val(),
					u_id:$("input[name=u_id]").val()
				},
				dataType:"json",
				success:function(result){
					var flag = result.flag;
					var count = result.count;
					var is_used = result.is_used;
					if(flag){
					if(is_used){
				
					$("#dianzanid").css("color","red");
					$("#count").html("("+count+")");
					}else{
				
					$("#dianzanid").css("color","#ccc");
					$("#count").html("("+count+")");
					}
					
					}else{
						//跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
					
				   $("#count").html(count);
					}
				}
			});
			//}
		});
	</script>
</body>
</html>
   