package com.wealth.common.job;


import java.time.ZoneId;

import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.ListableJobLocator;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.launch.support.TaskExecutorJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.wealth.common.job"})
@EnableBatchProcessing
@EnableTransactionManagement
public class KarthiJobConfig {

	  @Bean
	  @Primary
	  public PlatformTransactionManager transactionManager() {
	    return new ResourcelessTransactionManager();
	  }
	  
	  @Bean
	  public JobOperator jobOperator(JobRegistry jobRegistry, JobRepository jobRepository, JobLauncher jobLauncher, JobExplorer jobExplorer) {
	    SimpleJobOperator jobOperator = new SimpleJobOperator();
	    jobOperator.setJobExplorer(jobExplorer);
	    jobOperator.setJobLauncher(jobLauncher);
	    jobOperator.setJobRegistry((ListableJobLocator)jobRegistry);
	    jobOperator.setJobRepository(jobRepository);
	    return (JobOperator)jobOperator;
	  }
	  
	  @Bean
	  public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		    threadPoolTaskExecutor.setCorePoolSize(150);
		    threadPoolTaskExecutor.setMaxPoolSize(300);
		    threadPoolTaskExecutor.setQueueCapacity(300);
		    threadPoolTaskExecutor.setThreadNamePrefix("karthi-job-");
		    threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		    threadPoolTaskExecutor.setAwaitTerminationSeconds(30);
		    threadPoolTaskExecutor.initialize();
	    return threadPoolTaskExecutor;
	  }
	  
	  @Bean
	  public JobLauncher jobLauncher(JobRepository jobRepository, ThreadPoolTaskExecutor threadPoolTaskExecutor) throws Exception {
	    TaskExecutorJobLauncher jobLauncher = new TaskExecutorJobLauncher();
	    jobLauncher.setJobRepository(jobRepository);
	    jobLauncher.setTaskExecutor((TaskExecutor)threadPoolTaskExecutor);
	    jobLauncher.afterPropertiesSet();
	    return (JobLauncher)jobLauncher;
	  }
	  
	  @Bean
	  public JobRegistry jobRegistry() {
	    return (JobRegistry)new MapJobRegistry();
	  }
	  
	  @Bean
	  public JobExplorer jobExplorer() {
	    return new KarthiJobExplorer();
	  }
	  
	  @Bean
	  public JobRepository jobRepository(@Value("${karthi.time-zone:Asia/Kolkata}") String timeZone) {
	    return new KarthiJobRepository(ZoneId.of(timeZone));
	  }
}
