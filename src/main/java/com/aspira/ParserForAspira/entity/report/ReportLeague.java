package com.aspira.ParserForAspira.entity.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportLeague {
    private String name;
    private List<? extends Match> matches;
}
