/**
 * 
 */
package com.pojo;

import static javax.persistence.GenerationType.IDENTITY;

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
 * @time: 3:07:11 PM
 */
@Entity
@Table(name = "Schedule3_TBL")
public class Schedule {
	private Integer scheduleId;
	private String workDay;
	private String beginTime;
	private String endTime;
	private Doctor doctor;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "scheduleId", unique = true, nullable = false)
	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	@Column(name = "wordDay", nullable = true)
	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "beginTime", nullable = true)
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "endTime", nullable = true)
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctorId", nullable = false)
	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Schedule() {

	}

	public Schedule(Integer scheduleId, String workDay, String beginTime, String endTime, Doctor doctor) {
		this.scheduleId = scheduleId;
		this.workDay = workDay;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.doctor = doctor;
	}

}
