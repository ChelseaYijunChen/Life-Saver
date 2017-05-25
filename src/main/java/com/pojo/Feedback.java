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

import org.hibernate.annotations.Proxy;

/**
 * @author: Yijun Chen
 * @date: May 10, 2017
 * @time: 2:14:56 PM
 */
@Entity
@Proxy(lazy=false) 
@Table(name = "Feedback3_TBL")
public class Feedback {
	private Integer feedbackId;
	private Integer score;
	private String comment;
	private String commentDate;
	private Patient patient;
	private Doctor doctor;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "feedbackId", unique = true, nullable = false)
	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	@Column(name = "score", nullable = true)
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Column(name = "comment", nullable = true)
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "commentDate", nullable = true)
	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
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

	public Feedback() {

	}

	public Feedback(Integer feedbackId, Integer score, String comment, String commentDate, Patient patient,
			Doctor doctor) {
		this.feedbackId = feedbackId;
		this.score = score;
		this.comment = comment;
		this.commentDate = commentDate;
		this.patient = patient;
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Feedback2 [feedbackId=" + feedbackId + ", score=" + score + ", comment=" + comment + ", commentDate="
				+ commentDate + ", patient=" + patient + ", doctor=" + doctor + "]";
	}
	
}
