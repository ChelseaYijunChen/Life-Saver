/**
 * 
 */
package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Yijun Chen
 * @date: Apr 2, 2017
 * @time: 9:43:29 PM
 */
public class DoctorWeekSchedule {
	private Integer doctorId;
	private Integer page;
	private String[] workDate = new String[7];
	private String[] officeHour = new String[7];
	

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String[] getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String[] workDate) {
		this.workDate = workDate;
	}

	public String[] getOfficeHour() {
		return officeHour;
	}

	public void setOfficeHour(String[] officeHour) {
		this.officeHour = officeHour;
	}
	
}
