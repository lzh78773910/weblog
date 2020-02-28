package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IDongTaiDao;
import com.blog.Iservice.IDongTaiService;
import com.blog.bean.DongTai;
import com.blog.dao.impl.DongTaiDao;

public class DongTaiService implements IDongTaiService {
    IDongTaiDao dongtaidao=new DongTaiDao();
    public boolean dongtaiAdd(int d_author, DongTai dongtai) {
		return dongtaidao.dongtaiAdd(d_author, dongtai);
	}
	public  int getTotalCount(){
		return dongtaidao.getTotalCount();
	}
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize){
		return dongtaidao.dongtaiByPage(currentPage, pageSize);
	}
	public  int getTotalCountfalse(){
		return dongtaidao.getTotalCountfalse();
	}
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize){
		return dongtaidao.dongtaiByPagefalse(currentPage, pageSize);
	}
	public boolean updateDongTaiByid(int id,int is_used) {
		return dongtaidao.updateDongTaiByid(id,is_used);
	}
	public DongTai dongtaiDetails(int d_id) {
		return dongtaidao.dongtaiDetails(d_id);
	}
	public boolean dongtaiXiuGai(DongTai dongtai) {
		return dongtaidao.dongtaiXiuGai(dongtai);
	}
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize) {
		return dongtaidao.dongtaiByd_liulang(currentPage, pageSize);
	}
	public List<DongTai> dongtaiShouSuo(String shousuo, int currentPage,
			int pageSize) {
		return dongtaidao.dongtaiShouSuo(shousuo, currentPage, pageSize);
	}
	public int getTotalCountShouSuo(String shousuo) {
		return dongtaidao.getTotalCountShouSuo(shousuo);
	}
	public boolean dongtai(int d_id) {
		// TODO Auto-generated method stub
		return dongtaidao.dongtai(d_id);
	}
	
}
