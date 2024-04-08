package com.aspira.ParserForAspira.service;

import com.aspira.ParserForAspira.entity.report.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportWriter {
    void write(List<Report> report);
}
