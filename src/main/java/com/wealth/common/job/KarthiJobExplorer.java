package com.wealth.common.job;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.lang.Nullable;

public class KarthiJobExplorer implements JobExplorer {

	@Override
	public List<JobInstance> getJobInstances(String jobName, int start, int count) {
		
		Objects.requireNonNull(jobName, "jobName");
		
		if (start < 0)
			throw new IllegalArgumentException("start: " + start + " must be positive");
		if (count < 0)
			throw new IllegalArgumentException("count: " + start + " must be positive");
		
		return List.of();
	}

	@Nullable
	public JobExecution getJobExecution(Long executionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public StepExecution getStepExecution(Long jobExecutionId, Long stepExecutionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Nullable
	public JobInstance getJobInstance(Long instanceId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<JobExecution> getJobExecutions(JobInstance jobInstance) {
		// TODO Auto-generated method stub
		return List.of();
	}

	@Override
	public Set<JobExecution> findRunningJobExecutions(String jobName) {
		// TODO Auto-generated method stub
		return Set.of();
	}

	@Override
	public List<String> getJobNames() {
		// TODO Auto-generated method stub
		return List.of();
	}

	@Override
	public List<JobInstance> findJobInstancesByJobName(String jobName, int start, int count) {
		
		Objects.requireNonNull(jobName, "jobName");
		
		if (start < 0)
			throw new IllegalArgumentException("start: " + start + " must be positive");
		if (count < 0)
			throw new IllegalArgumentException("count: " + start + " must be positive");
		
		return List.of();
	}

	@Override
	public long getJobInstanceCount(String jobName) throws NoSuchJobException {
		if (jobName == null)
			throw new NoSuchJobException("No job instances for job name null were found");
		return 0L;
	}

	@Nullable
	public JobInstance getJobInstance(String jobName, JobParameters jobParameters) {
		Objects.requireNonNull(jobName, "jobName");
		Objects.requireNonNull(jobParameters, "jobParameters");
		return null;
	}
	
	@Nullable
	public JobInstance getLastJobInstance(String jobName) {
		Objects.requireNonNull(jobName, "jobName");
		return null;
	}
	
	@Nullable
	public JobExecution getLastJobExecution(JobInstance jobInstance) {
		return null;
	}
	
	
}
