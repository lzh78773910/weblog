package com.blog.Iservice;

import java.util.List;

import com.blog.bean.Albums;

public interface IAlbumsService {
	public boolean updateAlbumsByid(int id,int is_used);
	/**
	 * Albums获取相册名查询，如果有相册数据，则不能插入相册，否则可以插入相册，创建成功
	 * @param albums
	 * @return
	 */
	public Albums albumsFirst();
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
}
