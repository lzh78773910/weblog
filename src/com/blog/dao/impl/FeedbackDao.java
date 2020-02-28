package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IFeedbackDao;
import com.blog.bean.Adminuser;
import com.blog.bean.Albums;
import com.blog.bean.Feedback;
import com.blog.bean.Feedbackanwer;
import com.blog.bean.User;
import com.blog.util.DBUtil;

public class FeedbackDao implements IFeedbackDao {
	ResultSet rs=null;
	
	public Feedback feedbackDao(int f_id){
		Feedback feedback=null;
		String sql="SELECT * FROM feedback where f_id=?;";
		Object[] params={f_id};
		rs = DBUtil.getResulSet(sql, params);
	    try {
				if(rs.next()){
				    int f_user = rs.getInt("f_user");
					 String f_content = rs.getString("f_content");
					 int f_adminuser = rs.getInt("f_adminuser");
					 Timestamp createtime = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 int is_used0 = rs.getInt("is_used_0");
					 
					 feedback=new Feedback();
					 feedback.setF_adminuser(f_adminuser);
					 feedback.setF_id(f_id);
					 feedback.setF_user(f_user);
					 feedback.setF_content(f_content);
					 feedback.setCreatetime(createtime);
					 feedback.setIs_used(is_used);
					 feedback.setIs_used0(is_used0);
				}
			
				 User user=null;
					String sql1="SELECT * FROM user where u_id=?;";
					Object[] params1={feedback.getF_user()};
					rs = DBUtil.getResulSet(sql1, params1);	
					if(rs.next()){
					    int u_id = rs.getInt("u_id");
						 String name = rs.getString("u_name");
						 byte[] u_pass = rs.getBytes("u_pass");
						 String  u_nickname= rs.getString("u_nickname");
						 String  u_touxiang= rs.getString("u_touxiang");
						 String  u_problem= rs.getString("u_problem");
						 String  u_answer= rs.getString("u_answer");
						 Timestamp timestamp = rs.getTimestamp("createtime");
						 boolean is_used = rs.getBoolean("is_used");
						 
						 user =new User();
						 user.setU_id(u_id);
						 user.setU_name(name);
						 user.setU_pass(u_pass);
						 user.setU_nickname(u_nickname);
						 user.setU_touxiang(u_touxiang);
						 user.setU_problem(u_problem);
						 user.setU_answer(u_answer);
						 user.setCreatetime(timestamp);
						 user.setIs_used(is_used);
					
						 feedback.setUser(user);
						 
					 	 sql = "SELECT * FROM adminuser WHERE a_id=? and is_used=true"; 
						 Object[] params2={feedback.getF_adminuser()};
						 rs = DBUtil.getResulSet(sql, params2);
							Adminuser isuser=null;
					    	if(rs.next()){
							    int id = rs.getInt("a_id");
								 String aname = rs.getString("a_name");
								 byte[] pass = rs.getBytes("a_pass");
								 String  nickname= rs.getString("a_nickname");
								 isuser =new Adminuser(id,aname,pass,nickname);
								 feedback.setAdminuser(isuser);
					    	}
				}
				return feedback;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	
	public boolean insertFeedback(Feedback feedback ){
		String sql = "insert into `weblog`.`feedback` (`f_user`, `f_adminuser`, `f_content`) values (?,?,?)" ;
		Object[] params = {feedback.getF_user(),feedback.getF_adminuser(),feedback.getF_content()};
		return DBUtil.executeUpdate(sql, params) ;
}
	
	public boolean updateFeedback(int is_used_0,int  f_id){
		String sql = "update `weblog`.`feedback` set `is_used_0` = ? where `f_id` = ?" ;
		Object[] params = {is_used_0,f_id};
		return DBUtil.executeUpdate(sql, params) ;
}
	//已读有效反馈
	public int getTotalCountByYiDu(int f_adminuser) {
		int count = -1 ;
		String sql = "SELECT count(*) FROM feedback WHERE f_adminuser=? AND is_used=TRUE AND  is_used_0=1;" ;
		Object[] params={f_adminuser};
	    rs = DBUtil.getResulSet(sql, params);
	    try {
			if(rs.next()) {
				count= rs.getInt(1) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
		return count;
	}
	public List<Feedback> feedbackYiDu(int f_adminuser,int currentPage, int pageSize){
		Feedback feedback=null;
		List<Feedback> list=new  ArrayList<Feedback>();
		String sql="SELECT * FROM feedback WHERE f_adminuser=? AND is_used=TRUE AND  is_used_0=1 ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={f_adminuser,(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
				while(rs.next()){
				    int f_id = rs.getInt("f_id");
				    int f_user = rs.getInt("f_user");
					 String f_content = rs.getString("f_content");
					 Timestamp createtime = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 int is_used0 = rs.getInt("is_used_0");
					 feedback=new Feedback();
					 feedback.setF_id(f_id);
					 feedback.setF_user(f_user);
					 feedback.setF_adminuser(f_adminuser);
					 feedback.setF_content(f_content);
					 feedback.setCreatetime(createtime);
					 feedback.setIs_used(is_used);
					 feedback.setIs_used0(is_used0);
					 list.add(feedback);
				}
				 for(Feedback al:list){
						 sql = "SELECT * FROM user WHERE u_id=? and is_used=true"; 
						 Object[] params1={al.getF_user()};
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
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	//未读
	public int getTotalCountByWeiDu(int f_adminuser) {
		int count = -1 ;
		String sql = "SELECT count(*) FROM feedback WHERE f_adminuser=? AND is_used=TRUE AND  is_used_0=0;" ;
		Object[] params={f_adminuser};
	    rs = DBUtil.getResulSet(sql, params);
	    try {
			if(rs.next()) {
				count= rs.getInt(1) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
		return count;
	}
	public List<Feedback> feedbackWeiDu(int f_adminuser,int currentPage, int pageSize){
		Feedback feedback=null;
		List<Feedback> list=new  ArrayList<Feedback>();
		String sql="SELECT * FROM feedback WHERE f_adminuser=? AND is_used=TRUE AND  is_used_0=0 ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={f_adminuser,(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
				while(rs.next()){
				    int f_id = rs.getInt("f_id");
				    int f_user = rs.getInt("f_user");
					 String f_content = rs.getString("f_content");
					 Timestamp createtime = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 int is_used0 = rs.getInt("is_used_0");
					 feedback=new Feedback();
					 feedback.setF_id(f_id);
					 feedback.setF_user(f_user);
					 feedback.setF_adminuser(f_adminuser);
					 feedback.setF_content(f_content);
					 feedback.setCreatetime(createtime);
					 feedback.setIs_used(is_used);
					 feedback.setIs_used0(is_used0);
					 list.add(feedback);
				}
				 for(Feedback al:list){
					 sql = "SELECT * FROM user WHERE u_id=? and is_used=true"; 
					 Object[] params1={al.getF_user()};
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
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	
	//用户反馈
	public int getTotalCountf_user(int f_user) {
		int count = -1 ;
		String sql = "SELECT count(*) FROM feedback WHERE f_user=? AND is_used=TRUE ;" ;
		Object[] params={f_user};
	    rs = DBUtil.getResulSet(sql, params);
	    try {
			if(rs.next()) {
				count= rs.getInt(1) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
		return count;
	}
	
	public List<Feedback> feedbackf_user(int f_user,int currentPage, int pageSize){
		Feedback feedback=null;
		List<Feedback> list=new  ArrayList<Feedback>();
		String sql="SELECT * FROM feedback WHERE f_user=? AND is_used=TRUE  ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={f_user,(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
				while(rs.next()){
				    int f_id = rs.getInt("f_id");
					 String f_content = rs.getString("f_content");
					   int f_adminuser = rs.getInt("f_adminuser");
					 Timestamp createtime = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 int is_used0 = rs.getInt("is_used_0");
					 feedback=new Feedback();
					 feedback.setF_id(f_id);
					 feedback.setF_adminuser(f_adminuser);
					 feedback.setF_user(f_user);
					 feedback.setF_content(f_content);
					 feedback.setCreatetime(createtime);
					 feedback.setIs_used(is_used);
					 feedback.setIs_used0(is_used0);
					 list.add(feedback);
				}
				 for(Feedback al:list){
						 sql = "SELECT * FROM user WHERE u_id=? and is_used=true"; 
						 Object[] params1={al.getF_user()};
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
		            	 for(Feedback all:list){
		            		 sql = "SELECT * FROM adminuser WHERE a_id=? and is_used=true"; 
							 Object[] params1={all.getF_adminuser()};
							 rs = DBUtil.getResulSet(sql, params1);
								Adminuser isuser=null;
						    	if(rs.next()){
								    int id = rs.getInt("a_id");
									 String name = rs.getString("a_name");
									 byte[] pass = rs.getBytes("a_pass");
									 String  nickname= rs.getString("a_nickname");
									 isuser =new Adminuser(id,name,pass,nickname);
									 all.setAdminuser(isuser);
								 }
							 
		            	 }
		                 
		                 
				
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	
}
