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
    
    <title>动态详情</title>
    
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
      <td>动态详细</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
    <table width="1200" height="55" border="1" class="dtxs">
  <tbody>
    <tr>
      <td >标题：${dongtai.d_title }</td>
    </tr>
	  </tbody></table>
	  <p class="plxs">作者：${dongtai.adminuser.a_nickname}<span class="reader">${dongtai.d_liulang}人已读</span></p>
	  <table width="1200" height="220" border="1" class="dtxs">
		<tbody>
    <tr >
      <td valign="top">${dongtai.d_content }</td>
    </tr>
  </tbody>
</table>
	<p class="plxs">时间：${dongtai.createtime }</p><br>
	<p class="plxs">评论内容：</p>
	  <table width="1200" height="100" border="1" class="plxs">
  <tbody>
    <tr>
      <td valign="top" >
		<ul class="plzt">
			<c:forEach items="${requestScope.pages.pinglun }" var="pinglun">
		  <li>
			${pinglun.user.u_nickname }&nbsp:&nbsp${pinglun.pl_content }<span class="reader1">时间:${pinglun.createtime }</span>
			</li>
			</c:forEach>
		  </ul>
           <div class="pagelist pagebg">
   &nbsp;<a href="adminservlet/DongTaiDetails?currentPage=1&d_id=${dongtai.d_id }">首页
   </a>&nbsp;<a href="adminservlet/DongTaiDetails?currentPage=${pages.currentPage==1?1 : pages.currentPage-1}&d_id=${dongtai.d_id }"> 上一页</a>
	  &nbsp;<b>${pages.currentPage}/${pages.totalPage}</b>&nbsp;</b>
	  <a href="adminservlet/DongTaiDetails?currentPage=${pages.currentPage == pages.totalPage?pages.totalPage : pages.currentPage+1}&d_id=${dongtai.d_id }">下一页
	  </a>&nbsp;<a href="adminservlet/DongTaiDetails?currentPage=${pages.totalPage}&d_id=${dongtai.d_id }">尾页</a>
	  </div>
	</td>
		
    </tr>
  </tbody>
	
</table>
 
</div> 
</div>
</body>
</html>
