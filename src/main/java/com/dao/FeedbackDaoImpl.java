/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Feedback;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:43:04 AM
 */
@Repository("feedbackDao")
@Transactional
public class FeedbackDaoImpl implements FeedbackDao {
	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().save(feedback);
		System.out.println("add feedback sucess");
	}

	// @Override
	public void deleteFeedback(Integer feedbackId) {
		Feedback feedback = (Feedback) sessionFactory.getCurrentSession().load(Feedback.class, feedbackId);
		if (null != feedback) {
			this.sessionFactory.getCurrentSession().delete(feedback);
		}
	}

	// @Override
	public void updateFeedback(Feedback feedback) {
		sessionFactory.getCurrentSession().update(feedback);
		System.out.println("update feedback sucess");

	}

	// @Override
	public Feedback viewFeedbackById(Integer feedbackId) {
		Feedback feedback = (Feedback) sessionFactory.getCurrentSession().load(Feedback.class, feedbackId);
		return feedback;
	}

	// @Override
	public List<Feedback> viewAllFeedbacks() {
		// return this.sessionFactory.getCurrentSession().createQuery("from
		// EmployeeEntity").list();
		return (List<Feedback>) sessionFactory.getCurrentSession().createCriteria(Feedback.class).list();
	}
}
