package com.aspira.ParserForAspira.dto.report;

import java.util.List;

public interface Market {
    String getName();
    List<? extends Outcome> getRunners();
}
