package com.blog.Idao;

import java.sql.SQLException;
import java.util.List;

import com.blog.bean.Feedbackanwer;
import com.blog.util.DBUtil;

public interface IFeedbackanwerDao {
	public boolean insertfa_admin(Feedbackanwer feedbackanwer) ;

	public boolean insertfa_user(Feedbackanwer feedbackanwer);
	public List<Feedbackanwer> feedbackanwer(int fa_feedback) ;
	public int getTotalCountByfa_feedback(int fa_feedback);
	public List<Feedbackanwer> feedbackanwerByfeedback(int fa_feedback, int currentPage,
			int pageSize) ;
}
