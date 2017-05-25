/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ScheduleDao;
import com.pojo.Schedule;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:02:16 AM
 */
@Service("scheduleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleDao scheduleDao;

	//@Override
	public void addSchedule(Schedule schedule) {
		scheduleDao.addSchedule( schedule);	
	}

	//@Override
	public void deleteSchedule(Integer scheduleId) {
		scheduleDao.deleteSchedule(scheduleId);
	}

	//@Override
	public void updateSchedule(Schedule schedule) {
		scheduleDao.updateSchedule(schedule);
	}

	//@Override
	public Schedule viewScheduleById(Integer scheduleId) {	
		return scheduleDao.viewScheduleById(scheduleId);
	}

	//@Override
	public List<Schedule> viewAllSchedules() {
		return scheduleDao.viewAllSchedules();
	}

	//@Override
	public List<Schedule> viewScheduleByDoctorId(Integer doctorId) {
		return scheduleDao.viewScheduleByDoctorId(doctorId);
	}
}
