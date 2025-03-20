package com.junior.parImparBatch.chunk.reader;

import com.junior.parImparBatch.dto.ClienteDto;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;

@Configuration
public class FlatReaderChunk {

    @Value("${app.file}")
    private String arquivoClientes;

    @Value("${app.fileMultiplosRegistros}")
    private String arquivoClientesMultiplosRegistros;

    //@StepScope
// Leitura usando Arequivo Flat com delimitador ou tamanho fixo de campos
//    @Bean
    public FlatFileItemReader<ClienteDto> readerFlatFile() {
        return (FlatFileItemReader<ClienteDto>)new FlatFileItemReaderBuilder<ClienteDto>()
                .name("readerFlatFile")
                .resource(new PathResource(arquivoClientes))
                //.fixedLength()
                //.columns(new Range[]{new Range(1, 10), new Range(11, 20), new Range(21, 23), new Range(24, 43)})
                .delimited()
                .delimiter(";")
                .names("nome", "sobrenome", "idade", "email")
                .targetType(ClienteDto.class)
                .build();
    }


    @Bean //injetando bean
    public FlatFileItemReader readerFlatFileMultiplosTiposRegistros(LineMapper lineMapper) {
        return  new FlatFileItemReaderBuilder<ClienteDto>()
                .name("readerFlatFileMultiplosTiposRegistros")
                .resource(new PathResource(arquivoClientesMultiplosRegistros))
                .lineMapper(lineMapper)
                .build();
    }

}
