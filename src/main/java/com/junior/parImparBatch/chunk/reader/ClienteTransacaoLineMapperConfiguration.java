package com.junior.parImparBatch.chunk.reader;

import com.junior.parImparBatch.dto.ClienteDto;
import com.junior.parImparBatch.dto.TransacaoDto;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ClienteTransacaoLineMapperConfiguration {

    @Bean
    public PatternMatchingCompositeLineMapper lineMapper() {
        PatternMatchingCompositeLineMapper lineMapper = new PatternMatchingCompositeLineMapper();
        lineMapper.setTokenizers(tokenizers());
        lineMapper.setFieldSetMappers(fieldSetMappers());
        return lineMapper;
    }

    private Map<String, FieldSetMapper> fieldSetMappers() {
        Map<String, FieldSetMapper> fieldSetMappers = Map.of(
                "0*", fieldSetMapper(ClienteDto.class),
                "1*", fieldSetMapper(TransacaoDto.class)
        );
        return fieldSetMappers;
    }

    private FieldSetMapper fieldSetMapper(Class classe) {
        BeanWrapperFieldSetMapper fieldSetMapper = new BeanWrapperFieldSetMapper();
        fieldSetMapper.setTargetType(classe);
        return fieldSetMapper;
    }

    private Map<String, LineTokenizer> tokenizers() {
        return Map.of(
                "0*", clienteLineTokenizer(),
                "1*", transacaoLineTokenizer()
        );
    }

    private LineTokenizer transacaoLineTokenizer() {
       return new DelimitedLineTokenizer() {{
            setNames("id", "descricao", "valor");
            setDelimiter(";");
            setIncludedFields(1, 2, 3);
        }};
    }

    private LineTokenizer clienteLineTokenizer() {
        return new DelimitedLineTokenizer() {{
            setNames("nome", "sobrenome", "idade", "email");
            setDelimiter(";");
            setIncludedFields(1, 2, 3, 4);
        }};
    }
}
