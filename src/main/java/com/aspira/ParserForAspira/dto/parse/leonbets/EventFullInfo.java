package com.aspira.ParserForAspira.dto.parse.leonbets;

import com.aspira.ParserForAspira.dto.report.Match;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventFullInfo implements Match {
    private String id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date kickoff;
    private List<LeonMarket> markets;
}
