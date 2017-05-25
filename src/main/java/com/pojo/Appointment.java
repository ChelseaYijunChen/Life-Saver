/**
 * 
 */
package com.pojo;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 1:42:28 PM
 */
@Entity
@Table(name = "Appointment3_TBL")
public class Appointment {
	private Integer appointmentId;
	private Date appointmentDate;
	private Patient patient;
	private Doctor doctor;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "appointmentId", unique = true, nullable = false)
	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "appointmentDate", nullable = false)
	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientId", nullable = false)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId", nullable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Appointment() {

	}

}
