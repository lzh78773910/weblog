<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加管理员</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="<%=basePath%>css_js/admin/css/we.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="<%=basePath%>css_js/admin/js/jquery-3.4.0.min.js"></script>
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
	//修改密码
	   function checkForm(){
        var passtip = checkpassword();  
		var newpasstip = checkxpassword();
        var conpasstip = checkqrpassword(); 
        return  passtip && newpasstip && conpasstip ;   
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
      <td>添加管理员</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
	  <div class="mmxg">
	<table class="tb" width="1275" height="250" border="1">
  <tbody>
    <tr>
      <td  height="35" ><p class="wz1">账号：</p></td>
      <td width="775"><input style="padding-left:10px;" placeholder="请输入6-18位数字或字母" class="wbk" name="adminname" type="text" size="25" height="30" onFocus="name_focus(this)"	   
      onBlur="names(this)" id="adminnameid" required />&nbsp<span id="nametip" ></td>
    </tr>
    <tr>
      <td height="35" ><p class="wz1">密码：</p></td>
      <td><input style="padding-left:10px;" placeholder="请输入6-18位数字或字母" class="wbk" name="adminpass" type="password" size="25" onFocus="pass_focus(this)"	   
      onBlur="passs(this)" 
	  id="adminpassid" />&nbsp<span id="passtip"></span></td>
    </tr>
    <tr>
      <td height="35" ><p class="wz1">确认密码：</p></td>
      <td><input style="padding-left:10px;" placeholder="请输入6-18位数字或字母" class="wbk" name="cpass" type="password" size="25" onFocus="pass_focusq(this)"	   
      onBlur="passsq(this)" 
	  id="xmm"	 />&nbsp<span id="passtipq" ></span></td>
    </tr>
      <tr>
      <td height="35" ><p class="wz1">昵称：</p></td>
      <td><input style="padding-left:10px;"placeholder="请输入1-5位中文汉字"  class="wbk" name="nickname"  type="text" size="25" onFocus="nicknamefoucs(this)"	   
      onBlur="nicknameonBlur(this)"  id="nameid"
		/>&nbsp<span id="nicknametip" ></span></td>
    </tr>
   
    <tr>
      <td height="35" class="wz"></td>
      <td><input class="wz4"  type="button" id="reg" value="提交"/>
		  <input class="wz5"  type="reset" value="重置"/></td>
    </tr>
  </form> 
  </tbody>
</table>
  
</div>

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
        function pass_focusq(obj){
        obj.style.border="1px solid #fff";
		var tip=document.getElementById("passtipq");
		tip.innerHTML="密码为6-18位";
		tip.style.color="#fff";
		tip.style.paddingLeft="";
	}
	function passsq(obj){
		var pass=obj.value;
		var passq=document.getElementById("ymm").value;
		var tip=document.getElementById("passtipq");
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
		}else if(passq!=pass){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码不一致";
		  return false;
		}else{
		obj.style.border="1px solid #CCC";
			tip.innerHTML="&nbsp";
	      return true;
		}
	}
	      function pass_focusq(obj){
        obj.style.border="1px solid #fff";
		var tip=document.getElementById("passtipq");
		tip.innerHTML="密码为6-18位";
		tip.style.color="#fff";
	}
	function passsq(obj){
		var pass=obj.value;
		var passq=document.getElementById("adminpassid").value;
		var tip=document.getElementById("passtipq");
		var str=/^[A-Za-z0-9]{6,18}$/;
		tip.style.color="red";

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
		}else if(passq!=pass){
		obj.style.border="1px solid red";	
		tip.innerHTML="密码不一致";
		  return false;
		}else{
		obj.style.border="1px solid #CCC";
			tip.innerHTML="&nbsp";
	      return true;
		}
	}
	
	  function nicknamefoucs(obj){
        obj.style.border="1px solid #fff";
		var tip=document.getElementById("nicknametip");
		tip.innerHTML="昵称为1-5个汉字组成";
		tip.style.color="#fff";
	}
	function nicknameonBlur(obj){
		var nicknameonBlur=obj.value;
		var tip=document.getElementById("nicknametip");
		var str=/^[\u4e00-\u9fa5]{1,5}$/;
		tip.style.color="red";
		if(nicknameonBlur.length==0){
		obj.style.border="1px solid red";	
		tip.innerHTML="昵称不能为空";
		    return false;
		}else if(!str.test(nicknameonBlur)){
		obj.style.border="1px solid red";	
		tip.innerHTML="昵称格式错误";
		  return false;
		}else{
		obj.style.border="1px solid #CCC";
			tip.innerHTML="&nbsp";
	      return true;
		}
	}
	
	
	
		//单击登录按钮的时候触发ajax事件
		$("#reg").click(function(){
		var adminname =document.getElementById("adminnameid");
		var adminpass =document.getElementById("adminpassid");
		var nameid =document.getElementById("nameid");
		var xmmid =document.getElementById("xmm");
		var xmmidis=passsq(xmmid);
		var nameis=nicknameonBlur(nameid);
		var name=names(adminname);
		var pass=passs(adminpass);
		if(!(name&&pass&&xmmidis&&nameis)){
		return;
		}
		$.ajax({
			url:"adminservlet/AdminuserRegServlet",
			type:"post",
			data:{
				adminname:$("input[name=adminname]").val(),
				adminpass:$("input[name=adminpass]").val(),
				adminnickname:$("input[name=nickname]").val()
			},
			dataType:"json",
			success:function(result){
				var flag = result.flag;
				if(flag==true){
					//如果登录成功则跳转到成功页面
					  alert("添加成功");
				}else{
					//跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
					alert("添加失败，该账户已存在");
				}
			}
		});
		//}
	});
  </script>
</body>
</html>
