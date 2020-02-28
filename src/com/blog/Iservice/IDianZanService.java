package com.blog.Iservice;

import com.blog.bean.DianZan;

public interface IDianZanService {
	public  int getTotalCount();
	public boolean insertDianZan(DianZan dianzan);
	public boolean is_usedDianZan(DianZan dianzan);
	public DianZan dianzan(int u_id,int dz_album);
	public boolean isdianzan(DianZan dianzan);
}
