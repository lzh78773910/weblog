<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<div id="menu">
	<h1 onClick="javascript:ShowMenu(this,'NO0')"> 基本信息管理</h1>
      <span id="NO0" class="no">
   <a href="admin/a_changepassword.jsp"><h2 onClick="javascript:ShowMenu(this,'NO00')"> - 修改密码</h2></a>

    <a href="admin/a_reg.jsp"><h2 onClick="javascript:ShowMenu(this,'NO01')"> - 添加管理员</h2></a>
   
   <a href="adminservlet/UserListServlet"><h2 onClick="javascript:ShowMenu(this,'NO02')"> - 用户管理</h2></a>
</span>


        <h1 onClick="javascript:ShowMenu(this,'NO2')"> 相册管理</h1>
        <span id="NO2" class="no">
   <a href="admin/a_Albumsadd.jsp"><h2 onClick="javascript:ShowMenu(this,'NO20')"> - 相册创建</h2></a>
   
   <a href="adminservlet/AlbumServlet"><h2 onClick="javascript:ShowMenu(this,'NO21')"> - 相册管理</h2></a>
    <a href="adminservlet/AlbumRBServlet"><h2 onClick="javascript:ShowMenu(this,'NO21')"> - 相册回收站</h2></a>
    <a href="adminservlet/PhotosAllServlet"><h2 onClick="javascript:ShowMenu(this,'NO21')"> - 查看所有照片</h2></a>
    <a href="adminservlet/PhotosRBAllServlet"><h2 onClick="javascript:ShowMenu(this,'NO21')"> - 照片回收站</h2></a>
</span>
     <h1 onClick="javascript:ShowMenu(this,'NO3')"> 动态管理</h1>
        <span id="NO3" class="no">
    <a href="admin/a_dongtaiadd.jsp"><h2 onClick="javascript:ShowMenu(this,'NO30')"> - 动态发布</h2></a>
  
     <a href="adminservlet/DongTaiServlet"> <h2 onClick="javascript:ShowMenu(this,'NO31')"> - 动态管理</h2></a>
			
   <a href="adminservlet/DongTaiRBServlet"> <h2 onClick="javascript:ShowMenu(this,'NO32')"> - 动态回收站</h2></a>
</span>

		<h1 onClick="javascript:ShowMenu(this,'NO5')"> 反馈信息查看</h1>
        <span id="NO5" class="no">
 <a href="adminservlet/FeedbackWeiDuServlet">  <h2 onClick="javascript:ShowMenu(this,'NO35')"> - 未读反馈信息查看</h2></a>
 <a href="adminservlet/FeedbackServlet"> <h2 onClick="javascript:ShowMenu(this,'NO35')"> - 已读反馈信息查看</h2></a>
</span>
	</div>
