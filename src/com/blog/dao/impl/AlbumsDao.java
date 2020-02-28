package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IAlbumsDao;
import com.blog.bean.Adminuser;
import com.blog.bean.Albums;
import com.blog.bean.DianZan;
import com.blog.util.DBUtil;

public class AlbumsDao implements IAlbumsDao {
	ResultSet rs=null;
	
	public int getTotalCountBydianzan(int al_id) {//查询总数据量
		int count = -1 ;
		String sql = "SELECT COUNT(*) FROM dianzan WHERE is_used=TRUE AND dz_album=?;" ;
		Object[] params={al_id};
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
	
	public boolean updateAlbumsByal_name(Albums albums){
		String sql = "update `weblog`.`albums` set `al_name` =? where `al_id` = ?;" ;
		Object[] params = {albums.getAl_name(),albums.getAl_id()};
		return DBUtil.executeUpdate(sql, params) ;
}
	
	public Albums Albums(int al_id){
		Albums album=null;
		Adminuser adminuser=null;
		String sql="SELECT * from albums where al_id=?;";
		Object[] params={al_id};
		rs = DBUtil.getResulSet(sql, params);
	    try {
				if(rs.next()){
					 String al_name = rs.getString("al_name");
					 int al_author = rs.getInt("al_author");
					 Timestamp timestamp = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 String	 al_url=rs.getString("al_url");
					 album=new Albums();
					 album.setAl_id(al_id);
					 album.setAl_author(al_author);
					 album.setAl_name(al_name);
					 album.setAl_url(al_url);
					 album.setCreatetime(timestamp);
					 album.setIs_used(is_used);
				}
				String sql1="SELECT * from adminuser where a_id=?;";
				Object[] params1={album.getAl_author()};
				rs = DBUtil.getResulSet(sql1, params1);
				if(rs.next()){
				    int id = rs.getInt("a_id");
					 String name = rs.getString("a_name");
					 String  nickname= rs.getString("a_nickname");
					 adminuser =new Adminuser(id,name,null,nickname);
					 album.setAdminuser(adminuser);
				}
				
				
			return album;
		    } catch (SQLException e) {
				e.printStackTrace();
				return null;
			}finally{
		    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		    }
	}
	
	public boolean updateAlbumsByid(int id,int is_used){
		String sql = "UPDATE `weblog`.`albums` SET `is_used` = ? WHERE (`al_id` = ?);" ;
		Object[] params = {is_used,id};
		return DBUtil.executeUpdate(sql, params) ;
}
	public boolean albumsAdd(Albums albums){
		String sql="insert into `weblog`.`albums` (`al_name`,`al_author`, `al_url`) values (?,?,?);";
		Object[] params={albums.getAl_name(),albums.getAl_author(),albums.getAl_url()};
	    return  DBUtil.executeUpdate(sql, params); 
	}
	public  int getTotalCountfalse() {//查询总数据量
		String sql = "SELECT COUNT(*) FROM albums WHERE is_used=false;" ;
		return DBUtil.getTotalCount(sql);
	}
	public Albums albums(Albums albums){
		Albums album=null;
		Adminuser adminuser=null;
		String sql="SELECT albums.* ,adminuser.`a_nickname` FROM `albums` JOIN `adminuser` ON adminuser.a_id=albums.`al_author` WHERE albums.is_used=TRUE AND albums.`al_name`=?;";
		Object[] params={albums.getAl_name()};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			while(rs.next()){
			     int al_id = rs.getInt("al_id");
				 String al_name = rs.getString("al_name");
				 int al_author = rs.getInt("al_author");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 String	 al_url=rs.getString("al_url");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 album=new Albums(al_id,al_name,al_author,timestamp,is_used,adminuser);
				 album.setAl_url(al_url);
			}
		return album;
	    } catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	
	public List<Albums> albumsByPagefalse(int currentPage, int pageSize){
		List<Albums> list = new  ArrayList<Albums>();
		Adminuser adminuser=null;
		Albums albums=null;
		String sql="SELECT albums.* ,adminuser.`a_nickname` FROM `albums` JOIN `adminuser` ON adminuser.a_id=albums.`al_author`  WHERE albums.is_used=false ORDER BY albums.createtime DESC LIMIT ?,?;";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			while(rs.next()){
			     int al_id = rs.getInt("al_id");
				 String al_name = rs.getString("al_name");
				 int al_author = rs.getInt("al_author");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 String	 al_url=rs.getString("al_url");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 albums=new Albums(al_id,al_name,al_author,timestamp,is_used,adminuser);
				 albums.setAl_url(al_url);
				 list.add(albums);
			}
		     for(Albums al:list){
                 sql = "SELECT COUNT(*) FROM photo WHERE p_albums=? and is_used=false";
                 Object[] params1={al.getAl_id()};
         		 rs = DBUtil.getResulSet(sql, params1);
                 if (rs.next()){
                	 al.setCount(rs.getInt(1));
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
	public  int getTotalCount() {//查询总数据量
		String sql = "SELECT COUNT(*) FROM albums WHERE is_used=TRUE;" ;
		return DBUtil.getTotalCount(sql);
	}
	public List<Albums> albumsByPage(int currentPage, int pageSize){
		List<Albums> list = new  ArrayList<Albums>();
		Adminuser adminuser=null;
		Albums albums=null;
		String sql="SELECT albums.* ,adminuser.`a_nickname` FROM `albums` JOIN `adminuser` ON adminuser.a_id=albums.`al_author` WHERE albums.is_used=TRUE ORDER BY albums.createtime DESC LIMIT ?,?;";
		Object[] params={(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			while(rs.next()){
			     int al_id = rs.getInt("al_id");
				 String al_name = rs.getString("al_name");
				 int al_author = rs.getInt("al_author");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 String nickname = rs.getString("a_nickname");
				 boolean is_used = rs.getBoolean("is_used");
				 String	 al_url=rs.getString("al_url");
				 adminuser=new Adminuser();
				 adminuser.setA_nickname(nickname);
				 albums=new Albums(al_id,al_name,al_author,timestamp,is_used,adminuser);
				 albums.setAl_url(al_url);
				 list.add(albums);
			}
		    for(Albums al:list){
                sql = "SELECT COUNT(*) FROM photo WHERE p_albums=? and is_used=true";
                Object[] params1={al.getAl_id()};
        		 rs = DBUtil.getResulSet(sql, params1);
                if (rs.next()){
               	 al.setCount(rs.getInt(1));
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
	
	public int getTotalCountBydz_user(int dz_user) {
		int count = -1 ;
		String sql = "SELECT COUNT(*) FROM dianzan WHERE is_used=TRUE AND `dz_user`=?;" ;
		Object[] params={dz_user};
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
	
	
	public List<Albums> albumsYiWang(int u_id,int currentPage, int pageSize){
		List<Albums> list = new  ArrayList<Albums>();
		Adminuser adminuser=null;
		Albums albums=null;
		String sql="SELECT albums.*,dianzan.`dz_user` FROM `albums` JOIN `dianzan` ON dianzan.dz_album=albums.`al_id` WHERE albums.is_used=TRUE AND dianzan.is_used=TRUE AND  dianzan.`dz_user`=? ORDER BY dianzan.createtime DESC LIMIT ?,?;";
		Object[] params={u_id,(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			while(rs.next()){
			     int al_id = rs.getInt("al_id");
				 String al_name = rs.getString("al_name");
				 int al_author = rs.getInt("al_author");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 boolean is_used = rs.getBoolean("is_used");
				 String	 al_url=rs.getString("al_url");
				 albums=new Albums(al_id,al_name,al_author,timestamp,is_used,adminuser);
				 albums.setAl_url(al_url);
				 list.add(albums);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
	
	public Albums albumsFirst(){
		DianZan dianzan=null;
		String sql="SELECT COUNT(*) COUNT,dz_album FROM  dianzan WHERE is_used = TRUE  GROUP BY dz_album  ORDER BY 'count' DESC LIMIT 1;";
		Object[] params={};
		rs = DBUtil.getResulSet(sql, params);
	    try {
			if(rs.next()){
				int count = rs.getInt("count");
				int dz_album = rs.getInt("dz_album");
				dianzan=new DianZan();
				dianzan.setDz_album(dz_album);
			}
			Albums albums=null;
			Adminuser adminuser=null;
			String sql1="SELECT * FROM albums WHERE al_id =?;";
			Object[] params1={dianzan.getDz_album()};
			rs = DBUtil.getResulSet(sql1, params1);	
			if(rs.next()){
				   int al_id = rs.getInt("al_id");
					 String al_name = rs.getString("al_name");
					 int al_author = rs.getInt("al_author");
					 Timestamp timestamp = rs.getTimestamp("createtime");
					 boolean is_used = rs.getBoolean("is_used");
					 String	 al_url=rs.getString("al_url");
					 albums=new Albums(al_id,al_name,al_author,timestamp,is_used,adminuser);
					 albums.setAl_url(al_url);
			}
			return albums;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
	    	DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
	    }
	}
}
