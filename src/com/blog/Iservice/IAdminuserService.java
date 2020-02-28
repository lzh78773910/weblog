package com.blog.Iservice;

import java.util.List;

import com.blog.bean.Adminuser;
import com.blog.bean.DongTai;

public interface IAdminuserService {
	/**
	 *先查询账户是否存在，否则返回false 
	 */
	public boolean isLogin(String a_name);
	/**
	 *先查询账户是否存在，返回Adminuser
	 */
	public Adminuser isAdminUserByname(String a_name);
	/**
	 *先查询账户是否存在，如果不存在则插入数据，否则返回false 
	 */
	public boolean isRegAdminUser(Adminuser adminuser);
	/**
	 *修改密码
	 */
	public boolean Change_a_pass(Adminuser adminuser,int a_id);
	  public List<Adminuser> adminuserlist();
		public  int getTotalCountadminuser();
	    public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize);
	
}
