package com.aspira.ParserForAspira.config;

import com.aspira.ParserForAspira.service.ConsoleWriter;
import com.aspira.ParserForAspira.service.ReportWriter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class SpringBeanConfig {
    @Value("${connection.timeout}")
    long connectionTimeout;
    @Value("${read.timeout}")
    long readTimeout;

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public RestTemplate getRestTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder
            .setConnectTimeout(Duration.ofMillis(connectionTimeout))
            .setReadTimeout(Duration.ofMillis(readTimeout))
            .build();
    }

    @Bean
    public ReportWriter getOut() {
        return new ConsoleWriter();
    }
}
