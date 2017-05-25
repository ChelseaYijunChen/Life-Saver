/**
 * 
 */
package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.pojo.Department;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:39:39 AM
 */
@Service("departmentService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao DepartmentDao;

	//@Override
	public void addOrUpdateDepartment(Department department) {
		DepartmentDao.addOrUpdateDepartment( department);	
	}

	//@Override
	public void deleteDepartment(Integer departmentId) {
		DepartmentDao.deleteDepartment(departmentId);
	}

//	@Override
//	public void updateDepartment(Department department) {
//		DepartmentDao.updateDepartment(department);
//	}

	//@Override
	public Department viewDepartmentById(Integer departmentId) {	
		return DepartmentDao.viewDepartmentById(departmentId);
	}

	//@Override
	public Department viewDepartmentByName(String name) {
		return DepartmentDao.viewDepartmentByName(name);
	}

	//@Override
	public List<Department> viewAllDepartments() {
		return DepartmentDao.viewAllDepartments();
	}

}
