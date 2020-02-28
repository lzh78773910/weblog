package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IFeedbackanwerDao;
import com.blog.bean.Adminuser;
import com.blog.bean.Albums;
import com.blog.bean.Feedback;
import com.blog.bean.Feedbackanwer;
import com.blog.bean.User;
import com.blog.util.DBUtil;

public class FeedbackanwerDao implements IFeedbackanwerDao {
	ResultSet rs = null;

	public boolean insertfa_admin(Feedbackanwer feedbackanwer) {
		String sql = "insert into `weblog`.`feedbackanwer` (`fa_leixin`, `fa_admin`, `fa_feedback`, `fa_content`) values (?,?,?,?)";
		Object[] params = { feedbackanwer.getFa_leixin(),
				feedbackanwer.getFa_admin(), feedbackanwer.getFa_feedback(),
				feedbackanwer.getFa_content() };
		return DBUtil.executeUpdate(sql, params);
	}

	public boolean insertfa_user(Feedbackanwer feedbackanwer) {
		String sql = "insert into `weblog`.`feedbackanwer` (`fa_leixin`, `fa_user`, `fa_feedback`, `fa_content`) values (?,?,?,?)";
		Object[] params = { feedbackanwer.getFa_leixin(),
				feedbackanwer.getFa_user(), feedbackanwer.getFa_feedback(),
				feedbackanwer.getFa_content() };
		return DBUtil.executeUpdate(sql, params);
	}

	public int getTotalCountByfa_feedback(int fa_feedback) {
		int count = -1;
		String sql = "SELECT count(*) FROM feedbackanwer WHERE fa_feedback=? AND is_used=TRUE;";
		Object[] params = { fa_feedback };
		rs = DBUtil.getResulSet(sql, params);
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
		return count;
	}

