/**
 * 
 */
package com.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pojo.Patient;
import com.service.PatientService;

/**
 * @author: Yijun Chen
 * @date: May 11, 2017
 * @time: 12:38:17 AM
 */
@Component
public class PatientFormValidator implements Validator{
	
//	@Autowired
//	@Qualifier("emailValidator")
//	EmailValidator emailValidator;
	
	@Autowired
	PatientService patientService;

	public boolean supports(Class<?> arg0) {
		return Patient.class.equals(arg0);
	}

	public void validate(Object arg0, Errors errors) {
		Patient patient = (Patient)arg0;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "patientName", "NotEmpty.patient.patientName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.patient.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty.patient.gender");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.patient.password");
		
//		if(!emailValidator.valid(patient.getEmail())){
//			errors.rejectValue("email", "Pattern.userForm.email");
//		}
	}

}
