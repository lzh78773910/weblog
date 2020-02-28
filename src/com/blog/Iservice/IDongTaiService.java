package com.blog.Iservice;

import java.util.List;

import com.blog.bean.DongTai;

public interface IDongTaiService {
	/**
	 * 获取is_used为true的动态数量
	 */
	public  int getTotalCount();
	/**
	 * 查询is_used为true的动态数量
	 */
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize);
	/**
	 * 获取is_used为false的动态数量
	 */
	public  int getTotalCountfalse();
	/**
	 * 查询is_used为false的动态数量
	 */
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize);
	/**
	 * 根据id把数据库删除动态(修改is_used)
	 */
	public boolean updateDongTaiByid(int id,int is_used);
	/**
	 * 插入动态记录
	 */
	public boolean dongtaiAdd(int d_author,DongTai dongtai);
	/**
	 * 根据 d_id查询动态详情
	 */
	public DongTai dongtaiDetails(int d_id);
	/**
	 * 根据 d_id修改动态
	 */
	public boolean dongtaiXiuGai(DongTai dongtai);
	/**
	 * 根据 d_author访问量排行
	 */
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize);
	public boolean dongtai(int d_id);
	public int getTotalCountShouSuo(String shousuo) ;
	public List<DongTai> dongtaiShouSuo(String shousuo,int currentPage, int pageSize);
}
