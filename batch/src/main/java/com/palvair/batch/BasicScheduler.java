package com.palvair.batch;

import lombok.extern.log4j.Log4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ruddy on 06/07/15.
 */
@Log4j
public class BasicScheduler {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    public void run() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        log.info("run");
        jobLauncher.run(job, new JobParametersBuilder().toJobParameters());
    }
}
