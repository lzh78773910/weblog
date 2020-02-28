package com.blog.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.Idao.IPhotosDao;
import com.blog.bean.Albums;
import com.blog.bean.Photos;
import com.blog.util.DBUtil;

public class PhotosDao implements IPhotosDao {
	ResultSet rs =null;
	
	
	public boolean Photosadd(Photos photos){
		String sql="insert into `weblog`.`photo` (`p_title`, `p_url`, `p_albums`, `p_author`) values (?,?,?,?)";
		Object[] params={photos.getP_title(),photos.getP_url(),photos.getP_album(),photos.getP_author()};
	    return  DBUtil.executeUpdate(sql, params); 
	    }
	public boolean PhotosByis_used(int p_id,int is_used){
		String sql="UPDATE `weblog`.`photo` SET `is_used` = ? WHERE `p_id` = ?;";
		Object[] params={is_used,p_id};
	    return  DBUtil.executeUpdate(sql, params); 
	    }
	
	
	public int getTotalCountByp_albums(int p_albums) {//查询总数据量
		int count = -1 ;
		String sql = "SELECT COUNT(*) FROM photo WHERE is_used=TRUE AND p_albums=?;" ;
		Object[] params={p_albums};
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
	public List<Photos> photosByp_albums(int p_albums,int currentPage, int pageSize) {
		List<Photos> list = new  ArrayList<Photos>();
		ResultSet rs=null;
		Photos photos =null;
		String sql = "SELECT * FROM `photo`  WHERE is_used=TRUE AND `p_albums`=? ORDER BY createtime DESC  LIMIT ?,?;" ;
		Object[] params={p_albums,(currentPage-1)*pageSize,pageSize};
	    rs = DBUtil.getResulSet(sql, params);
	 	 try {
			while(rs.next()){
				 int p_album = rs.getInt("p_albums");
			     int p_id = rs.getInt("p_id");
				 String p_title = rs.getString("p_title");
				 String p_url = rs.getString("p_url");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 boolean is_used = rs.getBoolean("is_used");
				 photos = new Photos();
				 photos.setP_id(p_id);
				 photos.setP_title(p_title);
				 photos.setP_url(p_url);
				 photos.setP_album(p_album);
				 photos.setCreatetime(timestamp);
				 photos.setIs_used(is_used);
				 list.add(photos);
			 }
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs,DBUtil.pstmt,DBUtil.connection);
		}
	}
	
	public  int getTotalCounttrue() {//查询总数据量
		String sql = "select count(*) from Photo where is_used=true" ;
		return DBUtil.getTotalCount(sql);
	}
	
	public List<Photos> photosByp_albumstrue(int currentPage, int pageSize) {
		List<Photos> list = new  ArrayList<Photos>();
		ResultSet rs=null;
		Photos photos =null;
		String sql = "SELECT * FROM `Photo`  WHERE is_used=TRUE ORDER BY createtime DESC LIMIT ?,?" ;
		Object[] params={(currentPage-1)*pageSize,pageSize};
	    rs = DBUtil.getResulSet(sql, params);
	 	 try {
			while(rs.next()){
			     int p_id = rs.getInt("p_id");
			     int p_album = rs.getInt("p_albums");
				 String p_title = rs.getString("p_title");
				 String p_url = rs.getString("p_url");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 boolean is_used = rs.getBoolean("is_used");
				 photos = new Photos();
				 photos.setP_id(p_id);
				 photos.setP_title(p_title);
				 photos.setP_album(p_album);
				 photos.setP_url(p_url);
				 photos.setCreatetime(timestamp);
				 photos.setIs_used(is_used);
				 list.add(photos);
			 }
		     for(Photos photo:list){
		    	 Albums albums=null;
                 sql = "SELECT * FROM albums WHERE al_id=?";
                 Object[] params1={photo.getP_album()};
         		 rs = DBUtil.getResulSet(sql, params1);
                 if (rs.next()){
                	 String al_name = rs.getString("al_name");
                	 albums=new Albums();
                	 albums.setAl_name(al_name);
                	 photo.setAlbums(albums);
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
	
	public  int getTotalCountfalse() {//查询总数据量
		String sql = "select count(*) from Photo where is_used=false" ;
		return DBUtil.getTotalCount(sql);
	}
	
	public List<Photos> photosByp_albumsfalse(int currentPage, int pageSize) {
		List<Photos> list = new  ArrayList<Photos>();
		ResultSet rs=null;
		Photos photos =null;
		String sql = "SELECT * FROM `Photo`  WHERE is_used=false ORDER BY createtime DESC LIMIT ?,?;" ;
		Object[] params={(currentPage-1)*pageSize,pageSize};
	    rs = DBUtil.getResulSet(sql, params);
	 	 try {
			while(rs.next()){
			     int p_id = rs.getInt("p_id");
			     int p_album = rs.getInt("p_albums");
				 String p_title = rs.getString("p_title");
				 String p_url = rs.getString("p_url");
				 Timestamp timestamp = rs.getTimestamp("createtime");
				 boolean is_used = rs.getBoolean("is_used");
				 photos = new Photos();
				 photos.setP_id(p_id);
				 photos.setP_title(p_title);
				 photos.setP_url(p_url);
				 photos.setP_album(p_album);
				 photos.setCreatetime(timestamp);
				 photos.setIs_used(is_used);
				 list.add(photos);
			 }
			for(Photos photo:list){
		    	 Albums albums=null;
                sql = "SELECT * FROM albums WHERE al_id=?";
                Object[] params1={photo.getP_album()};
        		 rs = DBUtil.getResulSet(sql, params1);
                if (rs.next()){
               	 String al_name = rs.getString("al_name");
               	 albums=new Albums();
               	 albums.setAl_name(al_name);
               	 photo.setAlbums(albums);
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
