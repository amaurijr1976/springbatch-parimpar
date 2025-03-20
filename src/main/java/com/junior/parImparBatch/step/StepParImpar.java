package com.junior.parImparBatch.step;

import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;

@Log4j2
//@Configuration
public class StepParImpar {

//    //@Bean
//    public Step parImpar(JobRepository jobRepository, PlatformTransactionManager transationManager){
//        return new StepBuilder("parImpar",jobRepository)
//                .<Integer,String>chunk(1,transationManager)
//                .reader(readerParImpar())
//                .processor(processorParImpar())
//                .writer(writeParImpar())
//                .build();
//    }
//
//    public ItemWriter<String> writeParImpar() {
//            log.info("Escrevendo os números");
//            return itens -> itens.forEach(System.out::println);
//    }
//
//    public FunctionItemProcessor<Integer, String> processorParImpar() {
//        log.info("Processando os números");
//        return  new FunctionItemProcessor<Integer,String>
//                (numero -> numero %2 == 0?String.format("Número %s é par",numero):String.format("Número %s é impar",numero));
//    }
//
//    public IteratorItemReader<Integer> readerParImpar() {
//        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        return new IteratorItemReader<Integer>(lista.iterator());
//    }
}
