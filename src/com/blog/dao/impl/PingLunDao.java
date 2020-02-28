package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IPingLunDao;
import com.blog.bean.Albums;
import com.blog.bean.DongTai;
import com.blog.bean.PingLun;
import com.blog.bean.User;
import com.blog.util.DBUtil;

public class PingLunDao implements IPingLunDao{
	ResultSet rs =null;
	
	public boolean pinglun(PingLun pinglun){
		String sql = "insert into `weblog`.`pinglun` (`pl_author`, `pl_dongtai`, `pl_content`) values (?,?,?) ";
		Object[] params = {pinglun.getPl_author(),pinglun.getPl_dongtai(),pinglun.getPl_content()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	
	public boolean pinglunis_used(int pl_id,int is_used){
		String sql = "update `weblog`.`pinglun` set `is_used` = ? where `pl_id` = ? ";
		Object[] params = {pl_id,is_used};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public int PingLunCount(int d_id) {
		int count=0;
		String sql = "select count(*) from pinglun where is_used=true and `pl_dongtai`= ?;" ;
		Object[] params={d_id};
	    ResultSet rs = DBUtil.getResulSet(sql, params);
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
	
	public List<PingLun> PingLunByd_id(int currentPage,int pageSize,int id){
		List<PingLun> list=new  ArrayList<PingLun>();
		PingLun pinglun=null;
		User user=null;
		String sql="SELECT pinglun.*,user.`u_nickname`, user.`u_touxiang`,user.`is_used`FROM pinglun JOIN USER ON `pl_author`=`u_id`WHERE pinglun.is_used = TRUE AND pinglun.`pl_dongtai`= ? ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={id,(currentPage-1)*pageSize,pageSize,};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			  while (rs.next()) {
			  int pl_id = rs.getInt("pl_id");
			  String pl_content = rs.getString("pl_content");
			  String u_touxiang = rs.getString("u_touxiang");
			  int pl_author = rs.getInt("pl_author");
			  int pl_dongtai = rs.getInt("pl_dongtai");
			  Timestamp timestamp = rs.getTimestamp("createtime");
			  boolean is_used = rs.getBoolean("is_used");
			  String name = rs.getString("u_nickname");
			  pinglun=new PingLun();
			  user=new User();
			  user.setU_touxiang(u_touxiang);
			  user.setU_nickname(name);
			  pinglun.setUser(user);
              pinglun.setPl_dongtai(pl_dongtai);
			  pinglun.setPl_id(pl_id);
			  pinglun.setPl_content(pl_content);
			  pinglun.setPl_author(pl_author);
			  pinglun.setCreatetime(timestamp);
			  pinglun.setIs_used(is_used);
			  list.add(pinglun);
			}	
			  
			  return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
		
	}
	
	public int PingLunCountpl_author(int pl_author) {
		int count=0;
		String sql = "select count(*) from pinglun where is_used=true and `pl_author`= ?;" ;
		Object[] params={pl_author};
	    ResultSet rs = DBUtil.getResulSet(sql, params);
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
	public List<PingLun> PingLunBypl_author(int currentPage,int pageSize,int pl_author){
		List<PingLun> list=new  ArrayList<PingLun>();
		PingLun pinglun=null;
		User user=null;
		String sql="SELECT pinglun.*,user.`u_nickname`, user.`u_touxiang`,user.`is_used`FROM pinglun JOIN USER ON `pl_author`=`u_id`WHERE pinglun.is_used = TRUE AND pinglun.`pl_author`= ? ORDER BY createtime DESC LIMIT ?,?;";
		Object[] params={pl_author,(currentPage-1)*pageSize,pageSize,};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			  while (rs.next()) {
			  int pl_id = rs.getInt("pl_id");
			  String pl_content = rs.getString("pl_content");
			  String u_touxiang = rs.getString("u_touxiang");
			  int pl_dongtai = rs.getInt("pl_dongtai");
			  Timestamp timestamp = rs.getTimestamp("createtime");
			  boolean is_used = rs.getBoolean("is_used");
			  String name = rs.getString("u_nickname");
			  pinglun=new PingLun();
			  user=new User();
			  user.setU_touxiang(u_touxiang);
			  user.setU_nickname(name);
			  pinglun.setUser(user);
              pinglun.setPl_dongtai(pl_dongtai);
			  pinglun.setPl_id(pl_id);
			  pinglun.setPl_content(pl_content);
			  pinglun.setPl_author(pl_author);
			  pinglun.setCreatetime(timestamp);
			  pinglun.setIs_used(is_used);
			  list.add(pinglun);
			}	
			   for(PingLun pingluns:list){
	                 sql = "SELECT * FROM dongtai WHERE d_id=?";
	                 Object[] params1={pingluns.getPl_dongtai()};
	         		 rs = DBUtil.getResulSet(sql, params1);
	                 if (rs.next()){
	                	 String d_title = rs.getString("d_title");
	                	 DongTai dongtai=new DongTai();
	                	 dongtai.setD_title(d_title);
	                	 pingluns.setDongtai(dongtai);
	                 }
			     }
			  return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
		
	}
}
