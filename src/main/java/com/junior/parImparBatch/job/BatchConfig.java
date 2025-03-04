package com.junior.parImparBatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfig {
    
    @Bean
    public Job  jobParImpar(JobRepository jobRepository,
                            PlatformTransactionManager transationManager,
                            Step stepParImpar){
        return new JobBuilder("jobParImpar",jobRepository)
                .start(stepParImpar)
                .incrementer(new RunIdIncrementer())
                .build();
    }
        
    
}
