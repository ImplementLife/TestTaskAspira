package com.aspira.ParserForAspira.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private String sportName;
    private String leagueName;
    private List<? extends Match> matches;
}
