/**
 * 
 */
package com.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;




/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:42:18 PM
 */
@Entity
@Proxy(lazy=false) 
@Table(name = "Doctor3_TBL")
public class Doctor {
	private Integer doctorId;
	private String doctorName;
	private String email;
	private String password;
	private String isAdmin;
	private Department department;
	private Set<Schedule> schedule = new HashSet<Schedule>(0);
	private Set<Patient> patient = new HashSet<Patient>(0);
	private Set<Absent> absent = new HashSet<Absent>(0);
	private Set<Feedback> feedback = new HashSet<Feedback>(0);
	private Set<Appointment> appointment = new HashSet<Appointment>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "doctorId", unique = true, nullable = false)
	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@Column(name = "doctorName",  nullable = false)
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Column(name = "email",  nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password",  nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "isAdmin",  nullable = false)
	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "department", nullable = false)
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
	public Set<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Schedule> schedule) {
		this.schedule = schedule;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Set<Patient> getPatient() {
		return patient;
	}

	public void setPatient(Set<Patient> patient) {
		this.patient = patient;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<Absent> getAbsent() {
		return absent;
	}

	public void setAbsent(Set<Absent> absent) {
		this.absent = absent;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor")
	public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Doctor() {
		
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", email=" + email + ", password="
				+ password + ", isAdmin=" + isAdmin + ", department=" + department.getDepartmentName() + "]";
	}
}
