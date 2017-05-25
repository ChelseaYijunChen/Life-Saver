/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Absent;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 11:19:31 PM
 */
public interface AbsentDao {
	public void addAbsent(Absent absent);
	public void deleteAbsent(Integer absentId);
	public void updateAbsent(Absent absent);
	public Absent viewAbsentById(Integer absentId);
	public List<Absent> viewAbsentByDoctorId(Integer doctorId);
	public List<Absent> viewAllAbsents();
	public List<Absent> viewApprovedAbsents();
	public List<Absent> viewAbsentsNeedToApprove();
}
