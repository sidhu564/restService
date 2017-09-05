package com.fsb.module.tidalbatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.taidal.entity.JobStatus;
import com.company.taidal.service.IJobStatusService;

@Controller
public class JobStatusController {
	@Autowired
	private IJobStatusService jobStatusService;
	
	@RequestMapping("/{jobname}")
	public ResponseEntity<JobStatus> getJobStatusById(@PathVariable("jobname") String jobName) {
		JobStatus article = jobStatusService.getJobStatusByName(jobName);
		return new ResponseEntity<JobStatus>(article, HttpStatus.OK);
	}
} 