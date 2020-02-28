<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


  <div class="navigation">
	 <a href="UserIndexServlet" ><img src="<%=basePath%>/css_js/user/image/we5.png" id="logo"/> </a>
    <ul id="navigation">
      <a href="UserIndexServlet"><li>首页</li></a>
	  <a href="ShowAlbumServlet"><li>相册</li></a>
      <a href="FeedbackForAdminuserServlet"><li>反馈信息</li></a>
    </ul>
	
	  <div class="searchbox">
    <div id="search_bar" class="search_bar">
      <form  id="searchform" action="UserShouSuoServlet" method="post" name="searchform">
        <input class="input" placeholder="想搜点什么呢.." type="text" name="shousuo" id="keyboard">
        <p class="search_ico"> <span></span></p>
      </form>
     </div> 
  </div>
	  </div>
