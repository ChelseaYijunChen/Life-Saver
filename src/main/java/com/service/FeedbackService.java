/**
 * 
 */
package com.service;

import java.util.List;

import com.pojo.Feedback;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:47:03 AM
 */
public interface FeedbackService {
	public void addFeedback(Feedback feedback);
	public void deleteFeedback(Integer feedbackId);
	public void updateFeedback(Feedback feedback);
	public Feedback viewFeedbackById(Integer feedbackId);
	public List<Feedback> viewAllFeedbacks();
}