	public List<Feedbackanwer> feedbackanwerByfeedback(int fa_feedback, int currentPage,
			int pageSize) {
		Feedbackanwer feedbackanwer = null;
		List<Feedbackanwer> list = new ArrayList<Feedbackanwer>();
		String sql = "SELECT * FROM feedbackanwer WHERE fa_feedback=? AND is_used=TRUE ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params = { fa_feedback, (currentPage - 1) * pageSize, pageSize };
		rs = DBUtil.getResulSet(sql, params);
		try {
			while (rs.next()) {
				int fa_id = rs.getInt("fa_id");
				int fa_leixin = rs.getInt("fa_leixin");
				int fa_admin = rs.getInt("fa_admin");
				int fa_user = rs.getInt("fa_user");
				String fa_content = rs.getString("fa_content");
				Timestamp createtime = rs.getTimestamp("createtime");
				boolean is_used = rs.getBoolean("is_used");
				feedbackanwer=new Feedbackanwer();
				feedbackanwer.setFa_id(fa_id);
				feedbackanwer.setFa_leixin(fa_leixin);
				feedbackanwer.setFa_admin(fa_admin);
				feedbackanwer.setFa_user(fa_user);
				feedbackanwer.setFa_feedback(fa_feedback);
				feedbackanwer.setFa_content(fa_content);
				feedbackanwer.setCreatetime(createtime);
				feedbackanwer.setIs_used(is_used);
				list.add(feedbackanwer);
			}
			 for(Feedbackanwer al:list){
			
				 int fa_leixin = al.getFa_leixin();
				
				 if("0".equals(fa_leixin)||fa_leixin==0){

					 sql = "SELECT * FROM adminuser WHERE a_id=? and is_used=true"; 
					 Object[] params1 ={al.getFa_admin()};
					 rs = DBUtil.getResulSet(sql, params1);
	                 if (rs.next()){
	             	    int id = rs.getInt("a_id");
	   				 String name = rs.getString("a_name");
	   				 byte[] pass = rs.getBytes("a_pass");
	   				 String  nickname= rs.getString("a_nickname");
	   				 Adminuser adminuser = new Adminuser(id,name,pass,nickname);
	   				al.setAdminuser(adminuser);
	                 }
				 }else{
					 sql = "SELECT * FROM user WHERE u_id=? and is_used=true"; 
					 Object[] params1={al.getFa_user()};
					 rs = DBUtil.getResulSet(sql, params1);
	                 if (rs.next()){
	         		    int u_id = rs.getInt("u_id");
	   				 String name = rs.getString("u_name");
	   				 byte[] u_pass = rs.getBytes("u_pass");
	   				 String  u_nickname= rs.getString("u_nickname");
	   				 String  u_touxiang= rs.getString("u_touxiang");
	   				 String  u_problem= rs.getString("u_problem");
	   				 String  u_answer= rs.getString("u_answer");
	   				 Timestamp timestamp = rs.getTimestamp("createtime");
	   				 boolean is_used = rs.getBoolean("is_used");
	   			
	   				 User user =new User();
	   				 user.setU_id(u_id);
	   				 user.setU_name(name);
	   				 user.setU_pass(u_pass);
	   				 user.setU_nickname(u_nickname);
	   				 user.setU_touxiang(u_touxiang);
	   				 user.setU_problem(u_problem);
	   				 user.setU_answer(u_answer);
	   				 user.setCreatetime(timestamp);
	   				 user.setIs_used(is_used);
	   				 al.setUser(user);
	                 }
				 }
		     }
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
	}
	
	public List<Feedbackanwer> feedbackanwer(int fa_feedback) {
		Feedbackanwer feedbackanwer = null;
		List<Feedbackanwer> list = new ArrayList<Feedbackanwer>();
		String sql = "SELECT * FROM feedbackanwer WHERE fa_feedback=? AND is_used=TRUE  ;";
		Object[] params = { fa_feedback};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while (rs.next()) {
				int fa_id = rs.getInt("fa_id");
				int fa_leixin = rs.getInt("fa_leixin");
				int fa_admin = rs.getInt("fa_admin");
				int fa_user = rs.getInt("fa_user");
				String fa_content = rs.getString("fa_content");
				Timestamp createtime = rs.getTimestamp("createtime");
				boolean is_used = rs.getBoolean("is_used");
				feedbackanwer=new Feedbackanwer();
				feedbackanwer.setFa_id(fa_id);
				feedbackanwer.setFa_leixin(fa_leixin);
				feedbackanwer.setFa_admin(fa_admin);
				feedbackanwer.setFa_user(fa_user);
				feedbackanwer.setFa_feedback(fa_feedback);
				feedbackanwer.setFa_content(fa_content);
				feedbackanwer.setCreatetime(createtime);
				feedbackanwer.setIs_used(is_used);
				list.add(feedbackanwer);
			}
			 for(Feedbackanwer al:list){
			
				 int fa_leixin = al.getFa_leixin();
				
				 if("0".equals(fa_leixin)||fa_leixin==0){

					 sql = "SELECT * FROM adminuser WHERE a_id=? and is_used=true"; 
					 Object[] params1 ={al.getFa_admin()};
					 rs = DBUtil.getResulSet(sql, params1);
	                 if (rs.next()){
	             	    int id = rs.getInt("a_id");
	   				 String name = rs.getString("a_name");
	   				 byte[] pass = rs.getBytes("a_pass");
	   				 String  nickname= rs.getString("a_nickname");
	   				 Adminuser adminuser = new Adminuser(id,name,pass,nickname);
	   				al.setAdminuser(adminuser);
	                 }
				 }else{
					 sql = "SELECT * FROM user WHERE u_id=? and is_used=true"; 
					 Object[] params1={al.getFa_user()};
					 rs = DBUtil.getResulSet(sql, params1);
	                 if (rs.next()){
	         		    int u_id = rs.getInt("u_id");
	   				 String name = rs.getString("u_name");
	   				 byte[] u_pass = rs.getBytes("u_pass");
	   				 String  u_nickname= rs.getString("u_nickname");
	   				 String  u_touxiang= rs.getString("u_touxiang");
	   				 String  u_problem= rs.getString("u_problem");
	   				 String  u_answer= rs.getString("u_answer");
	   				 Timestamp timestamp = rs.getTimestamp("createtime");
	   				 boolean is_used = rs.getBoolean("is_used");
	   			
	   				 User user =new User();
	   				 user.setU_id(u_id);
	   				 user.setU_name(name);
	   				 user.setU_pass(u_pass);
	   				 user.setU_nickname(u_nickname);
	   				 user.setU_touxiang(u_touxiang);
	   				 user.setU_problem(u_problem);
	   				 user.setU_answer(u_answer);
	   				 user.setCreatetime(timestamp);
	   				 user.setIs_used(is_used);
	   				 al.setUser(user);
	                 }
				 }
		     }
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
	}
}
