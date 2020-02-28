<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加动态</title>
    
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
	 
  <div class="table" style="height:500px">
	  
	  <table width="1275" height="50">
  <tbody class="biaotou">
    <tr>
      <td>动态发布</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="neirong"> 
	   <table width="100%" border="1">
  <tbody>
    <tr>
    <form action="adminservlet/DongTaiAddServlet" method="post">
      <td width="162" height="43">标题</td>
      <td width="669"><input type="text" id="wbk" name="atitle" required autofocus></td>
    </tr>
    <tr>
      <td width="162" height="240">发布内容</td>
      <td width="669">
      <textarea name="acontent" required id="wbkone" required style="font-size: 20px"></textarea>
      </td>
    </tr>
  </tbody>
</table> 
	<input type="submit" id="submit" value="发布"><input type="reset" id="reset">
	</form>
    </div> 
</div>		
</div>
</body>
</html>
