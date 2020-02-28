
 function checkForm(){
 var nametip = checkUserName();
 var passtip = checkPassword();
 var conpasstip = ConfirmPassword();
 var answertip = Answer();
 return nametip && passtip && conpasstip && answertip;
 }
function checkUserName(){
 var username = document.getElementById('userName');
 var errname = document.getElementById('nameErr');
 if(username.value.length == 0){
  errname.innerHTML="用户名不能为空";
  return false;
  }else{
   errname.innerHTML="";
   return true;
   }
 }
function checkPassword(){
 var userpasswd = document.getElementById('userPasword');
 var errPasswd = document.getElementById('passwordErr');
 var pattern = /^.{6,8}$/;
 if(!pattern.test(userpasswd.value)){
  errPasswd.innerHTML="密码不合规范";
  return false;
  }else{
   errPasswd.innerHTML="";
   return true;
   }
 }
function ConfirmPassword(){
 var userpasswd = document.getElementById('userPasword');
 var userConPassword = document.getElementById('userConfirmPasword');
 var errConPasswd = document.getElementById('conPasswordErr');
 if((userpasswd.value)!=(userConPassword.value)||userConPassword.value.length == 0){
  errConPasswd.innerHTML="上下密码不一致";
  return false;
  }else{
   errConPasswd.innerHTML="";
   return true;
   }
 }
function Answer(){
 var useranswer = document.getElementById('userAnswer');
 var erranswer = document.getElementById('answerErr');
 if(useranswer.value.length == 0){
  erranswer.innerHTML="答案不能为空";
  return false;
  }else{
   erranswer.innerHTML="";
   return true;
   }
 }
