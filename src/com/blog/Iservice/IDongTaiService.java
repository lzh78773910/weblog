package com.blog.Iservice;

import java.util.List;

import com.blog.bean.DongTai;

public interface IDongTaiService {
	/**
	 * ��ȡis_usedΪtrue�Ķ�̬����
	 */
	public  int getTotalCount();
	/**
	 * ��ѯis_usedΪtrue�Ķ�̬����
	 */
	public List<DongTai> dongtaiByPage(int currentPage, int pageSize);
	/**
	 * ��ȡis_usedΪfalse�Ķ�̬����
	 */
	public  int getTotalCountfalse();
	/**
	 * ��ѯis_usedΪfalse�Ķ�̬����
	 */
	public List<DongTai> dongtaiByPagefalse(int currentPage, int pageSize);
	/**
	 * ����id�����ݿ�ɾ����̬(�޸�is_used)
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
	public List<DongTai> dongtaiByd_liulang(int currentPage, int pageSize);
	public boolean dongtai(int d_id);
	public int getTotalCountShouSuo(String shousuo) ;
	public List<DongTai> dongtaiShouSuo(String shousuo,int currentPage, int pageSize);
}
