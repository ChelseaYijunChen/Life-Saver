/**
 * 
 */
package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Doctor;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:43:31 PM
 */
@Repository("doctorDao")
@Transactional
public class DoctorDaoImpl implements DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addOrUpdateDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().saveOrUpdate(doctor);
		System.out.println("add or update doctor sucess");
	}

	// @Override
	public void deleteDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().delete(doctor);
		System.out.println("delete doctor sucess");
	}

	// @Override
	public void updateDoctor(Doctor doctor) {
		sessionFactory.getCurrentSession().update(doctor);
		System.out.println("add doctor sucess");

	}

	// @Override
	public Doctor viewDoctorById(Integer doctorId) {
		Doctor doctor = (Doctor) sessionFactory.getCurrentSession().load(Doctor.class, doctorId);
		return doctor;
	}

	// @Override
	public List<Doctor> viewDoctorByName(String name) {
		List<Doctor> doctor = sessionFactory.getCurrentSession()
				.createQuery("FROM Doctor WHERE doctorName = '" + name + "'").getResultList();
		return doctor;
	}

	// @Override
	public List<Doctor> viewDoctorByDepartment(Integer departmentId) {
		List<Doctor> doctor = sessionFactory.getCurrentSession()
				.createQuery("FROM Doctor WHERE department = '" + departmentId + "'").getResultList();
		return doctor;
	}

	// @Override
	public List<Doctor> viewAllDoctors() {
		return this.sessionFactory.getCurrentSession().createQuery("from Doctor").getResultList();
		// return (List<Doctor>)
		// sessionFactory.getCurrentSession().createCriteria(Doctor.class).list();
	}

	// @Override
	public boolean isValidUser(String email, String password) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Doctor where email = '" + email + "' and password = '" + password + "'");
		List<Doctor> u1 = query.getResultList();
		if (u1 == null || u1.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	// @Override
	public boolean isAdmin(String email) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Doctor WHERE email = :email")
				.setParameter("email", email);
		List<Doctor> doctor = query.getResultList();
		if (doctor == null || doctor.size() == 0) {
			return false;
		} else if (doctor.get(0).getIsAdmin().equals("Yes")) {
			return true;
		} else {
			return false;
		}
	}

	// @Override
	public Doctor viewDoctorByEmail(String email) {
		List<Doctor> doctor = sessionFactory.getCurrentSession().createQuery("FROM Doctor WHERE email = :email")
				.setParameter("email", email).getResultList();
		if (doctor != null) {
			return doctor.get(0);
		} else {
			return null;
		}
	}

}
