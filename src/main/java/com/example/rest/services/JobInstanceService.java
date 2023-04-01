package com.example.rest.services;


import com.example.rest.models.JobInstance;
import com.example.rest.repositories.JobInstanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class JobInstanceService {

    @Autowired
    private JobInstanceRepository jobInstanceRepository;

    public List<JobInstance> getJobInstances() {
        return jobInstanceRepository.findAll();
    }
    public List<JobInstance> getAll(){
        return jobInstanceRepository.findJobName();
    }

    public String launchJob() {
        RestTemplate rt = new RestTemplate();
        String res = rt.postForObject("http://localhost:8080/batch/job/launch-job", null, String.class);
        System.out.println(res);
        return res;
    }

    public String stopJob(String idExecution) {
        RestTemplate rt = new RestTemplate();
        String res = rt.postForObject("http://localhost:8080/batch/execution/"+idExecution+"/stop", null, String.class);
        System.out.println(res);
        return res;
    }

    public String restartJob(String idExecution) {
        RestTemplate rt = new RestTemplate();
        String res = rt.postForObject("http://localhost:8080/batch/execution/"+idExecution+"/restart", null, String.class);
        System.out.println(res);
        return res;
    }



}
