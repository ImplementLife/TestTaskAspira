package com.aspira.ParserForAspira.entity.report;

import java.util.Date;
import java.util.List;

public interface Match {
    String getId();
    String getName();
    Date getKickoff();
    List<? extends Market> getMarkets();
}
