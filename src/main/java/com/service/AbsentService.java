/**
 * 
 */
package com.service;

import java.util.List;

import com.pojo.Absent;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:31:43 AM
 */
public interface AbsentService {
	public void addAbsent(Absent absent);
	public void deleteAbsent(Integer absentId);
	public void updateAbsent(Absent absent);
	public Absent viewAbsentById(Integer absentId);
	public List<Absent> viewAbsentByDoctorId(Integer doctorId);
	public List<Absent> viewAllAbsents();
	public List<Absent> viewApprovedAbsents();
	public List<Absent> viewAbsentsNeedToApprove();
}
