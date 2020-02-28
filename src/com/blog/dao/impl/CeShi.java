package com.blog.dao.impl;

import java.util.List;

import org.json.JSONObject;

import com.blog.Idao.IAlbumsDao;
import com.blog.Idao.IDianZanDao;
import com.blog.Idao.IFeedbackanwerDao;
import com.blog.Iservice.IDianZanService;
import com.blog.bean.Albums;
import com.blog.bean.DianZan;
import com.blog.bean.Feedbackanwer;
import com.blog.service.impl.DianZanService;
import com.blog.util.DBUtil;

public class CeShi {
	
	
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
	public static void main(String[] args) {
//		DianZan dianzan =new DianZan();
//		dianzan.setDz_album(1);
//		dianzan.setDz_user(5);
		
		CeShi sCeShi=new CeShi();
		//sCeShi.updateDongTaiByid(1, true);
//		boolean isdianzan = sCeShi.isdianzan(dianzan);
//		System.out.println("³É¹¦");
//		System.out.println();
//		boolean isdianzan = sCeShi.isdianzan(dianzan);
//		System.out.println(isdianzan);
		
		
//     	IDianZanService iDianZanService=new DianZanService();
//     	boolean falg = iDianZanService.isdianzan(dianzan);
//		System.out.println(falg);
		
//		
//		if(falg){
//			System.out.println("³É"+falg);
//		}else{
//			System.out.println("System.out.pri"+falg);
//		}
//		IAlbumsDao albumsDao =new AlbumsDao();
//		Albums albumsFirst = albumsDao.albumsFirst();
//		
//		System.out.println(albumsFirst.getCreatetime());
////		
		IFeedbackanwerDao iFeedbackanwerDao=new FeedbackanwerDao();
		List<Feedbackanwer> list = iFeedbackanwerDao.feedbackanwerByfeedback(1, 1, 5);
		System.out.println(list.toString());
		System.out.println(list.get(2).getAdminuser().getA_name());
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getFa_id());
		}
	}

}
