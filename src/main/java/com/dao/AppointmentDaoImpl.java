/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Appointment;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:05:16 AM
 */
@Repository("appointmentDao")
@Transactional
public class AppointmentDaoImpl implements AppointmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addAppointment(Appointment appointment) {
		sessionFactory.getCurrentSession().save(appointment);
		System.out.println("add product sucess");
	}

	// @Override
	public void deleteAppointment(Integer appointmentId) {
		Appointment appointment = (Appointment) sessionFactory.getCurrentSession().load(Appointment.class,
				appointmentId);
		if (null != appointment) {
			this.sessionFactory.getCurrentSession().delete(appointment);
		}
	}

	// @Override
	public void updateAppointment(Appointment appointment) {
		sessionFactory.getCurrentSession().update(appointment);
		System.out.println("add product sucess");

	}

	// @Override
	public Appointment viewAppointmentById(Integer appointmentId) {
		Appointment appointment = (Appointment) sessionFactory.getCurrentSession().load(Appointment.class,
				appointmentId);
		return appointment;
	}

	// @Override
	public List<Appointment> viewAllAppointments() {
		return this.sessionFactory.getCurrentSession().createQuery("from Appointment").getResultList();
	}
}
