/* CSS Document */


 //弹出隐藏层
        function ShowDiv(show_div, bg_div) {
            document.getElementById(show_div).style.display = 'block';
            document.getElementById(bg_div).style.display = 'block';
            var bgdiv = document.getElementById(bg_div);
            bgdiv.style.width = document.body.scrollWidth;
            // bgdiv.style.height = $(document).height();
            $("#" + bg_div).height($(document).height());
        };
        //关闭弹出层
        function CloseDiv(show_div, bg_div) {
            document.getElementById(show_div).style.display = 'none';
            document.getElementById(bg_div).style.display = 'none';
        };

 
 
 
 function checkAccount(){//账号验证
	 var useraccount = document.getElementById('userAccount');
	 var errAccountwd = document.getElementById('accountErr');
	if(useraccount.value.length==0){
		errAccountwd.innerHTML="请检查账号，账号不能为空！";
		 errAccountwd.style.color="red";
		 useraccount.style.border="2px solid #5E2FE7";
		  useraccount.style.borderTopStyle="none";
		  useraccount.style.borderLeftStyle="none";
		  useraccount.style.borderRightStyle="none";
	  return false;
	  }else{
		    errAccountwd.innerHTML="";
			errAccountwd.style.color="#000000";
		 useraccount.style.border="2px solid #5E2FE7";
		  useraccount.style.borderTopStyle="none";
		  useraccount.style.borderLeftStyle="none";
		  useraccount.style.borderRightStyle="none";
	   return true;
	   }
	}
	 function checkPassword(){//密码验证
	 var userpasswd = document.getElementById('userPasword');
	 var errPasswd = document.getElementById('passwordErr');
	 if(userpasswd.value.length==0){
		 errPasswd.innerHTML="请检查密码，密码不能为空！"
		 errPasswd.style.color="red";
		userpasswd.style.border="2px solid #5E2FE7";
		  userpasswd.style.borderTopStyle="none";
		  userpasswd.style.borderLeftStyle="none";
		  userpasswd.style.borderRightStyle="none";
	  return false;
	  }else{
		   errPasswd.innerHTML="";
			errPasswd.style.color="#000000";
		  userpasswd.style.border="2px solid #5E2FE7";
		  userpasswd.style.borderTopStyle="none";
		  userpasswd.style.borderLeftStyle="none";
		  userpasswd.style.borderRightStyle="none";
	   return true;
	   }
	}
		$("#ulogin").click(function(){
			 var accounttip = checkAccount();
			 var passtip = checkPassword();
			if(!(accounttip && passtip)){
			return;
			}
			$.ajax({
				url:"UserloginServlet",
				type:"post",
				data:{
					u_name:$("input[name=u_name]").val(),
					u_pass:$("input[name=u_pass]").val()
				},
				dataType:"json",
				success:function(result){
					var flag = result.flag;
					if(flag==true){
						//如果登录成功则跳转到成功页面
						window.location.href="user/u_index.jsp";
					}else{
						//跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
						alert("账号或密码错误");
					}
				}
			});
			//}
		});
		
		
		
		