package com.blog.Idao;

import com.blog.bean.DianZan;
import com.blog.util.DBUtil;

public interface IDianZanDao {
	public  int getTotalCount();
	public boolean insertDianZan(DianZan dianzan);
	public boolean is_usedDianZan(DianZan dianzan);
	public DianZan dianzan(int u_id,int dz_album);
}
