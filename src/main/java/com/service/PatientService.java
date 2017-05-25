/**
 * 
 */
package com.service;

import java.util.List;

import com.model.DoctorWeekSchedule;
import com.pojo.Patient;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 11:03:07 PM
 */
public interface PatientService {
	public void addOrUpdatePatient(Patient patient);
	public void deletePatient(Patient patient);
	public void updatePatient(Patient patient);
	public boolean isValidPatient(String email, String password);
	public Patient viewPatientById(Integer patientId);
	public Patient viewPatientByEmail(String email);
	public List<Patient> viewPatientByName(String name);
	public List<Patient> viewAllPatients();
	
	public DoctorWeekSchedule listDoctorSchedule(Integer doctorId, Integer page);
	
}
