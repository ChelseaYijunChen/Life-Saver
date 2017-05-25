/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.Doctor;
import com.pojo.Patient;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:44:07 PM
 */
@Repository("PatientDao")
@Transactional
public class PatientDaoImpl implements PatientDao {
	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addOrUpdatePatient(Patient patient) {
		sessionFactory.getCurrentSession().save(patient);
		System.out.println("add Or Update Patient sucess");
	}

	// @Override
	public void deletePatient(Patient patient) {
		sessionFactory.getCurrentSession().delete(patient);
	}

	// @Override
	public void updatePatient(Patient patient) {
		sessionFactory.getCurrentSession().update(patient);
		System.out.println("add product sucess");

	}

	// @Override
	public Patient viewPatientById(Integer patientId) {
		Patient patient = (Patient) sessionFactory.getCurrentSession().load(Patient.class, patientId);
		return patient;
	}

	// @Override
	public List<Patient> viewPatientByName(String name) {
		List<Patient> patient = sessionFactory.getCurrentSession().createQuery("FROM Patient WHERE patientName = :name")
				.setParameter("name", name).getResultList();
		return patient;
	}

	// @Override
	public List<Patient> viewAllPatients() {
		return this.sessionFactory.getCurrentSession().createQuery("from Patient").getResultList();
	}

	// @Override
	public boolean isValidPatient(String email, String password) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("From Patient where email = '" + email + "' and password = '" + password + "'");
		List<Doctor> u1 = query.getResultList();
		if (u1 == null || u1.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	// @Override
	public Patient viewPatientByEmail(String email) {
		List<Patient> patient = sessionFactory.getCurrentSession().createQuery("FROM Patient WHERE email = :email")
				.setParameter("email", email).getResultList();
		if (patient != null) {
			return patient.get(0);
		} else {
			return null;
		}

	}

}
