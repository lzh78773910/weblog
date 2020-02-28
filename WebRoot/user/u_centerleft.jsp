<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

   <div class="personalleft">
			<h3>个人中心</h3>
			<ul class="leftlist">
				<a href="userservlet/UserInformationServlet"><li class="fontawesome-edit">个人信息</li></a>		
				<a href="userservlet/UserObtainUpdateServlet"><li class="fontawesome-cogs">修改信息</li></a>
				<a href="userservlet/UserObtainProtectServlet"><li class="fontawesome-ok-sign">账号安全</li></a>
				<a href="userservlet/PingLunPastServlet"><li class="fontawesome-list-alt">查看以往评论</li></a>
				<a href="userservlet/DianZanPastServlet"><li class="fontawesome-heart">查看以往点赞</li></a>
				<a href="userservlet/ShowiFeedbackServlet"><li class="fontawesome-comments">查看反馈</li></a>		
			</ul>
	</div>