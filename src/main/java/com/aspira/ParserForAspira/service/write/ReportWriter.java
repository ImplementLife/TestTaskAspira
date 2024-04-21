package com.aspira.ParserForAspira.service.write;

import com.aspira.ParserForAspira.dto.report.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportWriter {
    void write(List<Report> report);
}
