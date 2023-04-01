package com.example.rest.controllers;

import com.example.rest.dto.JsonWrapper;
import com.example.rest.models.JobInstance;
import com.example.rest.services.JobInstanceService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.batch.core.launch.JobOperator;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/batch")
public class JobController {

    @Autowired
    private JobInstanceService jobInstanceService;


    private final JobExplorer jobExplorer;
    private final JobOperator jobOperator;
    private final JobRegistry jobRegistry;
    private final JobRepository jobRepository;
    private final List<Job> jobs;

    public JobController(JobExplorer jobExplorer, JobOperator jobOperator, JobRegistry jobRegistry, JobRepository jobRepository, List<Job> jobs) {
        this.jobExplorer = jobExplorer;
        this.jobOperator = jobOperator;
        this.jobRegistry = jobRegistry;
        this.jobRepository = jobRepository;
        this.jobs = jobs;
    }

    @GetMapping("/job-definition")
    public JsonWrapper jobDefinitions(){
        return new JsonWrapper(jobs.size());
    }

    @GetMapping("/job-names")
    public JsonWrapper getJobNames(){
        Collection<String> jobNames = jobRegistry.getJobNames();
        return new JsonWrapper(jobNames);
    }

    @GetMapping("/job-explorer")
    public JsonWrapper getJobNamesWithJobExplorer(){
        Collection<String> jobNames = jobExplorer.getJobNames();
        return new JsonWrapper(jobNames);
    }

    @GetMapping
    public ResponseEntity<List<JobInstance>> getJobInstances(){
        return new ResponseEntity<List<JobInstance>>(jobInstanceService.getJobInstances(), HttpStatus.OK);
    }

    @GetMapping("/xd")
    public ResponseEntity<List<JobInstance>> getJobInstances2(){
        return new ResponseEntity<List<JobInstance>>(jobInstanceService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/launch")
    public ResponseEntity<String> launchJob(){
        return new ResponseEntity<>(jobInstanceService.launchJob(),HttpStatus.OK);
    }

    @PostMapping("/execution/{executionId}/stop")
    public ResponseEntity<String> stopJob(@PathVariable Long executionId){
        return new ResponseEntity<>(jobInstanceService.stopJob(executionId+""),HttpStatus.OK);
    }

    @PostMapping("/execution/{executionId}/restart")
    public ResponseEntity<String> startExecution(@PathVariable Long executionId) throws JobParametersInvalidException, JobRestartException, JobInstanceAlreadyCompleteException, NoSuchJobExecutionException, NoSuchJobException {
        return new ResponseEntity<>(jobInstanceService.restartJob(executionId+""),HttpStatus.OK);
    }
}
