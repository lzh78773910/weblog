package com.blog.Iservice;

import java.util.List;

import com.blog.bean.Albums;

public interface IAlbumsService {
	public boolean updateAlbumsByid(int id,int is_used);
	/**
	 * Albums��ȡ�������ѯ�������������ݣ����ܲ�����ᣬ������Բ�����ᣬ�����ɹ�
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
