package com.company.taidal.service;

import java.util.List;

import com.company.taidal.entity.JobStatus;

public interface IJobStatusService {
     List<JobStatus> getAllJobStatus();
     JobStatus getJobStatusById(int jobStatusId);
     boolean createJobStatus(JobStatus jobStatus);
     void updateJobStatus(JobStatus jobStatus);
     void deleteJobStatus(int jobStatusId);
}
