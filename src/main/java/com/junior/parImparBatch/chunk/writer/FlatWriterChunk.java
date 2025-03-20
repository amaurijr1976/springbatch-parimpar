package com.junior.parImparBatch.chunk.writer;

import com.junior.parImparBatch.dto.ClienteDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Log4j2
@Configuration
public class FlatWriterChunk {

//    @Bean
//    public ItemWriter writeFlatFile() throws Exception{
//        return clientes -> {
//            clientes.forEach(clienteDto -> {
//                if (clienteDto.getNome().equals("Maria")) {
////                    throw new IllegalArgumentException("Invalid client name: maria");
//                    System.out.println(clienteDto.getNome());
//                } else
//                    System.out.println(clienteDto.getNome());
//
//            });
//        };
//    }

    @Bean
    public ItemWriter writeFlatFile() {
        return clientes -> clientes.forEach(System.out::println);
    }

}
