package com.aspira.ParserForAspira.service.write;

import com.aspira.ParserForAspira.entity.report.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportWriter {
    void write(List<Report> report);
}
