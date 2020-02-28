package com.blog.Iservice;

import java.util.List;

import com.blog.bean.User;
import com.blog.util.DBUtil;

public interface IUserService {
    /**
     * 根据u_name查询信息
     */
	public User UserByname(String u_name);
	 /**
     * 修改密码
     */
	public boolean Change_a_pass(User user,int u_id);
	 /**
     * 插入注册信息
     */
	public boolean isRegUser(User user);
    public  int getTotalCount() ;
	public List<User> Userlist(int currentPage, int pageSize);
	public boolean userByis_used(int id,int is_used);
	public boolean userByu_answer(User user);
	public boolean userxinxi(User user);
	public boolean useru_nickname(User user);
}
