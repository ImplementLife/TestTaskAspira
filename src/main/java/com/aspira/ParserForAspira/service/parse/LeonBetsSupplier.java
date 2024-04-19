package com.aspira.ParserForAspira.service.parse;

import org.springframework.stereotype.Component;

@Component
public class LeonBetsSupplier extends ParserSupplier {
    @Override
    public Parser get() {
        return context.getBean(LeonBetsParser.class);
    }
}
