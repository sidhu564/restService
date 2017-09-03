package com.company.taidal.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.company.taidal.entity.JobStatus;
import com.company.taidal.service.IJobStatusService;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class JobStatusController {
	@Autowired
	private IJobStatusService articleService;
	@GetMapping("article")
	public ResponseEntity<JobStatus> getJobStatusById(@RequestParam("id") String id) {
		JobStatus article = articleService.getJobStatusById(Integer.parseInt(id));
		return new ResponseEntity<JobStatus>(article, HttpStatus.OK);
	}
	@GetMapping("all-articles")
	public ResponseEntity<List<JobStatus>> getAllJobStatus() {
		List<JobStatus> list = articleService.getAllJobStatus();
		return new ResponseEntity<List<JobStatus>>(list, HttpStatus.OK);
	}
	@PostMapping("article")
	public ResponseEntity<Void> createJobStatus(@RequestBody JobStatus article, UriComponentsBuilder builder) {
        boolean flag = articleService.createJobStatus(article);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/article?id={id}").buildAndExpand(article.getJobStatusId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("article")
	public ResponseEntity<JobStatus> updateJobStatus(@RequestBody JobStatus article) {
		articleService.updateJobStatus(article);
		return new ResponseEntity<JobStatus>(article, HttpStatus.OK);
	}
	@DeleteMapping("article")
	public ResponseEntity<Void> deleteJobStatus(@RequestParam("id") String id) {
		articleService.deleteJobStatus(Integer.parseInt(id));
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 