package com.wealth.common.job;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.lang.Nullable;

import com.wealth.common.logger.GrowxLogger;

public class GrowXJobRepository implements JobRepository {
	
	private static final GrowxLogger logger = new GrowxLogger(GrowXJobRepository.class);
	
	private static final AtomicLong JOB_INSTANCE_ID = new AtomicLong();

	private static final AtomicLong JOB_EXECUTION_ID = new AtomicLong();

	private static final AtomicLong STEP_EXECUTION_ID = new AtomicLong();

	private final ZoneId defaultZone;

	public GrowXJobRepository(ZoneId defaultZone) {
		this.defaultZone = Objects.requireNonNull(defaultZone, "defaultZone");
	}

	@Override
	public boolean isJobInstanceExists(String jobName, JobParameters jobParameters) {
		
		Objects.requireNonNull(jobName, "jobName");
	    Objects.requireNonNull(jobParameters, "jobParameters");
	    
		return false;
	}

	@Override
	public JobInstance createJobInstance(String jobName, JobParameters jobParameters) {
		
		Objects.requireNonNull(jobName, "jobName");
	    Objects.requireNonNull(jobParameters, "jobParameters");
	    
	    JobInstance jobInstance = new JobInstance(Long.valueOf(JOB_INSTANCE_ID.incrementAndGet()), jobName);
	    jobInstance.incrementVersion();
	    
	    return jobInstance;
	}

	@Override
	public JobExecution createJobExecution(String jobName, JobParameters jobParameters) {
		
		Objects.requireNonNull(jobName, "jobName");
		Objects.requireNonNull(jobParameters, "jobParameters");
		
		JobInstance jobInstance = new JobInstance(Long.valueOf(JOB_INSTANCE_ID.incrementAndGet()), jobName);
		jobInstance.incrementVersion();
		JobExecution jobExecution = new JobExecution(jobInstance, Long.valueOf(JOB_EXECUTION_ID.incrementAndGet()),
				jobParameters);
		
		jobExecution.incrementVersion();
		jobExecution.setLastUpdated(LocalDateTime.now(defaultZone));
		
		return jobExecution;
	}

	@Override
	public void update(JobExecution jobExecution) {
		
		Objects.requireNonNull(jobExecution, "jobExecution");
		Objects.requireNonNull(jobExecution.getJobId(), "jobExecution.getJobId()");
		Objects.requireNonNull(jobExecution.getId(), "jobExecution.getId()");
		
		jobExecution.setLastUpdated(LocalDateTime.now(defaultZone));
		jobExecution.incrementVersion();
	}

	@Override
	public void add(StepExecution stepExecution) {
		
		validateStepExecution(stepExecution);
		
		stepExecution.setId(Long.valueOf(STEP_EXECUTION_ID.incrementAndGet()));
		stepExecution.setLastUpdated(LocalDateTime.now(defaultZone));
		stepExecution.incrementVersion();
		
		checkForInterruption(stepExecution);
	}

	@Override
	public void addAll(Collection<StepExecution> stepExecutions) {
		for (StepExecution stepExecution : stepExecutions)
			add(stepExecution);
	}

	@Override
	public void update(StepExecution stepExecution) {
		
		validateStepExecution(stepExecution);
		
		Objects.requireNonNull(stepExecution.getId(), "StepExecution must already be saved (have an id assigned)");
		stepExecution.setLastUpdated(LocalDateTime.now(defaultZone));
		stepExecution.incrementVersion();
		
		checkForInterruption(stepExecution);
	}

	private void checkForInterruption(StepExecution stepExecution) {
		
		JobExecution jobExecution = stepExecution.getJobExecution();
		
		if (jobExecution.isStopping()) {
			logger.info("Parent JobExecution " + jobExecution.getId()
					+ " is stopped, so passing message on to StepExecution " + stepExecution.getId());
			stepExecution.setTerminateOnly();
		}
	}
	
	@Override
	public void updateExecutionContext(StepExecution stepExecution) {
		// TODO Auto-generated method stub
		validateStepExecution(stepExecution);
	}
	
	private static void validateStepExecution(StepExecution stepExecution) {
		
		Objects.requireNonNull(stepExecution, "StepExecution cannot be null.");
		Objects.requireNonNull(stepExecution.getStepName(), "StepExecution's step name cannot be null.");
		Objects.requireNonNull(stepExecution.getJobExecutionId(), "StepExecution must belong to persisted JobExecution");
	}

	@Override
	public void updateExecutionContext(JobExecution jobExecution) {
		
	}

	@Override
	public long getStepExecutionCount(JobInstance jobInstance, String stepName) {
		return 0L;
	}
	
	@Nullable
	public StepExecution getLastStepExecution(JobInstance jobInstance, String stepName) {
		return null;
	}

	@Nullable
	public JobExecution getLastJobExecution(String jobName, JobParameters jobParameters) {
		return null;
	}
	
	public List<String> getJobNames() {
		return List.of();
	}
	
	public List<JobExecution> findJobExecutions(JobInstance jobInstance) {
		Objects.requireNonNull(jobInstance, "jobInstance");
		return List.of();
	}

	@Nullable
	public JobInstance getJobInstance(String jobName, JobParameters jobParameters) {
		
		Objects.requireNonNull(jobName, "jobName");
		Objects.requireNonNull(jobParameters, "jobParameters");
		return null;
	}

	public void deleteStepExecution(StepExecution stepExecution) {
		
		Objects.requireNonNull(stepExecution, "stepExecution");
	}

	public void deleteJobExecution(JobExecution jobExecution) {
		
		Objects.requireNonNull(jobExecution, "jobExecution");
	}

	public void deleteJobInstance(JobInstance jobInstance) {
		
		Objects.requireNonNull(jobInstance, "jobInstance");
	}

}
