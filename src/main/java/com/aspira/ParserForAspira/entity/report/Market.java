package com.aspira.ParserForAspira.entity.report;

import java.util.List;

public interface Market {
    String getName();
    List<? extends Outcome> getRunners();
}
