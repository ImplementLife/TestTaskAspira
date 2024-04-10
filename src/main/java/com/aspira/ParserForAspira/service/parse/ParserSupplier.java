package com.aspira.ParserForAspira.service.parse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.function.Supplier;

public abstract class ParserSupplier implements Supplier<Parser> {
    @Autowired
    protected ApplicationContext context;
}
