package com.aspira.ParserForAspira.service;

import com.aspira.ParserForAspira.entity.report.Report;

import java.util.List;

public interface Parser {
    List<Report> fetchAndGenerateReports(String sport);
}
