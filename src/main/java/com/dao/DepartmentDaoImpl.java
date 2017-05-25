/**
 * 
 */
package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pojo.Department;

/**
 * @author: Yijun Chen
 * @date: Mar 24, 2017
 * @time: 12:34:34 AM
 */
@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private SessionFactory sessionFactory;

	// @Override
	public void addOrUpdateDepartment(Department department) {
		sessionFactory.getCurrentSession().saveOrUpdate(department);
		System.out.println("add or update department sucess");
	}

	// @Override
	public void deleteDepartment(Integer departmentId) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, departmentId);
		if (null != department) {
			this.sessionFactory.getCurrentSession().delete(department);
		}
	}

	// @Override
	// public void updateDepartment(Department department) {
	// sessionFactory.getCurrentSession().update(department);
	// System.out.println("update product sucess");
	//
	// }

	// @Override
	public Department viewDepartmentById(Integer departmentId) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, departmentId);
		return department;
	}

	// @Override
	public Department viewDepartmentByName(String name) {
		Department department = (Department) sessionFactory.getCurrentSession().load(Department.class, name);
		return department;
	}

	// @Override
	public List<Department> viewAllDepartments() {
		return this.sessionFactory.getCurrentSession().createQuery("from Department").getResultList();
		// return (List<Department>)
		// sessionFactory.getCurrentSession().createCriteria(Department.class).list();
	}

}
