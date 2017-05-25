/**
 * 
 */
package com.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 3:47:25 PM
 */
@Entity
@Table(name = "Department3_TBL")
public class Department {
	private Integer departmentId;
	private String departmentName;
	// private Set<Doctor> doctor = new HashSet<Doctor>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "departmentId", unique = true, nullable = false)
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Column(name = "departmentName", nullable = false)
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Department() {

	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
