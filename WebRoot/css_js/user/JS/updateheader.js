// JavaScript Document

    function showPreview(source) {
      var file = source.files[0];
      if(window.FileReader) {
          var fr = new FileReader();
          console.log(fr);
          var headernow = document.getElementById('headernow');
          fr.onloadend = function(e) {
            headernow.src = e.target.result;
			  headernow.style.border="#FFFFFF 5px solid";
			  headernow.style.boxShadow="#666 0px 0px 8px";
			  headernow.style.marginBottom="4px";
          };
          fr.readAsDataURL(file);
          headernow.style.display = 'block';
      }
    }


function checkForm(){
 var oldanswertip = oldAnswer();
 var newanswertip = newAnswer();
 return oldanswertip && answertip ;
 }

function checkForm2(){
	 var oldpasstip = oldPass();
	 var passtip = checkPassword();
	 var confirmpasstip = ConfirmPassword();
	 return oldpasstip && passtip;
	 }


function oldAnswer(){
 var olduseranswer = document.getElementById('olduserAnswer');
 var olderranswer = document.getElementById('oldanswerErr');
 if(olduseranswer.value.length == 0){
  olderranswer.innerHTML="答案不能为空"
	 olderranswer.style.color="red";
  return false;
  }else{
   olderranswer.innerHTML=""
   return true;
   }
 }
function newAnswer(){
 var newuseranswer = document.getElementById('newuserAnswer');
 var newerranswer = document.getElementById('newanswerErr');
 if(newuseranswer.value.length == 0){
  newerranswer.innerHTML="答案不能为空"
	 newerranswer.style.color="red";
  return false;
  }else{
   newerranswer.innerHTML=""
   return true;
   }
 }

function oldPass(){
 var olduserpass = document.getElementById('olduserPass');
 var errOldpasswd = document.getElementById('oldpassErr');
 if(olduserpass.value.length == 0){
  errOldpasswd.innerHTML="答案不能为空"
	 errOldpasswd.style.color="red";
  return false;
  }else{
   errOldpasswd.innerHTML=""
   return true;
   }
 }


function checkPassword(){
 var userpasswd = document.getElementById('userPasword');
 var errPasswd = document.getElementById('passwordErr');
 var pattern = /^.{6,8}$/;
 if(!pattern.test(userpasswd.value)){
  errPasswd.innerHTML="密码不合规范"
  errPasswd.style.color="red";
  return false;
  }else{
   errPasswd.innerHTML=""
   return true;
   }
 }
function ConfirmPassword(){
 var userpasswd = document.getElementById('userPasword');
 var userConPassword = document.getElementById('userConfirmPasword');
 var errConPasswd = document.getElementById('conPasswordErr');
 if((userpasswd.value)!=(userConPassword.value)||userConPassword.value.length == 0){
  errConPasswd.innerHTML="上下密码不一致"
  errConPasswd.style.color="red";
  return false;
  }else{
   errConPasswd.innerHTML=""
   return true;
   }
 }



function show1(){
    document.getElementById('nameId').style.display = ""; 
	document.getElementById('nameId2').style.display = "none";//显示
}

function show2(){
    document.getElementById('nameId2').style.display = ""; 
	 document.getElementById('nameId').style.display = "none";
	//显示
}
