package com.blog.Idao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Adminuser;
import com.blog.util.DBUtil;
public interface IAdminuserDao {
	/**
	 * �жϸù���Ա�Ƿ����
	 * @param a_name
	 * @param a_pass
	 * @return boolean
	 */
	public boolean Login(String a_name);
	
	/**
	 * ��ȡ�ù���Ա��Ϣ
	 * @param a_name
	 * @param a_pass
	 * @return Adminuser
	 */
    public Adminuser adminUserByname(String a_name);
    /**
     * ����������ӹ���Ա
     */
	public boolean RegAdminUser(Adminuser adminuser);
	/**
     * �жϸù���Ա�˻��Ƿ����
     */
	public boolean isAdminuserByname(Adminuser adminuser);
	/**
     * �����˻���ѯ����Ա��Ϣ
     */
    public Adminuser AdminUserReg(Adminuser adminuser);
    /**
     * �޸������ֶ�
   	 * @param adminuser
	 * @param a_id
     */
    public boolean Change_a_pass(Adminuser adminuser,int a_id);
    
    public List<Adminuser> adminuserlist();
	public  int getTotalCountadminuser();
    public List<Adminuser> adminuserlistBypage(int currentPage, int pageSize);
    
}
