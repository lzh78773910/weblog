package com.blog.service.impl;

import com.blog.Idao.IDianZanDao;
import com.blog.Iservice.IDianZanService;
import com.blog.bean.DianZan;
import com.blog.dao.impl.DianZanDao;

public class DianZanService implements IDianZanService{
        IDianZanDao iDianZanDao= new DianZanDao();  
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return iDianZanDao.getTotalCount();
	}

	public boolean insertDianZan(DianZan dianzan) {
		return iDianZanDao.insertDianZan(dianzan);
	}

	public boolean is_usedDianZan(DianZan dianzan) {
		// TODO Auto-generated method stub
		return iDianZanDao.is_usedDianZan(dianzan);
	}

	public DianZan dianzan(int u_id,int dz_album) {
		// TODO Auto-generated method stub
		return iDianZanDao.dianzan(u_id,dz_album);
	}
	public boolean isdianzan(DianZan dianzan){
		 IDianZanDao iDianZanDao= new DianZanDao();  
		 DianZan dianzan2 = iDianZanDao.dianzan(dianzan.getDz_user(), dianzan.getDz_album());
		if(dianzan2==null){
			return iDianZanDao.insertDianZan(dianzan);
		}else{
			boolean is_used = dianzan2.isIs_used();
			if(is_used){
				dianzan2.setIs_used(false);
			}else{
				dianzan2.setIs_used(true);
			}
			return iDianZanDao.is_usedDianZan(dianzan2);
		}
	}
}
