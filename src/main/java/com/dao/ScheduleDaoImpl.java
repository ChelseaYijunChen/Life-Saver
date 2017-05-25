/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Schedule;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:59:16 AM
 */
@Repository("scheduleDao")
@Transactional
public class ScheduleDaoImpl implements ScheduleDao {
	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addSchedule(Schedule schedule) {
		sessionFactory.getCurrentSession().save(schedule);
		System.out.println("add schedule sucess");
	}

	// @Override
	public void deleteSchedule(Integer scheduleId) {
		Schedule schedule = (Schedule) sessionFactory.getCurrentSession().load(Schedule.class, scheduleId);
		if (null != schedule) {
			this.sessionFactory.getCurrentSession().delete(schedule);
		}
	}

	// @Override
	public void updateSchedule(Schedule schedule) {
		sessionFactory.getCurrentSession().update(schedule);
		System.out.println("update schedule sucess");

	}

	// @Override
	public Schedule viewScheduleById(Integer scheduleId) {
		Schedule schedule = (Schedule) sessionFactory.getCurrentSession().load(Schedule.class, scheduleId);
		return schedule;
	}

	// @Override
	public List<Schedule> viewAllSchedules() {
		return this.sessionFactory.getCurrentSession().createQuery("from Schedule").getResultList();
	}

	// @Override
	public List<Schedule> viewScheduleByDoctorId(Integer doctorId) {
		List<Schedule> scheduleList = sessionFactory.getCurrentSession()
				.createQuery("FROM Schedule WHERE doctor = '" + doctorId + "'").getResultList();
		return scheduleList;
	}
}
