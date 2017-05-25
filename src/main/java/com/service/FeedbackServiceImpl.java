/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FeedbackDao;
import com.pojo.Feedback;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:47:53 AM
 */
@Service("feedbackService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackDao feedbackDao;

	//@Override
	public void addFeedback(Feedback feedback) {
		feedbackDao.addFeedback( feedback);	
	}

	//@Override
	public void deleteFeedback(Integer feedbackId) {
		feedbackDao.deleteFeedback(feedbackId);
	}

	//@Override
	public void updateFeedback(Feedback feedback) {
		feedbackDao.updateFeedback(feedback);
	}

	//@Override
	public Feedback viewFeedbackById(Integer feedbackId) {	
		return feedbackDao.viewFeedbackById(feedbackId);
	}


	//@Override
	public List<Feedback> viewAllFeedbacks() {
		return feedbackDao.viewAllFeedbacks();
	}
}
