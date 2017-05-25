/**
 * 
 */
package com.controller;

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

import com.pojo.Doctor;
import com.pojo.Schedule;
import com.service.DoctorService;
import com.service.ScheduleService;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:11:19 AM
 */
@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/addScheduleForm", method = RequestMethod.GET)
	public ModelAndView addScheduleForm(@ModelAttribute("schedule") Schedule schedule, BindingResult result) {
		return new ModelAndView("newSchedule2");
	}

	@RequestMapping(value = "/addSchdule", method = RequestMethod.POST)
	public ModelAndView addOrUpdatePatient(HttpServletRequest request) {
		for (int i = 1; i <= 7; i++) {
			Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
			String workDay = request.getParameter("workDay" + i);
			System.out.println(workDay);
			if(workDay == null){
				continue;
			}
			String beginTime = request.getParameter("beginTime" + i);
			String endTime = request.getParameter("endTime" + i);
			System.out.println(doctorId + " " + workDay + " " + beginTime + " " + endTime);
			Schedule s1 = new Schedule();
			s1.setDoctor(doctorService.viewDoctorById(doctorId));
			s1.setBeginTime(beginTime);
			s1.setEndTime(endTime);
			s1.setWorkDay(workDay);
			scheduleService.addSchedule(s1);
			System.out.println("add schedule success...............");
		}
		return new ModelAndView("newSchedule2");
	}
	
	@RequestMapping(value = "/viewSchedule", method = RequestMethod.GET)
	public ModelAndView viewSchedule(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		Doctor doctor =  (Doctor) session.getAttribute("d1");
		System.out.println(doctor.toString());
		List<Schedule> scheduleList = scheduleService.viewScheduleByDoctorId(doctor.getDoctorId());
		model.put("scheduleList", scheduleList);
		return new ModelAndView("viewSchedule", model);
	}
	
	@RequestMapping(value = "/editScheduleForm", method = RequestMethod.GET)
	public ModelAndView editSchedule(@ModelAttribute("schedule") Schedule schedule, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		schedule = scheduleService.viewScheduleById(schedule.getScheduleId());
		model.put("schedule", schedule);
		return new ModelAndView("editSchedule", model);
	}
	
	@RequestMapping(value = "/deleteSchedule", method = RequestMethod.GET)
	public ModelAndView deleteSchedule(@ModelAttribute("schedule") Schedule schedule, BindingResult result, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		scheduleService.deleteSchedule(schedule.getScheduleId());
		List<Schedule> scheduleList = scheduleService.viewScheduleByDoctorId(Integer.parseInt(request.getParameter("doctorId")));
		model.put("scheduleList", scheduleList);
		return new ModelAndView("viewSchedule", model);
	}
	

	// @RequestMapping(value = "/addSchdule", method = RequestMethod.POST)
	// public ModelAndView addOrUpdatePatient(@RequestParam("doctor") String
	// doctorId, @RequestParam("workDay") List<String> workDay,
	// @RequestParam("beginTime") List<String> beginTime,
	// @RequestParam("endTime") List<String> endTime, BindingResult result) {
	// String workDay1 = workDay.get(0);
	// String workDay2 = workDay.get(1);
	// String beginTime1 = beginTime.get(0);
	// String beginTime2 = beginTime.get(1);
	// String endTime1 = endTime.get(0);
	// String endTime2 = endTime.get(1);
	// Schedule s1 = new Schedule();
	// s1.setDoctor(doctorService.viewDoctorById(new Integer(1)));
	// s1.setBeginTime(beginTime1);
	// s1.setEndTime(endTime1);
	// s1.setWorkDay(workDay1);
	// scheduleService.addSchedule(s1);
	//
	// Schedule s2 = new Schedule();
	// s2.setDoctor(doctorService.viewDoctorById(new Integer(1)));
	// s2.setBeginTime(beginTime2);
	// s2.setEndTime(endTime2);
	// s2.setWorkDay(workDay2);
	// scheduleService.addSchedule(s2);
	//
	// System.out.println("add schedule success...............");
	// return new ModelAndView("newSchedule2");
	// }
}
