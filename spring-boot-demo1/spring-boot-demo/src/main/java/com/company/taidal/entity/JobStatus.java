package com.company.taidal.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="batch_job_status")
public class JobStatus implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="jobStatus_id")
	@NotNull
    private int jobStatusId;  
	
	@Column(name="job_name")
    private String jobName;

	public int getJobStatusId() {
		return jobStatusId;
	}

	public void setJobStatusId(int jobStatusId) {
		this.jobStatusId = jobStatusId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
} 