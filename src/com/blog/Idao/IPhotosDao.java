package com.blog.Idao;

import java.util.List;

import com.blog.bean.Photos;

public interface IPhotosDao {
	public boolean Photosadd(Photos photos);
	public boolean PhotosByis_used(int p_id,int is_used);
	public int getTotalCountByp_albums(int p_albums) ;//查询总数据量
	public List<Photos> photosByp_albums(int p_albums,int currentPage, int pageSize) ;
	public int getTotalCounttrue() ;
	public List<Photos> photosByp_albumstrue(int currentPage, int pageSize) ;
	public int getTotalCountfalse() ;
	public List<Photos> photosByp_albumsfalse(int currentPage, int pageSize) ;
}
