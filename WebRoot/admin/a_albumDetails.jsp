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
    
    <title>动态管理</title>
    
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
  <div class="table">
	  
	  <table width="1275" height="50">
  <tbody class="biaotou">
    <tr>
      <th>相册查看与添加&nbsp点赞数(${requestScope.dianzan })</th>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="xiangcegl">
	<table width="1315" height="300" border="1">
  <tbody>
    <tr>
    <c:forEach items="${requestScope.page.photos }" var="photos">
      <td width="320" height="350" style="float: left;margin-left:5px;" ><a href="#" class="photo"><img src="<%=basePath%>css_js/admin/Albums/photos/${photos.p_url }" width="100%" height="310" ></a>
		  <br><span class="xiangceglin">${photos.p_title }--
		  <a href="adminservlet/PhoneByis_used?is_used=0&p_id=${photos.p_id }&currentPage=${page.currentPage}&al_id=${al_id }">删除</a>
		  </span></td>
		  </c:forEach>
    </tr>
		</tbody>
</table>
	  </div>
	  <div class="xiangcegl2">
	<table width="1315" border="1"  >
  <tbody>
    <tr>
      <td>
		 <div class="tianjia">
		 <form action="adminservlet/PhotoAddServlet" method="post" enctype="multipart/form-data">
		 <input type="hidden" name="p_albums" value="${al_id }" />
	<p>照片名称：</p><input name="p_title" /><br/>
   <p>上传照片: </p><input type="file"  name="upphoto"/> 格式只能为jpg，png
			  <br>
   <input type="submit" id="submit" value="新建"/></div> </td>
   </form>
    </tr>
  </tbody>
   </table>
         </div>		
             <div class="pagelist pagebg">
   &nbsp;<a href="adminservlet/AlbumDetailsServlet?currentPage=1&al_id=${al_id }">首页
   </a>&nbsp;<a href="adminservlet/AlbumDetailsServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}&al_id=${al_id }"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="adminservlet/AlbumDetailsServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}&al_id=${al_id }">下一页
	  </a>&nbsp;<a href="adminservlet/AlbumDetailsServlet?currentPage=${page.totalPage}&al_id=${al_id }">尾页</a>
	  </div>
	</div>
</body>
</html>
