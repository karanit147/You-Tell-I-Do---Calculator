package com.example.calculation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class ActivityLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="Id of ToStudent")
	private String toStudentMailId;
	@Column(name="Question")
	private String inputQuestion;
	@Column(name="Result")
	private String outputResult;
	@Column(name="Status")
	private boolean completionStatus;
	
	public ActivityLog(String toStudentMailId, String inputQuestion, String outputResult,
			boolean completionStatus) {
		super();
		this.toStudentMailId = toStudentMailId;
		this.inputQuestion = inputQuestion;
		this.outputResult = outputResult;
		this.completionStatus = completionStatus;
	}

	public ActivityLog() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToStudentMailId() {
		return toStudentMailId;
	}

	public void setToStudentMailId(String toStudentMailId) {
		this.toStudentMailId = toStudentMailId;
	}

	public String getInputQuestion() {
		return inputQuestion;
	}

	public void setInputQuestion(String inputQuestion) {
		this.inputQuestion = inputQuestion;
	}

	public String getOutputResult() {
		return outputResult;
	}

	public void setOutputResult(String outputResult) {
		this.outputResult = outputResult;
	}

	public boolean isCompletionStatus() {
		return completionStatus;
	}

	public void setCompletionStatus(boolean completionStatus) {
		this.completionStatus = completionStatus;
	}

}

