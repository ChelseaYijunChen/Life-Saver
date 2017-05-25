/**
 * 
 */
package com.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PatientDao;
import com.model.DoctorWeekSchedule;
import com.pojo.Absent;
import com.pojo.Doctor;
import com.pojo.Patient;
import com.pojo.Schedule;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 11:03:22 PM
 */
@Service("patientService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientDao patientDao;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private AbsentService absentService;

	// @Override
	public void addOrUpdatePatient(Patient patient) {
		patientDao.addOrUpdatePatient(patient);
	}

	// @Override
	public void deletePatient(Patient patient) {
		patientDao.deletePatient(patient);
	}

	// @Override
	public void updatePatient(Patient patient) {
		patientDao.updatePatient(patient);
	}

	// @Override
	public Patient viewPatientById(Integer patientId) {
		return patientDao.viewPatientById(patientId);
	}

	// @Override
	public List<Patient> viewPatientByName(String name) {
		return patientDao.viewPatientByName(name);
	}

	// @Override
	public List<Patient> viewAllPatients() {
		return patientDao.viewAllPatients();
	}

	// @Override
	public boolean isValidPatient(String email, String password) {
		return patientDao.isValidPatient(email, password);
	}

	// @Override
	public Patient viewPatientByEmail(String email) {
		return patientDao.viewPatientByEmail(email);
	}

	// @Override
	public DoctorWeekSchedule listDoctorSchedule(Integer doctorId, Integer page) {
		Doctor doctor = doctorService.viewDoctorById(doctorId);
		List<Schedule> sList = scheduleService.viewScheduleByDoctorId(doctorId);
		DoctorWeekSchedule doctorWeekSchedule = new DoctorWeekSchedule();
		doctorWeekSchedule.setDoctorId(doctorId);
		doctorWeekSchedule.setPage(page);

		List<Absent> absent = absentService.viewAbsentByDoctorId(doctor.getDoctorId());
		LocalDate leaving = null;
		LocalDate return2 = null;
		if (absent != null) {
			Date leavingDate = absent.get(0).getLeavingDate();
			Date returnDate = absent.get(0).getReturnDate();
			leaving = leavingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			return2 = returnDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}

		Date date = new Date();
		int weekDay = date.getDay();

		String[] s1 = new String[7];
		for (int i = 0; i < sList.size(); i++) {
			// if(absent != null){
			// Date everyDay = new Date();
			//
			// if(page == 0){
			// everyDay.setDate(everyDay.getDate() -weekDay + i);
			// } else {
			// everyDay.setDate(everyDay.getDate()- weekDay + page*7 +i);
			// }
			// System.out.println(everyDay);
			// LocalDate everyDay2 =
			// everyDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			// if((leaving.compareTo(everyDay2))*(return2.compareTo(everyDay2))<=0){
			// continue;
			// }
			// }

			if (sList.get(i).getWorkDay().equals("Sunday")) {
				s1[0] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else if (sList.get(i).getWorkDay().equals("Monday")) {
				s1[1] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else if (sList.get(i).getWorkDay().equals("Tuesday")) {
				s1[2] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else if (sList.get(i).getWorkDay().equals("Wednesday")) {
				s1[3] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else if (sList.get(i).getWorkDay().equals("Thursday")) {
				s1[4] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else if (sList.get(i).getWorkDay().equals("Friday")) {
				s1[5] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			} else {
				s1[6] = sList.get(i).getBeginTime() + " - " + sList.get(i).getEndTime();
			}

		}

		for (int i = 0; i < 7; i++) {
			if (absent != null) {
				Date everyDay = new Date();

				if (page == 0) {
					everyDay.setDate(everyDay.getDate() - weekDay + i);
				} else {
					everyDay.setDate(everyDay.getDate() - weekDay + page * 7 + i);
				}
				System.out.println(everyDay);
				LocalDate everyDay2 = everyDay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				if ((leaving.compareTo(everyDay2)) * (return2.compareTo(everyDay2)) <= 0) {
					s1[i] = null;
				}
			}
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		doctorWeekSchedule.setOfficeHour(s1);

		for (int i = weekDay - 1; i >= 0; i--) {
			s1[i] = null;
		}
		Date firstSunday = new Date();
		if (page == 0) {
			for (int i = 0; i < 7; i++) {
				Date everyDay = new Date();
				everyDay.setDate(everyDay.getDate() - weekDay + i);
				// System.out.println("firstSunday.getDate() :------ " +
				// firstSunday.getDate());
				// System.out.println("everyday.getDate() : ------" +
				// everyDay.getDate());
				doctorWeekSchedule.getWorkDate()[i] = sdf.format(everyDay);
			}
			// firstSunday.setDate(firstSunday.getDate()- weekDay);
		} else {
			for (int i = 0; i < 7; i++) {
				Date everyDay = new Date();
				everyDay.setDate(everyDay.getDate() - weekDay + page * 7 + i);
				// System.out.println("firstSunday.getDate() :------ " +
				// firstSunday.getDate());
				// System.out.println("everyday.getDate() : ------" +
				// everyDay.getDate());
				doctorWeekSchedule.getWorkDate()[i] = sdf.format(everyDay);
			}
			// firstSunday.setDate(firstSunday.getDate()- weekDay + page*7);
		}
		System.out.println("firstSunday : ------" + firstSunday);
		// for(int i =0 ; i<7 ; i++){
		// Date everyDay = new Date();
		// everyDay.setDate(firstSunday.getDate()+i);
		// System.out.println("firstSunday.getDate() :------ " +
		// firstSunday.getDate());
		// System.out.println("everyday.getDate() : ------" + everyDay.getDate()
		// );
		// doctorWeekSchedule.getWorkDate()[i] = sdf.format(everyDay);
		// }
		return doctorWeekSchedule;
	}
}
