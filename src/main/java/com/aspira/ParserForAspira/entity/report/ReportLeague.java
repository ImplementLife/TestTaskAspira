package com.aspira.ParserForAspira.entity.report;

import com.aspira.ParserForAspira.entity.parse.leonbets.EventFullInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportLeague {
    private String name;
    private List<EventFullInfo> matches;
}
