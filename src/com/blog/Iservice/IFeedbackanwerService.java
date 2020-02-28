package com.blog.Iservice;

import java.util.List;

import com.blog.bean.Feedbackanwer;

public interface IFeedbackanwerService {
	public boolean insertfa_admin(Feedbackanwer feedbackanwer) ;

	public boolean insertfa_user(Feedbackanwer feedbackanwer);
	public List<Feedbackanwer> feedbackanwer(int fa_feedback) ;
	public int getTotalCountByfa_feedback(int fa_feedback);
	public List<Feedbackanwer> feedbackanwerByfeedback(int fa_feedback, int currentPage,
			int pageSize) ;
}
