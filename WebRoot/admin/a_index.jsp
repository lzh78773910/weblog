<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台管理系统</title>
    
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
  <div class="table" style="height: 400px">
	  
	  <table width="1275" height="50">
  <tbody class="biaotou">
    <tr>
      <td>后台管理系统</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="gltubiao"> 
	  <div class="yhtb"><input type="image" id="gltb"  src="<%=basePath%>css_js/admin/images/yonghu.png" onclick='location.href=("we.html")' ><span>&nbsp;&nbsp;&nbsp;用户管理</span></div>
	  <div class="mmtb"><input type="image" id="mmtb"  src="<%=basePath%>css_js/admin/images/mima.png" onclick='location.href=("admin/a_changepassword.jsp")'><span>&nbsp;&nbsp;&nbsp;修改密码</span></div>
	  <div class="sztb"><input type="image" id="sztb"  src="<%=basePath%>css_js/admin/images/shizhi.png" onclick='location.href=("we.html")'><span>&nbsp;&nbsp;&nbsp;其他设置</span></div>
    </div>
	  
</div>	
	</div>
</body>
</html>

