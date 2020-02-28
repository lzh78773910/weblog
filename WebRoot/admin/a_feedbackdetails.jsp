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
    
    <title>反馈详情</title>
    
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
      <td>反馈详情</td>
    </tr>
  </tbody>
		  <hr>
</table><hr>
    
	  <table width="1200" height="220" border="1" class="fbxs">
		<tbody>
    <tr >
      <td valign="top" class="fbcontent">
		  内容：
		  <p style="text-indent:2em;">${feedback.f_content }</p><br/>
		  <span class="fbtime">时间：${feedback.createtime }</span>
		  <br/>
		  <p class="fbtime">作者：${feedback.user.u_nickname}</p></td>
    </tr>
  </tbody>
</table>
	  <h2 style="margin-left: 50px;">管理员${feedbackanwer.adminuser.a_nickname }回复：</h2>
	  
	  
	  <form action="adminservlet/FeedbackAminHuiFuServlet">
	  <input type="hidden" name="f_id" value="${feedback.f_id }" >
	  <textarea class="adminfb" name="fa_content"></textarea>
      <input type="submit" value="回复" class="fbsubmit" />	
	  </form>
	  
	  <table width="1200" height="100" border="1" class="fbhf">
  <tbody>
    <tr>
      <td valign="top" >
	    <ul class="fbnr">
	    <c:forEach items="${requestScope.page.feedbackanwer }" var="feedbackanwer">
		 <li>
		 <c:if test="${feedbackanwer.fa_leixin==1 }">
			该用户回复：
			</c:if>
				  <c:if test="${feedbackanwer.fa_leixin==0 }">
			管理员${feedbackanwer.adminuser.a_nickname }回复：
			</c:if>
		  <br/>
		  <p style="text-indent:2em; font-size: 25px; padding-left: 15px;">${feedbackanwer.fa_content }</p><br/>
		  <span class="fbtime">时间：${feedbackanwer.createtime }</span>
		 </li>
		</c:forEach>	
		 </ul> 
		  
		 <div class="pagelist pagebg">
      &nbsp;<a href="adminservlet/FeedbackDetailsServlet?currentPage=1&f_id=${feedback.f_id }">首页
      </a>&nbsp;<a href="adminservlet/FeedbackDetailsServlet?currentPage=${page.currentPage==1?1 : page.currentPage-1}&f_id=${feedback.f_id }"> 上一页</a>
	  &nbsp;<b>${page.currentPage}/${page.totalPage}</b>&nbsp;</b>
	  <a href="adminservlet/FeedbackDetailsServlet?currentPage=${page.currentPage == page.totalPage?page.totalPage : page.currentPage+1}&f_id=${feedback.f_id }">下一页
	  </a>&nbsp;<a href="adminservlet/FeedbackDetailsServlet?currentPage=${page.totalPage}&f_id=${feedback.f_id }">尾页</a>
	  </div>
	</td>
		
    </tr>
  </tbody>
	
</table>
 
</div>    

 
</div>
</body>
</html>
