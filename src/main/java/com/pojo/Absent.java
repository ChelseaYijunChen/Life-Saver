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

import org.hibernate.annotations.Proxy;

/**
 * @author: Yijun Chen
 * @date: Mar 23, 2017
 * @time: 2:22:11 PM
 */
@Entity
@Proxy(lazy=false) 
@Table(name = "Absent3_TBL")
public class Absent {
	private Integer absentId;
	private Date leavingDate;
	private Date returnDate;
	private String isApproved;
	private Doctor doctor;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ansentId", unique = true, nullable = false)
	public Integer getAbsentId() {
		return absentId;
	}

	public void setAbsentId(Integer absentId) {
		this.absentId = absentId;
	}

	// @Temporal(TemporalType.DATE)
	@Column(name = "leavingDate", nullable = false)
	public Date getLeavingDate() {
		return leavingDate;
	}

	public void setLeavingDate(Date leavingDate) {
		this.leavingDate = leavingDate;
	}

	// @Temporal(TemporalType.DATE)
	@Column(name = "returnDate", nullable = false)
	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Column(name = "isApproved", nullable = false)
	public String getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(String isApproved) {
		this.isApproved = isApproved;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId", nullable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Absent() {

	}

	@Override
	public String toString() {
		return "Absent [absentId=" + absentId + ", leavingDate=" + leavingDate + ", returnDate=" + returnDate
				+ ", isApproved=" + isApproved + ", doctor=" + doctor + "]";
	}
	
}
