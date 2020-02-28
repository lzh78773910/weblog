<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet"  href="<%=basePath%>css_js/admin/css/css.css">
	 <script type="text/javascript" src="<%=basePath%>css_js/admin/js/jquery-3.4.0.min.js"></script>
 <style type="text/css"> 

</style>
</head>

<body>
<div class="all">
<div class="enter">

  <input maxlength="18" size="30" class="transparent" placeholder="请输入6-18位数字或字母的账号" 
  name="adminname" id="adminnameid" onfocus="name_focus(this)" onblur="names(this)"/>
  <br>
  <span id="nametip"style="margin-left: 10px;">&nbsp</span>
<input id="adminpassid" name="adminpass" type="password" maxlength="18" size="30" class="transparent" placeholder="请输入6-18位数字或字母的密码" 
            onfocus="pass_focus(this)" onblur="passs(this)"/>
<br>
<span id="passtip"style="margin-left: 10px;">&nbsp</span><br>
<input  type="button" id="adminlogin" class="dl" value="登录"/>
</div>
</div>

<script type="text/javascript">
  function name_focus(obj){
        obj.style.border="1px solid #fff";
		var tip=document.getElementById("nametip");
		
		tip.innerHTML="账号为6-18位";
		tip.style.color="#fff";
	}
	function names(obj){
		var name=obj.value;
		var str=/^[A-Za-z0-9]{6,18}$/;
		var tip=document.getElementById("nametip");
		tip.style.color="red";
		if(name.length==0){
		
		obj.style.border="1px solid red";	
		tip.innerHTML="账号不能为空";
		    return false;
		}else if(name.length<6){
		obj.style.border="1px solid red";	
		tip.innerHTML="账号不能小于6位";
		  return false;
		}else if(name.length>18){
		obj.style.border="1px solid red";	
		tip.innerHTML="账号不能大于18位";
		  return false;
		}else if(!str.test(name)){
		obj.style.border="1px solid red";	
		tip.innerHTML="账号格式错误";
		  return false;
		}
		else{
		obj.style.border="1px solid #CCC";
			tip.innerHTML="&nbsp";
		   return true;
		}
	}
	
	function pass_focus(obj){
        obj.style.border="1px solid #fff";
		var tip=document.getElementById("passtip");
		tip.innerHTML="密码为6-18位";
		tip.style.color="#fff";
		tip.style.paddingLeft="";
	}
	function passs(obj){
		var pass=obj.value;
		var tip=document.getElementById("passtip");
		var str=/^[A-Za-z0-9]{6,18}$/;
		tip.style.color="red";
		tip.style.paddingLeft="";

		if(pass.length==0){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码不能为空";
		    return false;
		}else if(pass.length<6){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码不能小于6位";
		  return false;
		}else if(pass.length>18){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码不能大于18位";
		  return false;
		}else if(!str.test(pass)){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码格式错误";
		  return false;
		}else{
		obj.style.border="1px solid #CCC";
			tip.innerHTML="&nbsp";
	      return true;
		}
	}
		//单击登录按钮的时候触发ajax事件
		$("#adminlogin").click(function(){
		var adminname =document.getElementById("adminnameid");
		var adminpass =document.getElementById("adminpassid");
		var name=names(adminname);
		var pass=passs(adminpass);
		if(!(name&&pass)){
		return;
		}
		$.ajax({
			url:"AdminuserLoginServlet",
			type:"post",
			data:{
				adminname:$("input[name=adminname]").val(),
				adminpass:$("input[name=adminpass]").val()
			},
			dataType:"json",
			success:function(result){
				var flag = result.flag;
				if(flag==true){
					//如果登录成功则跳转到成功页面
					window.location.href="admin/a_index.jsp";
				}else{
					//跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
					$("#passtip").html("账号或者密码不正确");
					$("#passtip").css("padding-left","35px");
				}
			}
		});
		//}
	});
  </script>
</body>
</html>