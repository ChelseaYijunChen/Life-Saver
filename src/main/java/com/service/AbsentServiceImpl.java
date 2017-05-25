/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AbsentDao;
import com.pojo.Absent;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:32:20 AM
 */
@Service("AbsentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AbsentServiceImpl implements AbsentService{
	
	@Autowired
	private AbsentDao absentDao;

	//@Override
	public void addAbsent(Absent absent) {
		absentDao.addAbsent( absent);	
	}

	//@Override
	public void deleteAbsent(Integer absentId) {
		absentDao.deleteAbsent(absentId);
	}

	//@Override
	public void updateAbsent(Absent absent) {
		absentDao.updateAbsent(absent);
	}

	//@Override
	public Absent viewAbsentById(Integer absentId) {	
		return absentDao.viewAbsentById(absentId);
	}

	//@Override
	public List<Absent> viewAllAbsents() {
		return absentDao.viewAllAbsents();
	}

	//@Override
	public List<Absent> viewAbsentByDoctorId(Integer doctorId) {
		return absentDao.viewAbsentByDoctorId(doctorId);
	}

	public List<Absent> viewApprovedAbsents() {
		return absentDao.viewApprovedAbsents();
	}

	public List<Absent> viewAbsentsNeedToApprove() {
		return absentDao.viewAbsentsNeedToApprove();
	}

}
