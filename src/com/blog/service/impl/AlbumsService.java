package com.blog.service.impl;

import java.util.List;

import com.blog.dao.impl.AlbumsDao;
import com.blog.Idao.IAlbumsDao;
import com.blog.Iservice.IAlbumsService;
import com.blog.bean.Albums;

public class AlbumsService implements IAlbumsService {
	IAlbumsDao albumsDao =new AlbumsDao();
	public boolean updateAlbumsByid(int id, int is_used) {
		return albumsDao.updateAlbumsByid(id, is_used);
	}

	public boolean albumsAdd(Albums albums) {
		Albums album = albumsDao.albums(albums);
		if(album==null){
			return albumsDao.albumsAdd(albums);
		}
		return false;
	}

	public int getTotalCountfalse() {
		return albumsDao.getTotalCountfalse();
	}

	public Albums albums(Albums albums) {
		return albumsDao.albums(albums);
	}

	public List<Albums> albumsByPagefalse(int currentPage, int pageSize) {
		return albumsDao.albumsByPagefalse(currentPage, pageSize);
	}

	public int getTotalCount() {
		return albumsDao.getTotalCount();
	}

	public List<Albums> albumsByPage(int currentPage, int pageSize) {
		return albumsDao.albumsByPage(currentPage, pageSize);
	}

	public boolean updateAlbumsByal_name(Albums albums) {
		return albumsDao.updateAlbumsByal_name(albums);
	}

	public Albums Albums(int al_id) {
		return albumsDao.Albums(al_id);
	}

	public int getTotalCountBydianzan(int al_id) {
		return albumsDao.getTotalCountBydianzan(al_id);
	}

	public List<Albums> albumsYiWang(int u_id, int currentPage,
			int pageSize) {
		return albumsDao.albumsYiWang(u_id, currentPage, pageSize);
	}

	public int getTotalCountBydz_user(int dz_user) {
		return albumsDao.getTotalCountBydz_user(dz_user);
	}

	public Albums albumsFirst() {
		return albumsDao.albumsFirst();
	}
}
