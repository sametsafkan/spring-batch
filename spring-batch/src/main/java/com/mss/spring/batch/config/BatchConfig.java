package com.mss.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;

import com.mss.spring.batch.batchcomponents.BatchItemProcessor;
import com.mss.spring.batch.batchcomponents.BatchItemReader;
import com.mss.spring.batch.batchcomponents.BatchItemWriteListener;
import com.mss.spring.batch.batchcomponents.BatchItemWriter;
import com.mss.spring.batch.batchcomponents.BatchJobCompletionListener;

import components.CompositeData;
import components.Person;

@Configuration
public class BatchConfig {

	@Autowired JobBuilderFactory jobBuilderFactory;
	@Autowired StepBuilderFactory stepBuilderFactory;
	@Autowired JobLauncher jobLauncher;
	@Autowired Job processJob;
	BatchItemReader batchItemReader = new BatchItemReader();
	
	@Scheduled(fixedRate = 5000)
	public void printMessage() {
		try {
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
			jobLauncher.run(processJob, jobParameters);
			System.out.println("I have been scheduled with Spring scheduler");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	public JobExecutionListener listener() {
		return new BatchJobCompletionListener();
	}
	
	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<Person, CompositeData> chunk(10)
				.reader(batchItemReader)
				.processor(new BatchItemProcessor())
				.writer(new BatchItemWriter()).taskExecutor(taskExecutor()).listener(new BatchItemWriteListener()).build();
	}
	
	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob").incrementer(new RunIdIncrementer())
				.start(orderStep1()).listener(listener()).build();
	}
	
	@Bean
	public TaskExecutor taskExecutor() {
		SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor("spring_batch");
		asyncTaskExecutor.setConcurrencyLimit(5);
		return asyncTaskExecutor;
	}
}
