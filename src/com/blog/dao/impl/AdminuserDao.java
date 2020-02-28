package com.blog.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IAdminuserDao;
import com.blog.bean.Adminuser;
import com.blog.bean.User;
import com.blog.util.DBUtil;


public class AdminuserDao implements IAdminuserDao {
	ResultSet rs = null;
	public boolean Change_a_pass(Adminuser adminuser,int a_id){
		String sql="update `weblog`.`adminuser` set `a_pass` = ? where `a_id` = ?";
		Object[] params={adminuser.getA_pass(),a_id};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public boolean RegAdminUser(Adminuser adminuser){
		String sql="insert into `weblog`.`adminuser` (`a_name`, `a_pass`, `a_nickname`) values (?, ?, ?)";
		Object[] params={adminuser.getA_name(),adminuser.getA_pass(),adminuser.getA_nickname()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	
	public boolean isAdminuserByname(Adminuser adminuser){
        return  AdminUserReg(adminuser)==null?false:true;
	}
    public Adminuser AdminUserReg(Adminuser adminuser){
    	Adminuser isuser=null;
		String sql="select * from adminuser where a_name=?;";
		Object[] params={adminuser.getA_name()};
		 rs = DBUtil.getResulSet(sql, params);
		try {
			if(rs.next()){
			    int id = rs.getInt("a_id");
				 String name = rs.getString("a_name");
				 byte[] pass = rs.getBytes("a_pass");
				 String  nickname= rs.getString("a_nickname");
				 isuser =new Adminuser(id,name,pass,nickname);
			 }
			  return isuser;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	public boolean Login(String a_name){
        return  adminUserByname(a_name)==null?false:true;
	}
    public Adminuser adminUserByname(String a_name){
    	Adminuser adminuser=null;
		String sql="select * from adminuser where a_name=?;";
		Object[] params={a_name};
		 rs = DBUtil.getResulSet(sql, params);
		try {
			if(rs.next()){
			    int id = rs.getInt("a_id");
				 String name = rs.getString("a_name");
				 byte[] pass = rs.getBytes("a_pass");
				 String  nickname= rs.getString("a_nickname");
				 adminuser =new Adminuser(id,name,pass,nickname);
			 }
			  return adminuser;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}

    public List<Adminuser> adminuserlist(){
    	List<Adminuser> list=new  ArrayList<Adminuser>();
    	Adminuser adminuser=null;
		String sql="select * from adminuser where is_used=true  ORDER BY createtime DESC;";
		Object[] params={};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			    int id = rs.getInt("a_id");
						 String name = rs.getString("a_name");
						 byte[] pass = rs.getBytes("a_pass");
						 String  nickname= rs.getString("a_nickname");
						 adminuser =new Adminuser(id,name,pass,nickname);
				         list.add(adminuser);
			}
				  return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
    }
    
	public  int getTotalCountadminuser() {//查询总数据量
		String sql = "select count(*) from adminuser;" ;
		return DBUtil.getTotalCount(sql);
	}
    
    public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize){
    	List<Adminuser> list=new  ArrayList<Adminuser>();
    	Adminuser adminuser=null;
		String sql="select * from adminuser ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			    int id = rs.getInt("a_id");
						 String name = rs.getString("a_name");
						 byte[] pass = rs.getBytes("a_pass");
						 String  nickname= rs.getString("a_nickname");
						 adminuser =new Adminuser(id,name,pass,nickname);
				         list.add(adminuser);
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
