package com.example.rest;

import com.example.rest.services.JobInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedTask {

    private final long SEGUNDO = 1000;
    private final long MINUTO = SEGUNDO * 60 * 30;
    private final long HORA = MINUTO * 60;

    @Autowired
    private JobInstanceService jobInstanceService;

    Logger LOG = LoggerFactory.getLogger(SchedTask.class);

    @Scheduled(fixedRate = MINUTO)
    public void helloWorld(){
        LOG.info("Hello world");
        jobInstanceService.launchJob();
    }

}
