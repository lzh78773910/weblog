package com.blog.Idao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Feedback;
import com.blog.util.DBUtil;

public interface IFeedbackDao {
	public Feedback feedbackDao(int f_id);
	public boolean insertFeedback(Feedback feedback );
	//已读有效反馈
	public int getTotalCountByYiDu(int f_adminuser) ;
	public List<Feedback> feedbackYiDu(int f_adminuser,int currentPage, int pageSize);
	//未读
	public int getTotalCountByWeiDu(int f_adminuser) ;
	public boolean updateFeedback(int is_used_0,int  f_id);
	public List<Feedback> feedbackWeiDu(int f_adminuser,int currentPage, int pageSize);
	public int getTotalCountf_user(int f_user) ;
	public List<Feedback> feedbackf_user(int f_user,int currentPage, int pageSize);
}
