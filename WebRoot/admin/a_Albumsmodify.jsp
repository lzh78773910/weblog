<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'a_Albummodify.jsp' starting page</title>
    
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
	 
  <div class="table" style="height: 450px">
	  
	  <table width="1275" height="50">
  <tbody class="biaotou" ">
    <tr>
      <td>相册修改</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
<div class="neirong" > 
	   <table width="100%" border="1">
  <tbody>
  <form action="adminservlet/AlbumModifyServlet" method="post" enctype="multipart/form-data">
    <tr>
      <input type="hidden" name="al_id" value="${albums.al_id }">
   <input type="hidden" name="al_url" value="${albums.al_url }">
      <td width="280" height="120" >相册名称</td>
      <td width="669" style="padding-left: 50px"><input value="${albums.al_name }" name="al_name" type="text" id="wbk" style="width: 350px"></td>
    </tr>
    <tr>
      <td width="280" height="120">上传照片</td>
      <td width="669" style="padding-right: 50px"><input name="spictureupdate" type="file" /> 格式只能为jpg，png
   <br/>
		

</td>
    </tr>
  </tbody>
</table> 
	<input type="submit" id="submit" value="修改" />
	</form>
    </div>
	  
	
</div>		
</div>
</body>
</html>
