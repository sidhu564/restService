package com.company.taidal.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="jobStatus")
public class JobStatus implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jobStatus_id")
    private int jobStatusId;  
	@Column(name="title")
    private String title;
	@Column(name="category")	
	private String category;
	
	public int getJobStatusId() {
		return jobStatusId;
	}
	public void setJobStatusId(int jobStatusId) {
		this.jobStatusId = jobStatusId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
} 