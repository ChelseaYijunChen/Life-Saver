/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DoctorDao;
import com.pojo.Doctor;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 10:29:24 PM
 */
@Service("doctorService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorDao doctorDao;

	// @Override
	public void addOrUpdateDoctor(Doctor doctor) {
		doctorDao.addOrUpdateDoctor(doctor);
	}

	// @Override
	public void deleteDoctor(Doctor doctor) {
		doctorDao.deleteDoctor(doctor);
	}

	// @Override
	public void updateDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
	}

	// @Override
	public Doctor viewDoctorById(Integer doctorId) {
		return doctorDao.viewDoctorById(doctorId);
	}

	// @Override
	public List<Doctor> viewDoctorByDepartment(Integer departmentId) {
		return doctorDao.viewDoctorByDepartment(departmentId);
	}

	// @Override
	public List<Doctor> viewDoctorByName(String name) {
		return doctorDao.viewDoctorByName(name);
	}

	// @Override
	public List<Doctor> viewAllDoctors() {
		return doctorDao.viewAllDoctors();
	}

	// @Override
	public boolean isAdmin(String email) {
		return doctorDao.isAdmin(email);
	}

	// @Override
	public boolean isValidUser(String email, String password) {
		return doctorDao.isValidUser(email, password);
	}

	// @Override
	public Doctor viewDoctorByEmail(String email) {
		return doctorDao.viewDoctorByEmail(email);
	}

}
