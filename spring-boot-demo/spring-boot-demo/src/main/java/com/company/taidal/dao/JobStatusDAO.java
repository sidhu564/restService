package com.company.taidal.dao;
import java.util.List;

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
	public JobStatus getJobStatusById(int jobStatusId) {
		return entityManager.find(JobStatus.class, jobStatusId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<JobStatus> getAllJobStatus() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId DESC";
		return (List<JobStatus>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void createJobStatus(JobStatus jobStatus) {
		entityManager.persist(jobStatus);
	}
	@Override
	public void updateJobStatus(JobStatus jobStatus) {
		JobStatus artcl = getJobStatusById(jobStatus.getJobStatusId());
		artcl.setTitle(jobStatus.getTitle());
		artcl.setCategory(jobStatus.getCategory());
		entityManager.flush();
	}
	@Override
	public void deleteJobStatus(int jobStatusId) {
		entityManager.remove(getJobStatusById(jobStatusId));
	}
	@Override
	public boolean jobStatusExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}
}
