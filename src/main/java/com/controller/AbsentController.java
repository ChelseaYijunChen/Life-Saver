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

import com.pojo.Absent;
import com.pojo.Doctor;
import com.service.AbsentService;
import com.service.DoctorService;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:10:06 AM
 */
@Controller
public class AbsentController {

	@Autowired
	private AbsentService absentService;

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/newAbsentForm", method = RequestMethod.GET)
	public ModelAndView newAbsentForm(@ModelAttribute("absent") Absent absent, BindingResult result) {
		return new ModelAndView("newAbsent");
	}

	@RequestMapping(value = "/addAbsent", method = RequestMethod.POST)
	public ModelAndView addOrUpdateAbsent(@ModelAttribute("absent") Absent absent, BindingResult result,
			HttpServletRequest request) {
		absent.setDoctor(doctorService.viewDoctorById((Integer.parseInt(request.getParameter("doctorId")))));
		absent.setIsApproved("No");
		absentService.addAbsent(absent);
		System.out.println("add absent success...............");
		return new ModelAndView("newAbsent");
	}
	
	@RequestMapping(value = "/approveAbsentRequest", method = RequestMethod.GET)
	public ModelAndView updateAbsent(@ModelAttribute("absent") Absent absent, BindingResult result,
			HttpServletRequest request) {
		absent = absentService.viewAbsentById(absent.getAbsentId());
		absent.setIsApproved("Yes");
		absentService.updateAbsent(absent);
		Map<String, Object> model = new HashMap<String, Object>();
		List<Absent> absentList = absentService.viewApprovedAbsents();
		model.put("absentList", absentList);
		return new ModelAndView("viewApprovedAbsent", model);
	}

	@RequestMapping(value = "/deleteAbsent", method = RequestMethod.GET)
	public ModelAndView deleteAbsent(@ModelAttribute("absent") Absent absent, BindingResult result,HttpServletRequest request) {
		absentService.deleteAbsent(absent.getAbsentId());
		System.out.println("delete absent success...............");
		//HttpSession session = request.getSession(false);
		//Doctor doctor =  (Doctor) session.getAttribute("d1");
		//List<Absent> absentList = absentService.viewAbsentByDoctorId(doctor.getDoctorId());
		//Map<String, Object> model = new HashMap<String, Object>();
		//model.put("absentList", absentList);
		//return new ModelAndView("viewAbsentByDoctor", model);
		return new ModelAndView("newAbsent");
	}
	
	@RequestMapping(value = "/viewApprovedAbsent", method = RequestMethod.GET)
	public ModelAndView viewApprovedAbsent(@ModelAttribute("absent") Absent absent, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Absent> absentList = absentService.viewApprovedAbsents();
		model.put("absentList", absentList);
		return new ModelAndView("viewApprovedAbsent", model);
	}
	
	@RequestMapping(value = "/viewAbsentByDoctor", method = RequestMethod.GET)
	public ModelAndView viewAbsentByDoctor(HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		Doctor doctor =  (Doctor) session.getAttribute("d1");
		List<Absent> absentList = absentService.viewAbsentByDoctorId(doctor.getDoctorId());
		model.put("absentList", absentList);
		return new ModelAndView("viewAbsentByDoctor", model);
	}
	
	@RequestMapping(value = "/viewAbsentNeedToBeApproved", method = RequestMethod.GET)
	public ModelAndView viewAbsentNeedToApprove(@ModelAttribute("absent") Absent absent, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Absent> absentList = absentService.viewAbsentsNeedToApprove();
		model.put("absentList", absentList);
		return new ModelAndView("viewAbsentNeedToApprove", model);
	}
	
}
