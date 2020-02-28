package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IUserDao;
import com.blog.Iservice.IUserService;
import com.blog.bean.User;
import com.blog.dao.impl.UserDao;

public class UserService implements IUserService {
	IUserDao iUserDao =new UserDao();
	
	public User UserByname(String u_name) {
		return iUserDao.UserByname(u_name);
	}
	public boolean Change_a_pass(User user, int u_id) {
		return iUserDao.Change_a_pass(user, u_id);
	}
	public boolean isRegUser(User user) {
		User userByname = iUserDao.UserByname(user.getU_name());
		if(userByname==null){
		return iUserDao.RegUser(user);
		}else{
		return false;	
		}
	}
	public int getTotalCount() {
		return iUserDao.getTotalCount();
	}
	public List<User> Userlist(int currentPage, int pageSize) {
		return iUserDao.Userlist(currentPage,pageSize);
	}
	public boolean userByis_used(int id, int is_used) {
		return iUserDao.userByis_used(id, is_used);
	}
	public boolean userByu_answer(User user) {
		return iUserDao.userByu_answer(user);
	}
	public boolean userxinxi(User user) {
		return	iUserDao.userxinxi(user);
	}
	public boolean useru_nickname(User user) {
		// TODO Auto-generated method stub
		return iUserDao.useru_nickname(user);
	}

}
