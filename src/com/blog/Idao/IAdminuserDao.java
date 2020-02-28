package com.blog.Idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Adminuser;
import com.blog.util.DBUtil;
public interface IAdminuserDao {
	/**
	 * 判断该管理员是否存在
	 * @param a_name
	 * @param a_pass
	 * @return boolean
	 */
	public boolean Login(String a_name);
	
	/**
	 * 获取该管理员信息
	 * @param a_name
	 * @param a_pass
	 * @return Adminuser
	 */
    public Adminuser adminUserByname(String a_name);
    /**
     * 插入数据添加管理员
     */
	public boolean RegAdminUser(Adminuser adminuser);
	/**
     * 判断该管理员账户是否存在
     */
	public boolean isAdminuserByname(Adminuser adminuser);
	/**
     * 根据账户查询管理员信息
     */
    public Adminuser AdminUserReg(Adminuser adminuser);
    /**
     * 修改密码字段
   	 * @param adminuser
	 * @param a_id
     */
    public boolean Change_a_pass(Adminuser adminuser,int a_id);
    
    public List<Adminuser> adminuserlist();
	public  int getTotalCountadminuser();
    public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize);
    
}
