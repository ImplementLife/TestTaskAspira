package com.aspira.ParserForAspira.dto.parse.leonbets;

import com.aspira.ParserForAspira.dto.report.Market;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeonMarket implements Market {
    private String name;
    private List<LeonOutcome> runners;
}
