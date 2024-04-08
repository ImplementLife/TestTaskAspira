package com.aspira.ParserForAspira.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LeonBetsSupplier extends ParserSupplier {
    @Override
    public Parser get() {
        RestTemplate restTemplate = context.getBean(RestTemplate.class);
        LeonBetsParser leonBetsParser = new LeonBetsParser();
        leonBetsParser.setRestTemplate(restTemplate);
        return leonBetsParser;
    }
}
