package com.blog.Iservice;

import java.util.List;

import com.blog.bean.Adminuser;
import com.blog.bean.DongTai;

public interface IAdminuserService {
	/**
	 *�Ȳ�ѯ�˻��Ƿ���ڣ����򷵻�false 
	 */
	public boolean isLogin(String a_name);
	/**
	 *�Ȳ�ѯ�˻��Ƿ���ڣ�����Adminuser
	 */
	public Adminuser isAdminUserByname(String a_name);
	/**
	 *�Ȳ�ѯ�˻��Ƿ���ڣ������������������ݣ����򷵻�false 
	 */
	public boolean isRegAdminUser(Adminuser adminuser);
	/**
	 *�޸�����
	 */
	public boolean Change_a_pass(Adminuser adminuser,int a_id);
	  public List<Adminuser> adminuserlist();
		public  int getTotalCountadminuser();
	    public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize);
	
}
