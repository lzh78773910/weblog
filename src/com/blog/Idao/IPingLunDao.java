package com.blog.Idao;

import java.util.List;

import com.blog.bean.PingLun;
import com.blog.util.DBUtil;

public interface IPingLunDao {
	/**
	 *按动态id查询评论数量 
	 */
	public int PingLunCount(int d_id);
	/**
	 *按动态id查询评论 
	 */
	public List<PingLun> PingLunByd_id(int currentPage,int pageSize,int id);
	
	public boolean pinglun(PingLun pinglun);
	
	public boolean pinglunis_used(int pl_id,int is_used);
	public int PingLunCountpl_author(int pl_author) ;
	public List<PingLun> PingLunBypl_author(int currentPage,int pageSize,int pl_author);
}
