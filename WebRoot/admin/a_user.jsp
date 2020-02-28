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
      <td>动态管理</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="neirong"> 
	   <table width="100%" border="1">
  <tbody>
    <tr>
      <th width="60" height="43">ID</th>
      <th>账号</th>
      <th >昵称</th>
      <th>问题</th>
      <th>答案</th>
      <th>时间</th>
      <th>操作</th>
    </tr>
  <c:forEach items="${requestScope.page.user }" var="user">
		<tr>
        <td width="60" height="60">${user.u_id }</td>
        <td width="100">${user.u_name }</td>
        <td width="200">${user.u_nickname }</td>
        <td width="200">${user.u_problem }</td>
        <td width="200">${user.u_answer }</td>
        <td width="280">${user.createtime }</td>
      <td width="100">
      
      <c:if test="${user.is_used}">
      <a href="adminservlet/UserByis_used?u_id=${user.u_id }&is_used=0&currentPage=${page.currentPage}">停用</a></td>
      </c:if>
       <c:if test="${!user.is_used}">
      <a href="adminservlet/UserByis_used?u_id=${user.u_id }&is_used=1&currentPage=${page.currentPage}">恢复</a></td>
      </c:if>
      
    </tr>
     </c:forEach>
  </tbody>
</table>
    </div>
    <div class="pagelist pagebg">
   &nbsp;<a href="adminservlet/UserListServlet?currentPage=1">首页
   </a>&nbsp;<a href="adminservlet/UserListServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="adminservlet/UserListServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}">下一页
	  </a>&nbsp;<a href="adminservlet/UserListServlet?currentPage=${page.totalPage}">尾页</a>
	  </div>
</div>	
	</div>
</body>
</html>
