/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Department;
import com.pojo.Doctor;
import com.pojo.Patient;
import com.service.DepartmentService;
import com.service.DoctorService;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:10:52 AM
 */
@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/doctorLogin", method = RequestMethod.GET)
	public ModelAndView showLoginForm(@ModelAttribute("doctor") Doctor doctor, BindingResult result,
			HttpSession session) {
		return new ModelAndView("doctorLogin");
	}

	@RequestMapping(value = "/doctorLoginForm", method = RequestMethod.POST)
	public ModelAndView checkPassword(@ModelAttribute("doctor") Doctor doctor, BindingResult result,
			HttpServletRequest request) {

		boolean isValidUser = doctorService.isValidUser(doctor.getEmail(), doctor.getPassword());
		boolean isAdmin = doctorService.isAdmin(doctor.getEmail());
		Map<String, Object> model = new HashMap<String, Object>();
		if (isValidUser && isAdmin) {
			Doctor d1 = doctorService.viewDoctorByEmail(doctor.getEmail());
			// model.put("doctor", doctor);
			HttpSession session = request.getSession(true);
			session.setAttribute("d1", d1);
			System.out.println("vali...............");
			return new ModelAndView("adminHome", model);
		} else if (isValidUser) {
			model.put("doctorName", doctor.getDoctorName());
			Doctor d1 = doctorService.viewDoctorByEmail(doctor.getEmail());
			HttpSession session = request.getSession(true);
			session.setAttribute("d1", d1);
			System.out.println("vali...............");
			return new ModelAndView("doctorHome", model);
		} else {
			model.put("doctor", new Doctor());
			System.out.println("not  vali...............");
			// model.put("message","Invalid Username/Passowrd");
			return new ModelAndView("doctorLogin", model);
		}
	}

	@RequestMapping(value = "/viewAllDoctors", method = RequestMethod.GET)
	public ModelAndView viewAllDoctors() {
		System.out.println("view all doctor");
		Map<String, Object> model = new HashMap<String, Object>();
		List<Doctor> doctor = doctorService.viewAllDoctors();
		System.out.println(doctor.get(0).toString());
		model.put("doctorsList", doctor);
		return new ModelAndView("viewDoctor", model);
	}

	@RequestMapping(value = "/viewDoctorByDepartment", method = RequestMethod.GET)
	public ModelAndView viewDoctorByDepartment(@ModelAttribute("command") Department department, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(department.getDepartmentId());
		List<Doctor> doctor = doctorService.viewDoctorByDepartment(department.getDepartmentId());
		model.put("doctorsList", doctor);
		return new ModelAndView("viewDoctorByDepartment", model);
	}
	
	@RequestMapping(value="/viewPatientByDoctor", method = RequestMethod.GET)
	public ModelAndView viewPatientByDoctor(HttpServletRequest request) {
		System.out.println("view patients by doctor");
		Map<String, Object> model = new HashMap<String, Object>();
		HttpSession session = request.getSession(false);
		Doctor doctor =  (Doctor) session.getAttribute("d1");
		System.out.println(doctor.toString());
		Set<Patient> p= doctor.getPatient();
		System.out.println(p.toString());
		//List <Patient> patient = patientService
	    model.put("patientsList", p);
		return new ModelAndView("viewPatient", model);
	}

	@RequestMapping(value = "/searchDoctor", method = RequestMethod.GET)
	public ModelAndView searchByName(@ModelAttribute("command") Doctor doctor, BindingResult result) {
		System.out.println("searh doctor by name-------------");
		return new ModelAndView("searchDoctor");
	}

	@RequestMapping(value = "/searchDoctorByName", method = RequestMethod.POST)
	public ModelAndView searchDoctor(@RequestParam("doctorName") String doctorName) {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Doctor> doctor = doctorService.viewDoctorByName(doctorName);
		model.put("doctorsList", doctor);
		return new ModelAndView("viewDoctor", model);
	}

	@RequestMapping(value = "/deleteDoctor", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(@ModelAttribute("command") Doctor doctor, BindingResult result) {
		System.out.println("from delete, doctor ID" + doctor.getDoctorId());
		doctorService.deleteDoctor(doctor);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctorsList", doctorService.viewAllDoctors());
		return new ModelAndView("viewDoctor", model);
	}

	@RequestMapping(value = "/editDoctorForm", method = RequestMethod.GET)
	public ModelAndView editeDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println(doctor.getDoctorId());
		model.put("doctor", doctorService.viewDoctorById(doctor.getDoctorId()));
		model.put("deparmentList", departmentService.viewAllDepartments());
		return new ModelAndView("editDoctor", model);
	}

	@RequestMapping(value = "/updateDoctor", method = RequestMethod.POST)
	public ModelAndView updateDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result,
			HttpServletRequest request) {
		doctor.setDepartment(
				departmentService.viewDepartmentById(Integer.parseInt(request.getParameter("departmentId"))));
		doctorService.addOrUpdateDoctor(doctor);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("doctorsList", doctorService.viewAllDoctors());
		return new ModelAndView("viewDoctor", model);
	}

	@RequestMapping(value = "/addOrUpdateDoctorForm", method = RequestMethod.GET)
	public ModelAndView addOrUpdateDoctorForm(@ModelAttribute("doctor") Doctor doctor, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("deparmentList", departmentService.viewAllDepartments());
		return new ModelAndView("newDoctor", model);
	}

	@RequestMapping(value = "/addOrUpdateDoctor", method = RequestMethod.POST)
	public ModelAndView addOrUpdateDoctor(@ModelAttribute("doctor") Doctor doctor, BindingResult result,
			HttpServletRequest request) {
		doctor.setIsAdmin("No");
		doctor.setDepartment(
				departmentService.viewDepartmentById(Integer.parseInt(request.getParameter("departmentId"))));
		doctorService.addOrUpdateDoctor(doctor);
		System.out.println("add doctor success...............");
		return new ModelAndView("newDoctor");
	}
}
