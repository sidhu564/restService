package com.company.taidal.dao;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.taidal.entity.JobStatus;
@Transactional
@Repository
public class JobStatusDAO implements IJobStatusDAO {
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public void createJobStatus(JobStatus jobStatus) {
		entityManager.persist(jobStatus);
	}
	
	@Override
	public JobStatus getJobStatusByName(String jobName) {
		// TODO Auto-generated method stub
		return null;
	}	
}
