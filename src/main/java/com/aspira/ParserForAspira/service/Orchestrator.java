package com.aspira.ParserForAspira.service;

import com.aspira.ParserForAspira.dto.report.Report;
import com.aspira.ParserForAspira.service.parse.Parser;
import com.aspira.ParserForAspira.service.parse.ParserSupplier;
import com.aspira.ParserForAspira.service.write.ReportWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class Orchestrator {
    @Autowired
    private List<ParserSupplier> parserSuppliers;
    @Autowired
    private ReportWriter reportWriter;

    @Value("${threads.count}")
    private int threadsCount;
    @Value("${threads.period}")
    private long threadsPeriod;
    @Value("#{'${sports.filter}'.split(',')}")
    private List<String> sportsFilter;

    private ScheduledExecutorService executor;

    @PostConstruct
    private void postConstruct() {
        executor = Executors.newScheduledThreadPool(threadsCount);
    }

    public void beginGenerateReports() {
        for (String sportName : sportsFilter) {
            for (ParserSupplier parserSupplier : parserSuppliers) {
                executor.scheduleAtFixedRate(() -> {
                    try {
                        Parser parser = parserSupplier.get();
                        String parserName = parser.getClass().getSimpleName();
                        String threadName = Thread.currentThread().getName();
                        System.out.println("Thread " + threadName + ": start " + parserName);
                        List<Report> parseReports = parser.fetchAndGenerateReports(sportName);
                        System.out.println("Thread " + threadName + ": " + parserName + " reporting:");
                        reportWriter.write(parseReports);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }, 0, threadsPeriod, TimeUnit.SECONDS);
            }
        }
    }
}
