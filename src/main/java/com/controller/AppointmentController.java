/**
 * 
 */
package com.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.DoctorWeekSchedule;
import com.pojo.Appointment;
import com.pojo.Doctor;
import com.pojo.Patient;
import com.pojo.Schedule;
import com.service.AppointmentService;
import com.service.DoctorService;
import com.service.PatientService;
import com.service.ScheduleService;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:10:28 AM
 */
@Controller
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private PatientService patientService;

	@RequestMapping(value = "/appointmentForm", method = RequestMethod.GET)
	public ModelAndView addAppointmentForm(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		Appointment appointment = new Appointment();
//		HttpSession session = request.getSession(true);
//		Doctor doctor = (Doctor) session.getAttribute("d1");
//		int doctorId = doctor.getDoctorId();
		appointment.setDoctor(doctorService.viewDoctorById(Integer.parseInt(request.getParameter("doctorId"))));
		HttpSession session = request.getSession(false);
		appointment.setPatient((Patient) session.getAttribute("p1"));
		List<Schedule> sList = scheduleService.viewScheduleByDoctorId(new Integer("1"));
		int[] s1 = new int[7];
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < sList.size(); i++) {
			if (sList.get(i).getWorkDay().equals("Sunday")) {
				s1[0]++;
			} else if (sList.get(i).getWorkDay().equals("Monday")) {
				s1[1]++;
			} else if (sList.get(i).getWorkDay().equals("Tuesday")) {
				s1[2]++;
			} else if (sList.get(i).getWorkDay().equals("Wednesday")) {
				s1[3]++;
			} else if (sList.get(i).getWorkDay().equals("Thursday")) {
				s1[4]++;
			} else if (sList.get(i).getWorkDay().equals("Friday")) {
				s1[5]++;
			} else {
				s1[6]++;
			}
		}
		for (int i = 0; i < 7; i++) {
			if (s1[i] == 0) {
				result.add(i);
			}
		}
		// System.out.println(result.toString());
		int[] res = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			res[i] = result.get(i);
			System.out.println(res[i]);
			System.out.println("-------");
		}
		// System.out.println("-----result to array----");

		model.put("result", result);
		model.put("res", res);
		model.put("appointment", appointment);
		return new ModelAndView("appointment", model);
	}

	@RequestMapping(value = "/newAppointment", method = RequestMethod.GET)
	public ModelAndView addOrUpdatePatient(@ModelAttribute("appointment") Appointment appointment, BindingResult result,
			HttpServletRequest request) {
		System.out.println("---------make appointment---------");
		Doctor doctor = doctorService.viewDoctorById(Integer.parseInt(request.getParameter("doctorId")));
		appointment.setDoctor(doctor);
		HttpSession session = request.getSession(false);
		appointment.setPatient((Patient) session.getAttribute("p1"));
		Date date = new Date();
		String appointmentDate = request.getParameter("appointmentDate");
		System.out.println(appointmentDate);
		String[] res = appointmentDate.split("-");
		System.out.println(res);
		int dd = Integer.parseInt(res[0]);
		int mm = Integer.parseInt(res[1]);
		int yy = Integer.parseInt(res[2]);

		date.setYear(yy - 1900);
		date.setMonth(mm - 1);
		date.setDate(dd);
		appointment.setAppointmentDate(date);
		System.out.println(appointment.toString());
		appointmentService.addAppointment(appointment);
		System.out.println("make appointment success...............");
		return new ModelAndView("newAppointment");
	}

	@RequestMapping(value = "/doctorWeekScheduelForm", method = RequestMethod.GET)
	public ModelAndView doctorWeekScheduelForm(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
		Integer page = Integer.parseInt(request.getParameter("page"));
		// List<Schedule> sList =
		// scheduleService.viewScheduleByDoctorId(doctorId);
		DoctorWeekSchedule doctorWeekSchedule = patientService.listDoctorSchedule(doctorId, page);
		// String[] s1 = new String[7];
		// for(int i =0; i<sList.size(); i++){
		// if(sList.get(i).getWorkDay().equals("Sunday")){
		// s1[0] = sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else if(sList.get(i).getWorkDay().equals("Monday")) {
		// s1[1] = sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else if(sList.get(i).getWorkDay().equals("Tuesday")){
		// s1[2] = sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else if(sList.get(i).getWorkDay().equals("Wednesday")){
		// s1[3]= sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else if(sList.get(i).getWorkDay().equals("Thursday")){
		// s1[4]= sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else if(sList.get(i).getWorkDay().equals("Friday")){
		// s1[5]= sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// } else {
		// s1[6]= sList.get(i).getBeginTime() +" - " +
		// sList.get(i).getEndTime();
		// }
		// }
		// String[] work = new String[7];
		// work[0] = "04/02/2017";
		// work[1] = "04/03/2017";
		// work[2] = "04/04/2017";
		// work[3] = "04/05/2017";
		// work[4] = "04/06/2017";
		// work[5] = "04/07/2017";
		// work[6] = "04/08/2017";
		// doctorWeekSchedule.setWorkDate(work);
		model.put("doctorId", doctorId);
		model.put("doctorWeekSchedule", doctorWeekSchedule);
		return new ModelAndView("appointment2", model);
	}

}
