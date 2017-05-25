/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Schedule;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:58:01 AM
 */
public interface ScheduleDao {
	public void addSchedule(Schedule schedule);
	public void deleteSchedule(Integer scheduleId);
	public void updateSchedule(Schedule schedule);
	public Schedule viewScheduleById(Integer scheduleId);
	public List<Schedule> viewAllSchedules();
	public List<Schedule> viewScheduleByDoctorId(Integer doctorId);
}
