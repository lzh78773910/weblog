package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IDongTaiDao;
import com.blog.bean.Adminuser;
import com.blog.bean.DongTai;
import com.blog.util.DBUtil;


public class DongTaiDao implements IDongTaiDao{
	ResultSet rs=null;
	public boolean dongtai(int d_id){
		String sql = "UPDATE `weblog`.`dongtai` SET `d_liulang` = d_liulang+1 WHERE `d_id` =? ";
		Object[] params = {d_id};
		return DBUtil.executeUpdate(sql, params) ;
	}
	public DongTai dongtaiDetails(int d_id){
		DongTai dongtai=null;
		Adminuser adminuser=null;
		String sql="SELECT dongtai.*,adminuser.`a_nickname` FROM `dongtai` JOIN `adminuser` ON adminuser.a_id=dongtai.`d_author` where dongtai.d_id=?;";
		Object[] params={d_id};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			     int id = rs.getInt("d_id");
				 String title = rs.getString("d_title");
				 String content = rs.getString("d_content");
				 int author = rs.getInt("d_author");
				 String nickname = rs.getString("a_nickname");
				 int d_liulang = rs.getInt("d_liulang");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 boolean is_used = rs.getBoolean("is_used");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 dongtai=new DongTai(id,title,content,author,timestamp,is_used);
				 dongtai.setAdminuser(adminuser);
				 dongtai.setD_liulang(d_liulang);
			 }
			return dongtai;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	public boolean dongtaiXiuGai(DongTai dongtai){
		String sql = "update `weblog`.`dongtai` set `d_title` = ? , `d_content` = ? where `d_id` = ?;";
		Object[] params = {dongtai.getD_title(),dongtai.getD_content(),dongtai.getD_id()};
		return DBUtil.executeUpdate(sql, params) ;
	}
	
	public boolean dongtaiAdd(int d_author,DongTai dongtai){
		String sql = "insert into `weblog`.`dongtai` (`d_title`, `d_content`, `d_author`) values(?,?,?)" ;
		Object[] params = {dongtai.getD_title(),dongtai.getD_content(),d_author};
		return DBUtil.executeUpdate(sql, params) ;
	}	
	
	public boolean updateDongTaiByid(int id,int is_used){
		String sql = "update `weblog`.`dongtai` set is_used=? where `d_id` = ?" ;
		Object[] params = {is_used,id};
		return DBUtil.executeUpdate(sql, params) ;
}
	
	public  int getTotalCount() {//查询总数据量
		String sql = "select count(*) from dongtai where is_used=true" ;
		return DBUtil.getTotalCount(sql);
	}
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize) {
		List<DongTai> list = new  ArrayList<DongTai>();
        DongTai dongtai=null;
        Adminuser adminuser=null;
		String sql="SELECT dongtai.*,adminuser.`a_nickname` FROM `dongtai` JOIN `adminuser` ON adminuser.a_id=dongtai.`d_author` where dongtai.is_used=true  ORDER BY dongtai.createtime DESC LIMIT ?,?;";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			     int id = rs.getInt("d_id");
				 String title = rs.getString("d_title");
				 String content = rs.getString("d_content");
				 int author = rs.getInt("d_author");
				 int d_liulang = rs.getInt("d_liulang");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 dongtai=new DongTai(id,title,content,author,timestamp,is_used);
				 dongtai.setAdminuser(adminuser);
				 dongtai.setD_liulang(d_liulang);
				 list.add(dongtai);
			 }
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	public  int getTotalCountfalse() {//查询总数据量
		String sql = "select count(*) from dongtai where is_used=false" ;
		return DBUtil.getTotalCount(sql);
	}
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize) {
		List<DongTai> list = new  ArrayList<DongTai>();
        DongTai dongtai=null;
        Adminuser adminuser=null;
		String sql="SELECT dongtai.*,adminuser.`a_nickname` FROM `dongtai` JOIN `adminuser` ON adminuser.a_id=dongtai.`d_author` where dongtai.is_used=false  ORDER BY dongtai.createtime DESC LIMIT ?,?";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			     int id = rs.getInt("d_id");
				 String title = rs.getString("d_title");
				 String content = rs.getString("d_content");
				 int author = rs.getInt("d_author");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 dongtai=new DongTai(id,title,content,author,timestamp,is_used);
				 dongtai.setAdminuser(adminuser);
				 list.add(dongtai);
			 }
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize){
		List<DongTai> list = new  ArrayList<DongTai>();
		 DongTai dongtai=null;
	     Adminuser adminuser=null;
			String sql="SELECT dongtai.*,adminuser.`a_nickname` FROM `dongtai` JOIN `adminuser` ON adminuser.a_id=dongtai.`d_author` WHERE dongtai.is_used=TRUE  ORDER BY `d_liulang` DESC LIMIT ?,?;";
			Object[] params={(currentPage-1)*pageSize,pageSize};
			rs = DBUtil.getResulSet(sql, params);
			try {
				while(rs.next()){
				     int id = rs.getInt("d_id");
					 String title = rs.getString("d_title");
					 String content = rs.getString("d_content");
					 int author = rs.getInt("d_author");
					 int d_liulang = rs.getInt("d_liulang");
					 Timestamp timestamp = rs.getTimestamp("createtime");
					 String nickname = rs.getString("a_nickname");
					 boolean is_used = rs.getBoolean("is_used");
					 adminuser=new Adminuser();
					 adminuser.setA_nickname(nickname);
					 dongtai=new DongTai(id,title,content,author,timestamp,is_used);
					 dongtai.setAdminuser(adminuser);
					 dongtai.setD_liulang(d_liulang);
					 list.add(dongtai);
				 }
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	public int getTotalCountShouSuo(String shousuo) {//查询总数据量
		int count = -1 ;
		String sql = "SELECT COUNT(*) FROM `dongtai`  WHERE d_title LIKE ? AND dongtai.is_used=TRUE;" ;
		Object[] params={"%"+shousuo+"%"};
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
	public List<DongTai> dongtaiShouSuo(String shousuo,int currentPage, int pageSize) {
		List<DongTai> list = new  ArrayList<DongTai>();
        DongTai dongtai=null;
        Adminuser adminuser=null;
		String sql="SELECT dongtai.*,adminuser.`a_nickname` FROM `dongtai` JOIN `adminuser` ON adminuser.a_id=dongtai.`d_author` WHERE d_title LIKE ? or d_content 	LIKE ?  AND dongtai.is_used=TRUE  LIMIT ?,?;";
		Object[] params={"%"+shousuo+"%","%"+shousuo+"%",(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
		try {
			while(rs.next()){
			     int id = rs.getInt("d_id");
				 String title = rs.getString("d_title");
				 String content = rs.getString("d_content");
				 int author = rs.getInt("d_author");
				 int d_liulang = rs.getInt("d_liulang");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 dongtai=new DongTai(id,title,content,author,timestamp,is_used);
				 dongtai.setAdminuser(adminuser);
				 dongtai.setD_liulang(d_liulang);
				 list.add(dongtai);
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
