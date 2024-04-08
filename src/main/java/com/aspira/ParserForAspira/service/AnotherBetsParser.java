package com.aspira.ParserForAspira.service;

import com.aspira.ParserForAspira.entity.report.Report;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AnotherBetsParser implements Parser {
    @Override
    public List<Report> fetchAndGenerateReports(String sport) {
        return Collections.emptyList();
    }
}
