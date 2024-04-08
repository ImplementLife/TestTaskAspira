package com.aspira.ParserForAspira.service;

import org.springframework.stereotype.Component;

@Component
public class AnotherBetsSupplier extends ParserSupplier {
    @Override
    public Parser get() {
        return new AnotherBetsParser();
    }
}
