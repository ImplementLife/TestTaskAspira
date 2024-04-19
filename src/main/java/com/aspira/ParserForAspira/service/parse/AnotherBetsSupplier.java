package com.aspira.ParserForAspira.service.parse;

import org.springframework.stereotype.Component;

@Component
public class AnotherBetsSupplier extends ParserSupplier {
    @Override
    public Parser get() {
        return context.getBean(AnotherBetsParser.class);
    }
}
