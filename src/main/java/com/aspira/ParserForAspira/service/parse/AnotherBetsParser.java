package com.aspira.ParserForAspira.service.parse;

import com.aspira.ParserForAspira.entity.report.Report;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class AnotherBetsParser implements Parser {
    @Override
    public List<Report> fetchAndGenerateReports(String sport) {
        return Collections.emptyList();
    }
}
