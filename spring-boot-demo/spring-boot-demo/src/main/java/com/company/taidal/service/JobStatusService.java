package com.company.taidal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.taidal.dao.IJobStatusDAO;
import com.company.taidal.entity.JobStatus;
@Service
public class JobStatusService implements IJobStatusService {
	@Autowired
	private IJobStatusDAO articleDAO;
	@Override
	public JobStatus getJobStatusById(int jobStatusId) {
		JobStatus obj = articleDAO.getJobStatusById(jobStatusId);
		return obj;
	}	
	@Override
	public List<JobStatus> getAllJobStatus(){
		return articleDAO.getAllJobStatus();
	}
	@Override
	public synchronized boolean createJobStatus(JobStatus jobStatus){
       if (articleDAO.jobStatusExists(jobStatus.getTitle(), jobStatus.getCategory())) {
    	   return false;
       } else {
    	   articleDAO.createJobStatus(jobStatus);
    	   return true;
       }
	}
	@Override
	public void updateJobStatus(JobStatus jobStatus) {
		articleDAO.updateJobStatus(jobStatus);
	}
	@Override
	public void deleteJobStatus(int jobStatusId) {
		articleDAO.deleteJobStatus(jobStatusId);
	}
}
