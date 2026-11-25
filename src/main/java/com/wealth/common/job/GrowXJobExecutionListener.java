package com.wealth.common.job;

import com.wealth.common.logger.DoczLogger;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.MDC;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import com.wealth.common.utils.generic.RequestHeaderUtil;


@Component
public class GrowXJobExecutionListener implements JobExecutionListener {

	private Map<String, Long> jobMap = new ConcurrentHashMap<>();
    private Map<String, Long> jobStartTimeMap = new ConcurrentHashMap<>();
    
	private static final DoczLogger logger = new DoczLogger(GrowXJobExecutionListener.class);

	 @Override
	    public void beforeJob(JobExecution jobExecution) {
	        String growXJobID = jobExecution.getJobParameters().getLong("growXJobID").toString();
	        MDC.put("growXJobID", growXJobID);
			RequestHeaderUtil.setScope("job");
			RequestHeaderUtil.setPublic(true);
	        if (this.jobMap.containsKey(growXJobID)) {
	            logger.warn("Job already running with GrowXJobID=" + growXJobID
	                        + " and JobInstanceID=" + jobExecution.getJobInstance().getId());
	        } else {
	            String jobID = jobExecution.getJobParameters().getString("jobID");
	            if (Objects.isNull(jobID)) {
	                logger.warn("Job stopped for GrowXJobID=" + growXJobID
	                            + " InstanceID=" + jobExecution.getJobInstance().getId());
	            } else {
	                logger.info("=== Starting Job GrowXJobID=" + growXJobID + " JobInstanceID=" + jobID + " ===");
	                this.jobMap.put(growXJobID, jobExecution.getJobInstance().getId());
	                this.jobStartTimeMap.put(growXJobID, System.nanoTime()); // ⏱ record start time
	            }
	        }
	    }
	   @Override
	    public void afterJob(JobExecution jobExecution) {
	        String growXJobID = jobExecution.getJobParameters().getLong("growXJobID").toString();
			RequestHeaderUtil.clear();
	        if (this.jobMap.containsKey(growXJobID)) {
	            long growXJobMapID = this.jobMap.get(growXJobID);
	            long currGrowXJobExecID = jobExecution.getJobInstance().getId();

	            if (growXJobMapID == currGrowXJobExecID) {
	                Long startTime = this.jobStartTimeMap.get(growXJobID);
	                if (startTime != null) {
	                    double durationSec = (System.nanoTime() - startTime) / 1_000_000_000.0;
	                    logger.info("=== End Job GrowXJobID=" + growXJobID
	                                + " JobInstanceID=" + jobExecution.getJobParameters().getString("jobID")
	                                + " Status=" + jobExecution.getStatus()
	                                + " | Time=" + String.format("%.3f", durationSec) + " sec ===");
	                }

	                this.jobMap.remove(growXJobID);
	                this.jobStartTimeMap.remove(growXJobID);
	                MDC.remove("growXJobID");
	            }
	        }
	    }
	
	  public Map<String, Long> getJobMap() {
	    return this.jobMap;
	  }
}
