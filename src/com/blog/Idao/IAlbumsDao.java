package com.blog.Idao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Adminuser;
import com.blog.bean.Albums;
import com.blog.util.DBUtil;

public interface IAlbumsDao {
      
	public boolean updateAlbumsByid(int id,int is_used);
	public boolean albumsAdd(Albums albums);
	public  int getTotalCountfalse();
	public Albums albums(Albums albums);
	public List<Albums> albumsByPagefalse(int currentPage, int pageSize);
	public  int getTotalCount();
	public List<Albums> albumsByPage(int currentPage, int pageSize);
	public boolean updateAlbumsByal_name(Albums albums);
	public Albums Albums(int al_id);
	public int getTotalCountBydianzan(int al_id);
	public List<Albums> albumsYiWang(int u_id,int currentPage, int pageSize);
	public int getTotalCountBydz_user(int dz_user);
	public Albums albumsFirst();
}
