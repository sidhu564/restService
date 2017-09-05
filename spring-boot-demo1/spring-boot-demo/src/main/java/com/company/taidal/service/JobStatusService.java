package com.company.taidal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.taidal.dao.IJobStatusDAO;
import com.company.taidal.entity.JobStatus;
@Service
public class JobStatusService implements IJobStatusService {
	@Autowired
	private IJobStatusDAO jobStatusDAO;

	@Override
	public JobStatus getJobStatusByName(String jobName) {
		JobStatus jobStatus = new JobStatus();
		jobStatus.setJobName(jobName);
		createJobStatus(jobStatus);
		return null;
	}

	@Override
	public synchronized boolean createJobStatus(JobStatus jobStatus){
	   jobStatusDAO.createJobStatus(jobStatus);
	   return true;
	}
}
