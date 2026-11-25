package com.wealth.common.job;

import com.wealth.common.logger.KarthiLogger;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.MDC;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;


@Component
public class KarthiJobExecutionListener implements JobExecutionListener {

	private Map<String, Long> jobMap = new ConcurrentHashMap<>();
    private Map<String, Long> jobStartTimeMap = new ConcurrentHashMap<>();
    
	private static final KarthiLogger logger = new KarthiLogger(KarthiJobExecutionListener.class);

	 @Override
	    public void beforeJob(JobExecution jobExecution) {
	        String karthiJobID = jobExecution.getJobParameters().getLong("karthiJobID").toString();
	        MDC.put("karthiJobID", karthiJobID);
	        if (this.jobMap.containsKey(karthiJobID)) {
	            logger.warn("Job already running with KarthiJobID=" + karthiJobID
	                        + " and JobInstanceID=" + jobExecution.getJobInstance().getId());
	        } else {
	            String jobID = jobExecution.getJobParameters().getString("jobID");
	            if (Objects.isNull(jobID)) {
	                logger.warn("Job stopped for KarthiJobID=" + karthiJobID
	                            + " InstanceID=" + jobExecution.getJobInstance().getId());
	            } else {
	                logger.info("=== Starting Job KarthiJobID=" + karthiJobID + " JobInstanceID=" + jobID + " ===");
	                this.jobMap.put(karthiJobID, jobExecution.getJobInstance().getId());
	                this.jobStartTimeMap.put(karthiJobID, System.nanoTime()); // ⏱ record start time
	            }
	        }
	    }
	   @Override
	    public void afterJob(JobExecution jobExecution) {
	        String karthiJobID = jobExecution.getJobParameters().getLong("karthiJobID").toString();
	        if (this.jobMap.containsKey(karthiJobID)) {
	            long karthiJobMapID = this.jobMap.get(karthiJobID);
	            long currKarthiJobExecID = jobExecution.getJobInstance().getId();

	            if (karthiJobMapID == currKarthiJobExecID) {
	                Long startTime = this.jobStartTimeMap.get(karthiJobID);
	                if (startTime != null) {
	                    double durationSec = (System.nanoTime() - startTime) / 1_000_000_000.0;
	                    logger.info("=== End Job KarthiJobID=" + karthiJobID
	                                + " JobInstanceID=" + jobExecution.getJobParameters().getString("jobID")
	                                + " Status=" + jobExecution.getStatus()
	                                + " | Time=" + String.format("%.3f", durationSec) + " sec ===");
	                }

	                this.jobMap.remove(karthiJobID);
	                this.jobStartTimeMap.remove(karthiJobID);
	                MDC.remove("karthiJobID");
	            }
	        }
	    }
	
	  public Map<String, Long> getJobMap() {
	    return this.jobMap;
	  }
}
