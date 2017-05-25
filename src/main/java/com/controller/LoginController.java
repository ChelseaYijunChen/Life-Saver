/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Doctor;
import com.service.DoctorService;
import com.service.DoctorServiceImpl;


/**
 * @author: Yijun Chen
 * @date: Mar 26, 2017
 * @time: 5:51:05 PM
 */
@Controller
public class LoginController {
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView showLoginForm() {
		return new ModelAndView("index");
	}
}
