package com.company.taidal.service;

import com.company.taidal.entity.JobStatus;

public interface IJobStatusService {
	 boolean createJobStatus(JobStatus jobStatus);
     JobStatus getJobStatusByName(String jobName);
}
