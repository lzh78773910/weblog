package com.blog.Idao;

import java.util.List;

import com.blog.bean.DongTai;
import com.blog.util.DBUtil;

public interface IDongTaiDao {
	/**
	 * ��ѯ��̬����is_used=false
	 */
	public  int getTotalCountfalse();
	/**
	 * ��ѯ��̬is_used=false
	 */
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize);
	/**
	 * ��ѯ��̬����is_used=true
	 */
	public  int getTotalCount();
	/**
	 * ��ѯ��̬is_used=true
	 */
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize);
	/**
	 * ����id�����ݿ��޸�is_used�ֶ�
	 */
	public boolean updateDongTaiByid(int id,int is_used);
	/**
	 * ���붯̬��¼
	 */
	public boolean dongtaiAdd(int d_author,DongTai dongtai);
	/**
	 * ���� d_id��ѯ��̬����
	 */
	public DongTai dongtaiDetails(int d_id);
	/**
	 * ���� d_id�޸Ķ�̬
	 */
	public boolean dongtaiXiuGai(DongTai dongtai);
	/**
	 * ���� d_author����������
	 */
	public boolean dongtai(int d_id);
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize);
	public int getTotalCountShouSuo(String shousuo);
	public List<DongTai> dongtaiShouSuo(String shousuo,int currentPage, int pageSize);
}
