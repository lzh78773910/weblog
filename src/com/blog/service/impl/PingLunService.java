package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IPingLunDao;
import com.blog.Iservice.IPingLunService;
import com.blog.bean.PingLun;
import com.blog.dao.impl.PingLunDao;

public class PingLunService implements IPingLunService {
	IPingLunDao pinglunDao=new PingLunDao();
	
	public int PingLunCount(int d_id) {
		return pinglunDao.PingLunCount(d_id);
	}

	public List<PingLun> PingLunByd_id(int currentPage, int pageSize, int id) {
		return pinglunDao.PingLunByd_id(currentPage, pageSize, id);
	}

	public boolean addpinglun(PingLun pinglun) {
		// TODO Auto-generated method stub
		return pinglunDao.pinglun(pinglun);
	}

	public boolean pinglunis_used(int pl_id, int is_used) {
		// TODO Auto-generated method stub
		return pinglunDao.pinglunis_used(pl_id, is_used);
	}

	public List<PingLun> PingLunBypl_author(int currentPage, int pageSize,
			int pl_author) {
		// TODO Auto-generated method stub
		return pinglunDao.PingLunBypl_author(currentPage, pageSize, pl_author);
	}

	public int PingLunCountpl_author(int pl_author) {
		// TODO Auto-generated method stub
		return pinglunDao.PingLunCountpl_author(pl_author);
	}

}
