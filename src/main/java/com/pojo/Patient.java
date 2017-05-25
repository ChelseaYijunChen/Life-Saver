/**
 * 
 */
package com.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:42:10 PM
 */
@Entity
@Proxy(lazy=false) 
@Table(name = "Patient3_TBL")
public class Patient {
	private Integer patientId;
	private String patientName;
	private String gender;
	private String email;
	private String password;
	private Set<Feedback> feedback = new HashSet<Feedback>(0);
	private Set<Appointment> appointment = new HashSet<Appointment>(0);

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "patientId", unique = true, nullable = false)
	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	@Column(name = "patientName", nullable = false)
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	public Set<Feedback> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<Feedback> feedback) {
		this.feedback = feedback;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

	public Patient() {

	}

	public Patient(Integer patientId, String patientName, String gender, String email, String password,
			Set<Feedback> feedback, Set<Appointment> appointment) {
		this.patientId = patientId;
		this.patientName = patientName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.feedback = feedback;
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", gender=" + gender + ", email="
				+ email + ", appointment=" + appointment + "]";
	}

}
