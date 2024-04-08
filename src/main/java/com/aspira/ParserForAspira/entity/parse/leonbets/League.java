package com.aspira.ParserForAspira.entity.parse.leonbets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class League {
    private String id;
    private String name;
    @JsonIgnore
    private String regionName;
    @JsonProperty("top")
    private boolean top;
    @JsonProperty("topOrder")
    private int topOrder;
}
