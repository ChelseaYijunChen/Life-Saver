/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Department;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:34:21 AM
 */
public interface DepartmentDao {
	public void addOrUpdateDepartment(Department department);
	public void deleteDepartment(Integer departmentId);
	//public void updateDepartment(Department department);
	public Department viewDepartmentById(Integer departmentId);
	public Department viewDepartmentByName(String name);
	public List<Department> viewAllDepartments();
}
