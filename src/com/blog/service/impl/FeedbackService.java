package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IFeedbackDao;
import com.blog.Iservice.IFeedbackService;
import com.blog.bean.Feedback;
import com.blog.dao.impl.FeedbackDao;

public class FeedbackService implements IFeedbackService {
	IFeedbackDao iFeedbackDao=new FeedbackDao();
	public boolean insertFeedback(Feedback feedback) {
		// TODO Auto-generated method stub
		return iFeedbackDao.insertFeedback(feedback);
	}

	public int getTotalCountByYiDu(int f_adminuser) {
		// TODO Auto-generated method stub
		return iFeedbackDao.getTotalCountByYiDu(f_adminuser);
	}

	public List<Feedback> feedbackYiDu(int f_adminuser, int currentPage,
			int pageSize) {
		return iFeedbackDao.feedbackYiDu(f_adminuser, currentPage, pageSize);
	}

	public int getTotalCountByWeiDu(int f_adminuser) {
		// TODO Auto-generated method stub
		return iFeedbackDao.getTotalCountByWeiDu(f_adminuser);
	}

	public List<Feedback> feedbackWeiDu(int f_adminuser, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return iFeedbackDao.feedbackWeiDu(f_adminuser, currentPage, pageSize);
	}

	public Feedback feedbackDao(int f_id) {
		// TODO Auto-generated method stub
		return iFeedbackDao.feedbackDao(f_id);
	}

	public boolean updateFeedback(int is_used_0, int f_id) {
		// TODO Auto-generated method stub
		return iFeedbackDao.updateFeedback(is_used_0, f_id);
	}

	public int getTotalCountf_user(int f_user) {
		// TODO Auto-generated method stub
		return iFeedbackDao.getTotalCountf_user(f_user);
	}

	public List<Feedback> feedbackf_user(int f_user, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return iFeedbackDao.feedbackf_user(f_user, currentPage, pageSize);
	}

}
