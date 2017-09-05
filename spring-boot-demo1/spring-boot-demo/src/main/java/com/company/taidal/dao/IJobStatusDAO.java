package com.company.taidal.dao;
import com.company.taidal.entity.JobStatus;
public interface IJobStatusDAO {
	void createJobStatus(JobStatus jobStatus);
	JobStatus getJobStatusByName(String jobName);
}
 