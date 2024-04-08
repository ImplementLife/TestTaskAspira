package com.aspira.ParserForAspira;

import com.aspira.ParserForAspira.service.Orchestrator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class Boot {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Boot.class);
        Orchestrator orchestrator = context.getBean(Orchestrator.class);
        orchestrator.beginGenerateReports();
    }
}
