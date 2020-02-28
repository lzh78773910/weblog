package com.blog.Iservice;

import java.util.List;

import com.blog.bean.PingLun;

public interface IPingLunService {
	/**
	 *按动态id查询评论数量 
	 */
	public int PingLunCount(int d_id);
	/**
	 *按动态id查询评论 
	 */
	public List<PingLun> PingLunByd_id(int currentPage,int pageSize,int id);
	public boolean addpinglun(PingLun pinglun);
	public List<PingLun> PingLunBypl_author(int currentPage,int pageSize,int pl_author);
	public boolean pinglunis_used(int pl_id,int is_used);
	public int PingLunCountpl_author(int pl_author) ;
}
