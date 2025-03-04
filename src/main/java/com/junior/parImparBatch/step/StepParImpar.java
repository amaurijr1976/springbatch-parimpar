package com.junior.parImparBatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

@Configuration
public class StepParImpar {

    @Bean
    public Step parImpar(JobRepository jobRepository, PlatformTransactionManager transationManager){
        return new StepBuilder("parImpar",jobRepository)
                .<Integer,String>chunk(1,transationManager)
                .reader(readerParImpar())
                .processor(processorParImpar())
                .writer(writeParImpar())
                .build();
    }

    public ItemWriter<String> writeParImpar() {
            return itens -> itens.forEach(System.out::println);
    }

    public FunctionItemProcessor<Integer, String> processorParImpar() {
        return  new FunctionItemProcessor<Integer,String>
                (numero -> numero %2 == 0?String.format("Número %s é par",numero):String.format("Número %s é impar",numero));
    }

    public IteratorItemReader<Integer> readerParImpar() {
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        return new IteratorItemReader<Integer>(lista.iterator());
    }
}
