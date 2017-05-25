/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AppointmentDao;
import com.pojo.Appointment;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:08:00 AM
 */
@Service("appointmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AppointmentServiceImpl implements AppointmentService{
	@Autowired
	private AppointmentDao appointmentDao;

	//@Override
	public void addAppointment(Appointment appointment) {
		appointmentDao.addAppointment( appointment);	
	}

	//@Override
	public void deleteAppointment(Integer appointmentId) {
		appointmentDao.deleteAppointment(appointmentId);
	}

	//@Override
	public void updateAppointment(Appointment appointment) {
		appointmentDao.updateAppointment(appointment);
	}

	//@Override
	public Appointment viewAppointmentById(Integer appointmentId) {	
		return appointmentDao.viewAppointmentById(appointmentId);
	}

	//@Override
	public List<Appointment> viewAllAppointments() {
		return appointmentDao.viewAllAppointments();
	}
}
