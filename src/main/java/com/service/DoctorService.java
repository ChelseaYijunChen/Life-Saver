/**
 * 
 */
package com.service;

import java.util.List;

import com.pojo.Doctor;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 9:31:57 PM
 */
public interface DoctorService {
	public void addOrUpdateDoctor(Doctor doctor);
	public void deleteDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public boolean isValidUser(String email, String password);
	public boolean isAdmin(String email);
	public Doctor viewDoctorById(Integer doctorId);
	public List<Doctor> viewDoctorByName(String name);
	public List<Doctor> viewDoctorByDepartment(Integer departmentId);
	public List<Doctor> viewAllDoctors();
	public Doctor viewDoctorByEmail(String email);
}
