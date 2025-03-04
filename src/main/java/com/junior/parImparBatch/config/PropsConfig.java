package com.junior.parImparBatch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class PropsConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer configExternalProperties(){
        PropertySourcesPlaceholderConfigurer configPlaceHolder = new PropertySourcesPlaceholderConfigurer();
        configPlaceHolder.setLocation(new FileSystemResource("D:\\Junior\\desenvolvimento\\git_local\\estudo_SpringBatch\\BatchParImpar\\configExternal\\application.yml"));
        return configPlaceHolder;
    }

}
