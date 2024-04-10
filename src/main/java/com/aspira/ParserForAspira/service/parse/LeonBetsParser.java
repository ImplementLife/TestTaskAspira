package com.aspira.ParserForAspira.service.parse;

import com.aspira.ParserForAspira.entity.parse.leonbets.*;
import com.aspira.ParserForAspira.entity.report.Report;
import com.aspira.ParserForAspira.entity.report.ReportLeague;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class LeonBetsParser implements Parser {
    private final String BASE_URL = "https://leonbets.com/";
    private final String ALL_LEAGUES_URL = "api-2/betline/sports";
    private final String LEAGUE_EVENTS_URL = "api-2/betline/events/all";
    private final String EVENT_URL = "api-2/betline/event/all";


    private RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();


    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Report> fetchAndGenerateReports(String sportName) {
        List<League> leaguesBySport = parseAllLeaguesAndFilter(fetchAllSports(), sportName);

        List<Report> reports = leaguesBySport.stream()
            .map(league -> {
                Report report = new Report();
                report.setSportName(sportName);
                ReportLeague reportLeague = new ReportLeague();
                reportLeague.setName(league.getName());

                List<EventListInfo> eventsListInfo = parseMatchesInLeagueInfo(fetchMatchesInLeagueInfo(league.getId()));
                List<EventFullInfo> matches = eventsListInfo.stream()
                    .map(eventListInfo -> parseMatchInfo(fetchMatchInfo(eventListInfo.getId())))
                    .toList();
                reportLeague.setMatches(matches);

                report.setReportLeague(reportLeague);
                return report;
            })
            .collect(Collectors.toList());

        return reports;
    }

    private String fetchMatchInfo(String eventId) {
        Map<String, String> params = new HashMap<>();
        params.put("ctag", "en-US");
        params.put("eventId", eventId);
        params.put("flags", "reg,urlv2,mm2,rrc,nodup,smg,outv2");

        String url = appendParamsToUrl(BASE_URL + EVENT_URL, params);

        return restTemplate.getForObject(url, String.class, params);
    }
    private EventFullInfo parseMatchInfo(String json) {
        try {
            return objectMapper.readValue(json, EventFullInfo.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String fetchMatchesInLeagueInfo(String league_id) {
        Map<String, String> params = new HashMap<>();
        params.put("ctag", "en-US");
        params.put("league_id", league_id);
        params.put("hideClosed", "true");
        params.put("flags", "reg,urlv2,mm2,rrc,nodup");

        String url = appendParamsToUrl(BASE_URL + LEAGUE_EVENTS_URL, params);

        return restTemplate.getForObject(url, String.class, params);
    }
    private List<EventListInfo> parseMatchesInLeagueInfo(String jsonLeague) {
        try {
            LeagueEvents eventsInfo = objectMapper.readValue(jsonLeague, LeagueEvents.class);
            List<EventListInfo> events = eventsInfo.getEvents();
            if (events.size() > 1) {
                EventListInfo firstElement = events.get(0);
                events.clear();
                events.add(firstElement);
            }
            return events;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String fetchAllSports() {
        Map<String, String> params = new HashMap<>();
        params.put("ctag", "en-US");
        params.put("flags", "urlv2");

        String url = appendParamsToUrl(BASE_URL + ALL_LEAGUES_URL, params);

        return restTemplate.getForObject(url, String.class);
    }
    private List<League> parseAllLeaguesAndFilter(String jsonAllSports, String sportName) {
        try {
            Sport[] sportsFromJson = objectMapper.readValue(jsonAllSports, Sport[].class);

            List<League> leagues = Arrays.stream(sportsFromJson)
                .filter(sport -> sportName.equals(sport.getName()))
                .flatMap(sport -> sport.getRegions().stream())
                .peek(region -> {
                    region.getLeagues().forEach(league -> {
                        league.setRegionName(region.getName());
                    });
                })
                .flatMap(region -> region.getLeagues().stream())
                .filter(League::isTop)
                .sorted(Comparator.comparingInt(League::getTopOrder))
                .collect(Collectors.toList());

            return leagues;
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private String appendParamsToUrl(String baseUrl, Map<String, String> params) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl);
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.queryParam(entry.getKey(), entry.getValue());
        }
        return builder.toUriString();
    }
}
