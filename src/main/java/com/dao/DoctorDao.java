/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Doctor;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:43:05 PM
 */
public interface DoctorDao {
	public void addOrUpdateDoctor(Doctor doctor);
	public void deleteDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public boolean isValidUser(String email, String password);
	public boolean isAdmin(String email);
	public Doctor viewDoctorById(Integer doctorId);
	public Doctor viewDoctorByEmail(String email);
	public List<Doctor> viewDoctorByName(String name);
	public List<Doctor> viewDoctorByDepartment(Integer depaermentId);
	public List<Doctor> viewAllDoctors();
}
