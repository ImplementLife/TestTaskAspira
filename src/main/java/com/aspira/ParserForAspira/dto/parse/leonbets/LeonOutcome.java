package com.aspira.ParserForAspira.dto.parse.leonbets;

import com.aspira.ParserForAspira.dto.report.Outcome;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeonOutcome implements Outcome {
    private long id;
    private String name;
    private double price;
}
