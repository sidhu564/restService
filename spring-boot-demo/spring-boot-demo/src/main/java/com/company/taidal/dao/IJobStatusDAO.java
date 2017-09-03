package com.company.taidal.dao;
import java.util.List;

import com.company.taidal.entity.JobStatus;
public interface IJobStatusDAO {
    List<JobStatus> getAllJobStatus();
    JobStatus getJobStatusById(int jobStatusId);
    void createJobStatus(JobStatus jobStatus);
    void updateJobStatus(JobStatus jobStatus);
    void deleteJobStatus(int jobStatusId);
    boolean jobStatusExists(String title, String category);
}
 