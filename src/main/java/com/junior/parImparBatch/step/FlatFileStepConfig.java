package com.junior.parImparBatch.step;

import com.junior.parImparBatch.chunk.reader.ArquivoClienteTransacaoReader;
import com.junior.parImparBatch.dto.ClienteDto;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class FlatFileStepConfig {

    @Bean
    public Step flatFileStep(JobRepository jobRepository,
                             PlatformTransactionManager transationManager,
                             FlatFileItemReader<ClienteDto> flatReaderChunk,
                             ItemWriter<ClienteDto> flatWriterChunk
    ) {
    return new StepBuilder("flatFileStep", jobRepository)
            .<ClienteDto, ClienteDto>chunk(5, transationManager)
            .reader(new ArquivoClienteTransacaoReader(flatReaderChunk))
            .writer(flatWriterChunk)
            .build();
    }
}
