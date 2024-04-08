package com.aspira.ParserForAspira.entity.parse.leonbets;

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
public class EventFullInfo {
    private String id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Date kickoff;
    private List<Market> markets;
}
