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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pojo.Patient;
import com.service.PatientService;
import com.validator.PatientFormValidator;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:11:11 AM
 */
@Controller
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@Autowired
	PatientFormValidator patientFormValidator;
	
	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(patientFormValidator);
	}
	
	@RequestMapping(value = "/patientLogin", method = RequestMethod.GET)
	public ModelAndView showLoginForm(@ModelAttribute("patient")  Patient patient,
			   BindingResult result) {
		return new ModelAndView("patientLogin");
	}
	
	@RequestMapping(value="/patientLoginForm", method = RequestMethod.POST)
	  public ModelAndView checkPassword(@ModelAttribute("patient")  Patient patient,
	   BindingResult result, HttpServletRequest request) {
	   
		boolean isValidUser = patientService.isValidPatient(patient.getEmail(), patient.getPassword());
		
		Map<String, Object> model = new HashMap<String, Object>();
	     if (isValidUser ){
	    	 Patient p1 = patientService.viewPatientByEmail(patient.getEmail());
	    	 HttpSession session = request.getSession(true);
	    	 session.setAttribute("p1", p1);
	    	 model.put("patientName", p1.getPatientName());
	    	 System.out.println("vali..............." + p1.getPatientName());
	    	 return new ModelAndView("patientHome", model);
	     } else {
	    	 model.put("patient",new Patient());
	    	 System.out.println("not  vali...............");
	   //model.put("message","Invalid Username/Passowrd");
	         return new ModelAndView("patientLogin", model);
	     } 
	}
	
	@RequestMapping(value = "/addOrUpdatePatientForm", method = RequestMethod.GET)
	public ModelAndView addOrUpdatePatientForm(@ModelAttribute("patient")  Patient patient,
			   BindingResult result) {
		return new ModelAndView("newPatient");
	}
	
	
	
//	@RequestMapping(value = "/addOrUpdatePatient", method = RequestMethod.POST)
//	public ModelAndView addOrUpdatePatient(@ModelAttribute("patient") Patient patient, 
//			BindingResult result) {
//		patientService.addOrUpdatePatient(patient);
//		System.out.println("add patient success...............");
//		return new ModelAndView("newPatient");
//	}
	
	@RequestMapping(value = "/addOrUpdatePatient", method = RequestMethod.POST)
	public ModelAndView addOrUpdatePatient(@ModelAttribute("patient") @Validated Patient patient, 
			BindingResult result, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return new ModelAndView("newPatient");
		} else {
			// Add message to flash scope
			redirectAttributes.addFlashAttribute("css", "success");
//			if(patient.isNew()){
//			  redirectAttributes.addFlashAttribute("msg", "Patient added successfully!");
//			}else{
//			  redirectAttributes.addFlashAttribute("msg", "Patient updated successfully!");
//			}
		
			patientService.addOrUpdatePatient(patient);
		}
		System.out.println("add patient success...............");
		return new ModelAndView("newPatient");
	}
	
	@RequestMapping(value="/viewAllPatients", method = RequestMethod.GET)
	public ModelAndView viewAllPatients() {
		System.out.println("view all patients");
		Map<String, Object> model = new HashMap<String, Object>();
	    model.put("patientsList", patientService.viewAllPatients());
		return new ModelAndView("viewPatient", model);
	}
	
	@RequestMapping(value = "/searchPatient", method = RequestMethod.GET)
	public ModelAndView searchByName(@ModelAttribute("command")  Patient patient,
			BindingResult result) {
		System.out.println("searh patient by name-------------");
		return new ModelAndView("searchPatient");
	}
	
	@RequestMapping(value = "/searchPatientByName", method = RequestMethod.POST)
	public ModelAndView searchDoctor(@RequestParam("patientName") String patientName) {
		Map<String, Object> model = new HashMap<String, Object>();
		System.out.println("--------- patient name -------------");
		System.out.println(patientName );
		List <Patient> patient = (List<Patient>) patientService.viewPatientByName(patientName);
		System.out.println(patient.toString());
		model.put("patient", null);
		model.put("patientsList",  patient);
		return new ModelAndView("viewPatient", model);
	}
	
	@RequestMapping(value = "/deletePatient", method = RequestMethod.GET)
	public ModelAndView deleteDoctor(@ModelAttribute("command") Patient patient, BindingResult result) {
		patientService.deletePatient(patient);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patientsList", patientService.viewAllPatients());
		return new ModelAndView("viewPatient", model);
	}
	
	@RequestMapping(value = "/editPatientForm", method = RequestMethod.GET)
	public ModelAndView editeDoctor(@ModelAttribute("patient") Patient patient, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("patient", patientService.viewPatientById(patient.getPatientId()));
		return new ModelAndView("newPatient", model);
	}
}
