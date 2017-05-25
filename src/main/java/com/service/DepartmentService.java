/**
 * 
 */
package com.service;

import java.util.List;

import com.pojo.Department;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:38:48 AM
 */
public interface DepartmentService {
	public void addOrUpdateDepartment(Department department);
	public void deleteDepartment(Integer departmentId);
	//public void updateDepartment(Department department);
	public Department viewDepartmentById(Integer departmentId);
	public Department viewDepartmentByName(String name);
	public List<Department> viewAllDepartments();
}
