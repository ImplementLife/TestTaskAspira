package com.aspira.ParserForAspira.entity.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String sportName;
    private ReportLeague reportLeague;
}
