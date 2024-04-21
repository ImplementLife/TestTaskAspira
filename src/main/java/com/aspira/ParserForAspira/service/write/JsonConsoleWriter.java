package com.aspira.ParserForAspira.service.write;

import com.aspira.ParserForAspira.dto.report.Report;
import com.aspira.ParserForAspira.service.util.Jackson;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class JsonConsoleWriter implements ReportWriter {
    private final Jackson jackson = new Jackson();
    @Override
    public void write(List<Report> report) {
        jackson.enable(SerializationFeature.INDENT_OUTPUT);
        String s = jackson.serializeByInterface(report, Report.class);
        System.out.println(s);
    }
}
