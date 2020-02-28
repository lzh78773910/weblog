<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
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
	//修改密码
	   function checkForm(){
        var passtip = checkpassword();  
		var newpasstip = checkxpassword();
        var conpasstip = checkqrpassword(); 
        return  passtip && newpasstip && conpasstip ;   
		
	   }
		
		//原密码js
	   function checkpassword(){
           var ymm=document.getElementById("ymm");
		   var reg=/^[a-zA-Z0-9]{6,15}$/;
            if( ymm.value == null || ymm.value == ''){
           document.getElementById('one').innerHTML="密码不能为空";
           document.getElementById('ymm').style.border="1px solid #FF0004";	
				document.getElementById('one').style.color="#FF0004";
		   return false; 
		   
        }
           
		   else if(!(reg.test(ymm.value))){
          document.getElementById('one').innerHTML="密码格式不对";
          document.getElementById('ymm').style.border="1px solid #FF0004";
			   document.getElementById('one').style.color="#FF0004";
           return false; 
       }
       
	
          else{
           document.getElementById('one').innerHTML="";
           document.getElementById('ymm').style.border="1px solid #ccc";
			  return true; 

       }	
     }
		 function passfoucs(){
         document.getElementById('one').style.color="#FF0004";
         document.getElementById('ymm').style.border="1px solid #ccc";	
         document.getElementById('one').innerHTML="";
	   }
		//新密码js
     
	   function checkxpassword(){
           var xmm=document.getElementById("xmm");
		   var reg1=/^[a-zA-Z0-9]{6,15}$/;
            if( xmm.value == null || xmm.value == ''){
           document.getElementById('two').innerHTML="新密码不能为空";
           document.getElementById('xmm').style.border="1px solid #FF0004";	
				document.getElementById('two').style.color="#FF0004";
				return false; 
        }
            else if(!(reg1.test(xmm.value))){
          document.getElementById('two').innerHTML="密码格式不对";
          document.getElementById('xmm').style.border="1px solid #FF0004";	
				document.getElementById('two').style.color="#FF0004";
				return false; 

       }
	
          else{
           document.getElementById('two').innerHTML="";
           document.getElementById('xmm').style.border="1px solid #ccc";
			  
			  return true; 

       }	
     }
		  function xpassfoucs(){
         document.getElementById('two').style.color="#FF0004";
         document.getElementById('xmm').style.border="1px solid #ccc";	
         document.getElementById('two').innerHTML="";
	   }
      
       //确认密码js      
	   function checkqrpassword(){
           var qrmm=document.getElementById("qrmm");
		   var reg2=/^[a-zA-Z0-9]{6,15}$/;
		   var xmm=document.getElementById("xmm");
            if( qrmm.value == null || qrmm.value == ''){
           document.getElementById('three').innerHTML="确认密码不能为空";
           document.getElementById('qrmm').style.border="1px solid #FF0004";
				document.getElementById('three').style.color="#FF0004";
				return false; 
        }
           
            else if(!(reg2.test(qrmm.value))){
          document.getElementById('three').innerHTML="密码格式不对";
          document.getElementById('qrmm').style.border="1px solid #FF0004";	
				document.getElementById('three').style.color="#FF0004";
				return false; 

       }
	
		     else if(qrmm.value != xmm.value){
           document.getElementById('three').innerHTML="上下密码不一致";
           document.getElementById('qrmm').style.border="1px solid #FF0004";	
				 document.getElementById('three').style.color="#FF0004";
			   return false; 
         }
	
          else{
           document.getElementById('three').innerHTML="";
           document.getElementById('qrmm').style.border="1px solid #ccc";	
			  return true; 

       }	
     }
       function qrpassfoucs(){
         document.getElementById('three').style.color="#FF0004";
         document.getElementById('qrmm').style.border="1px solid #ccc";	
         document.getElementById('three').innerHTML="";
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
      <td>密码修改</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
	  <div class="mmxg">
	<table class="tb" width="1275" height="250" border="1">
  <tbody>
  <form action="adminservlet/ChangePasswordServlet" onSubmit="return checkForm()"  method="post">
    <tr>
	
      <td  height="35" ><p class="wz1">账号：</p></td>
      <td width="775"><input style="padding-left:10px;background-color: #DCDCDC;" class="wbk" name="aname" type="text" size="25" height="30" value="${aname}"  readonly="readonly" /></td>
    </tr>
    <tr>
      <td height="35" ><p class="wz1">原密码：</p></td>
      <td><input style="padding-left:10px;" placeholder="请输入6-18位数字或字母" class="wbk" name="opass" type="password" size="25" onFocus="passfoucs()"	   
      onBlur="checkpassword()" 
	  id="ymm" />&nbsp<span id="one" ></span></td>
    </tr>
    <tr>
      <td height="35" ><p class="wz1">新密码：</p></td>
      <td><input style="padding-left:10px;" placeholder="请输入6-18位数字或字母" class="wbk" name="cpass" type="password" size="25" onFocus="xpassfoucs()"	   
      onBlur="checkxpassword()" 
	  id="xmm"	 />&nbsp<span id="two" ></span></td>
    </tr>
      <tr>
      <td height="35" ><p class="wz1">确认密码：</p></td>
      <td><input style="padding-left:10px;"placeholder="请输入6-18位数字或字母"  class="wbk"  type="password" size="25" onFocus="qrpassfoucs()"	   
      onBlur="checkqrpassword()" 
	  id="qrmm"	
		/>&nbsp<span id="three" ></span></td>
    </tr>
   
    <tr>
      <td height="35" class="wz"></td>
      <td><input class="wz4"  type="submit" value="修改"/>
		  <input class="wz5"  type="reset" value="重置"/></td>
    </tr>
  </form> 
  </tbody>
</table>
  
</div>

</div>	
</div>
</body>
</html>
