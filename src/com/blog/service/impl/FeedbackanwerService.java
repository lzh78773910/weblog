package com.blog.service.impl;

import java.util.List;

import com.blog.Idao.IFeedbackanwerDao;
import com.blog.Iservice.IFeedbackanwerService;
import com.blog.bean.Feedbackanwer;
import com.blog.dao.impl.FeedbackanwerDao;

public class FeedbackanwerService implements IFeedbackanwerService{
	IFeedbackanwerDao iFeedbackanwerDao=new FeedbackanwerDao();
	public boolean insertfa_admin(Feedbackanwer feedbackanwer) {
		// TODO Auto-generated method stub
		return iFeedbackanwerDao.insertfa_admin(feedbackanwer);
	}

	public boolean insertfa_user(Feedbackanwer feedbackanwer) {
		// TODO Auto-generated method stub
		return iFeedbackanwerDao.insertfa_user(feedbackanwer);
	}

	public int getTotalCountByfa_feedback(int fa_feedback) {
		// TODO Auto-generated method stub
		return iFeedbackanwerDao.getTotalCountByfa_feedback(fa_feedback);
	}

	public List<Feedbackanwer> feedbackanwerByfeedback(int fa_feedback, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return iFeedbackanwerDao.feedbackanwerByfeedback(fa_feedback, currentPage, pageSize);
	}

	public List<Feedbackanwer> feedbackanwer(int fa_feedback) {
		// TODO Auto-generated method stub
		return iFeedbackanwerDao.feedbackanwer(fa_feedback);
	}

}
