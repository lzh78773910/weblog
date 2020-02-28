package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IPhotosDao;
import com.blog.Iservice.IPhotoService;
import com.blog.bean.Photos;
import com.blog.dao.impl.PhotosDao;

public class PhotoService implements IPhotoService {
    
	IPhotosDao photosDao =new PhotosDao();
	
	public boolean Photosadd(Photos photos) {
		return photosDao.Photosadd(photos);
	}

	public boolean PhotosByis_used(int p_id,int is_used) {
		return photosDao.PhotosByis_used(p_id,is_used);
	}

	public int getTotalCountByp_albums(int p_albums) {
		return photosDao.getTotalCountByp_albums(p_albums);
	}

	public List<Photos> photosByp_albums(int p_albums, int currentPage,
			int pageSize) {
		return photosDao.photosByp_albums(p_albums, currentPage, pageSize);
	}

	public int getTotalCounttrue() {
		return photosDao.getTotalCounttrue();
	}

	public List<Photos> photosByp_albumstrue(int currentPage, int pageSize) {
		return photosDao.photosByp_albumstrue(currentPage, pageSize);
	}

	public int getTotalCountfalse() {
		return photosDao.getTotalCountfalse();
	}

	public List<Photos> photosByp_albumsfalse(int currentPage, int pageSize) {
		return photosDao.photosByp_albumsfalse(currentPage, pageSize);
	}

}
