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
    
    <title>动态回收站</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="<%=basePath%>css_js/admin/css/we.css" type="text/css" rel="stylesheet" />
 </head>
	<script type="text/javascript">
function ShowMenu(obj, noid) {
            var block = document.getElementById(noid);
            if (noid.length == 4) {
                
                obj.style.color = "#FF0000";
                    
            } else {
                var span = document.getElementById("menu").getElementsByTagName("span");
                var h1 = document.getElementById("menu").getElementsByTagName("h1");
               
                obj.style.color = "#7b7f7b"; 
                
            }
            if (block.className == "no") {
                block.className = "";
            } else {
                block.className = "no";
                obj.style.color = "";
            }
        }
        
         
    </script>
<body>
<div class="box" width:100%; height:100%;> 
	 <jsp:include page="a_statusbar.jsp"></jsp:include>
	 <jsp:include page="a_navigationbar.jsp"></jsp:include>
  <div class="table" style=" height:none ">
	  
	  <table width="1200" height="50">
  <tbody class="biaotou" >
    <tr>
      <td>相册回收站</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="neirong" > 
	   <table width="100%"  border="1">
  <tbody>
    <tr>
       <td width="64" height="80">id</td>
      <td width="200">标题</td>
      <td width="200">作者</td>
      <td width="80">时间</td>
      <td width="320">照片</td>
	  <td width="348">操作</td>
    </tr>
     <c:forEach items="${requestScope.page.albums }" var="albums">
    <tr>
      <td>${albums.al_id }</td>
      <td>${albums.al_name }</td>
      <td>${albums.adminuser.a_nickname }</td>
      <td>${albums.createtime }</td>
      <td><img src="<%=basePath%>css_js/admin/Albums/${albums.al_url }" width="200" height="150"></td>
	  <td>
	  <a href="adminservlet/AlbumDetailsServlet?al_id=${albums.al_id }" class="delete">查看与添加照片</a>
	  
	  <a href="adminservlet/AlbumObtainServlet?al_id=${albums.al_id }" class="delete">修改</a>
	  
	  <a href="adminservlet/AlbumsByis_used?is_used=1&al_id=${albums.al_id }&currentPage=${page.currentPage}">恢复</a></td>
    </tr>
    	  </c:forEach>
  
  </tbody>
</table>
    </div>
    <div class="pagelist pagebg">
   &nbsp;<a href="adminservlet/AlbumRBServlet?currentPage=1">首页
   </a>&nbsp;<a href="adminservlet/AlbumRBServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="adminservlet/AlbumRBServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}">下一页
	  </a>&nbsp;<a href="adminservlet/AlbumRBServlet?currentPage=${page.totalPage}">尾页</a>
	  </div>
</div>	
	</div>
</body>
</html>
