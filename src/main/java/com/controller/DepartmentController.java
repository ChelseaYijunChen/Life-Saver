/**
 * 
 */
package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pojo.Department;
import com.service.DepartmentService;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 1:10:43 AM
 */
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(value = "/viewAllDepartments", method = RequestMethod.GET)
	public ModelAndView viewAllDepartments() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("departmentList", departmentService.viewAllDepartments());
		return new ModelAndView("department", model);
	}
}
