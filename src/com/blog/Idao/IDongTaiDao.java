package com.blog.Idao;

import java.util.List;

import com.blog.bean.DongTai;
import com.blog.util.DBUtil;

public interface IDongTaiDao {
	/**
	 * 查询动态数量is_used=false
	 */
	public  int getTotalCountfalse();
	/**
	 * 查询动态is_used=false
	 */
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize);
	/**
	 * 查询动态数量is_used=true
	 */
	public  int getTotalCount();
	/**
	 * 查询动态is_used=true
	 */
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize);
	/**
	 * 根据id把数据库修改is_used字段
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
	public boolean dongtai(int d_id);
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize);
	public int getTotalCountShouSuo(String shousuo);
	public List<DongTai> dongtaiShouSuo(String shousuo,int currentPage, int pageSize);
}
