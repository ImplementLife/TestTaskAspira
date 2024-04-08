package com.aspira.ParserForAspira.service;

import com.aspira.ParserForAspira.entity.parse.leonbets.EventFullInfo;
import com.aspira.ParserForAspira.entity.parse.leonbets.Market;
import com.aspira.ParserForAspira.entity.parse.leonbets.Outcome;
import com.aspira.ParserForAspira.entity.report.Report;
import com.aspira.ParserForAspira.entity.report.ReportLeague;

import java.text.SimpleDateFormat;
import java.util.List;

public class ConsoleWriter implements ReportWriter {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss 'UTC'");

    @Override
    public void write(List<Report> reports) {
        StringBuilder builder = new StringBuilder();
        for (Report report : reports) {
            ReportLeague league = report.getReportLeague();

            builder
                .append(report.getSportName())
                .append(", ").append(league.getName())
                .append('\n');
            for (EventFullInfo match : league.getMatches()) {
                builder
                    .append("\t").append(match.getName())
                    .append(", ").append(dateFormat.format(match.getKickoff()))
                    .append(", ").append(match.getId())
                    .append('\n');

                for (Market market : match.getMarkets()) {
                    builder
                        .append("\t\t").append(market.getName())
                        .append('\n');
                    for (Outcome runner : market.getRunners()) {
                        builder
                            .append("\t\t\t").append(runner.getName())
                            .append(", ").append(runner.getPrice())
                            .append(", ").append(runner.getId())
                            .append('\n');
                    }
                }
            }

        }
        System.out.println(builder);
    }
}
