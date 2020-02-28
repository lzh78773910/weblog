package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IAdminuserDao;
import com.blog.Iservice.IAdminuserService;
import com.blog.bean.Adminuser;
import com.blog.bean.DongTai;
import com.blog.dao.impl.AdminuserDao;

public class AdminuserService implements IAdminuserService {

	IAdminuserDao admin= new AdminuserDao();
	public boolean Change_a_pass(Adminuser adminuser,int a_id){
		 return admin.Change_a_pass(adminuser, a_id);
	}
	public boolean isLogin(String a_name){
		 return admin.Login(a_name);
	}
	public Adminuser isAdminUserByname(String a_name){
		return admin.adminUserByname(a_name);
	}
	public boolean isRegAdminUser(Adminuser adminuser){
	boolean falg = admin.isAdminuserByname(adminuser);
	if(!falg){
		admin.RegAdminUser(adminuser);
		return true;
	}else{
		return false;
	}
	}
	public List<Adminuser> adminuserlist() {
		// TODO Auto-generated method stub
		return admin.adminuserlist();
	}
	public int getTotalCountadminuser() {
		// TODO Auto-generated method stub
		return admin.getTotalCountadminuser();
	}
	public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return admin.adminuserlistBypage(currentPage, pageSize);
	}
}
