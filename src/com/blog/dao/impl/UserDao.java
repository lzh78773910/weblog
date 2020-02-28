package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IUserDao;
import com.blog.bean.PingLun;
import com.blog.bean.User;
import com.blog.util.DBUtil;

public class UserDao implements IUserDao {
	ResultSet rs =null;
	
	public boolean userByu_answer(User user){
		String sql="update `weblog`.`user` set `u_problem` = ? , `u_answer` = ? where `u_id` = ?";
		Object[] params={user.getU_problem(),user.getU_answer(),user.getU_id()};
	    return  DBUtil.executeUpdate(sql, params); 
	}	
		
	public boolean useru_nickname(User user){
		String sql="update `weblog`.`user` set `u_nickname` = ?  where `u_id` = ?";
		Object[] params={user.getU_nickname(),user.getU_id()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public boolean userxinxi(User user){
		String sql="update `weblog`.`user` set `u_nickname` = ? , `u_touxiang` = ? where `u_id` = ?";
		Object[] params={user.getU_nickname(),user.getU_touxiang(),user.getU_id()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public boolean Change_a_pass(User user,int u_id){
		String sql="update `weblog`.`user` set `u_pass` = ? where `u_id` = ?";
		Object[] params={user.getU_pass(),u_id};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public boolean RegUser(User user){
		String sql="insert into `weblog`.`user` (`u_name`, `u_pass`, `u_problem`, `u_answer`,u_nickname) values (?,?,?,?,?)";
		Object[] params={user.getU_name(),user.getU_pass(),user.getU_problem(),user.getU_answer(),user.getU_nickname()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public  int getTotalCount() {//查询总数据量
		String sql = "select count(*) from user where is_used=true" ;
		return DBUtil.getTotalCount(sql);
	}
	
	public List<User> Userlist(int currentPage, int pageSize){
		List<User> list=new  ArrayList<User>();
		 User user=null;
		String sql="select * from user ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
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
				 list.add(user);
			 }
			  return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	
	public User UserByname(String u_name){
		   User user=null;
			String sql="select * from user where u_name=?;";
			Object[] params={u_name};
			rs = DBUtil.getResulSet(sql, params);
			try {
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
					 
				 }
				  return user;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
		}
	public boolean userByis_used(int id,int is_used){
		String sql = "update `weblog`.`user` set is_used=? where `u_id` = ?" ;
		Object[] params = {is_used,id};
		return DBUtil.executeUpdate(sql, params) ;
}
}
