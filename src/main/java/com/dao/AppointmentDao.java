/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Appointment;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:04:11 AM
 */
public interface AppointmentDao {
	public void addAppointment(Appointment appointment);
	public void deleteAppointment(Integer appointmentId);
	public void updateAppointment(Appointment appointment);
	public Appointment viewAppointmentById(Integer appointmentId);
	public List<Appointment> viewAllAppointments();
}
