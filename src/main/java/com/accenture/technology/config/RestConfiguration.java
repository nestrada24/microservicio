package com.accenture.technology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * Genera un bean de Interfaz de RestOperation
 * @author nestrada
 *
 */
@Configuration
public class RestConfiguration {

    @Bean
    public RestOperations restOperations (){
        return new RestTemplate();
    }
   
 
}