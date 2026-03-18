package lab01;

import lab01.dto.LogEvent;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LogEngine {

    public List<LogEvent> getErrorsEvents(Path log) throws IOException {

        Stream<LogEvent> events = JsonlLogParser.engine(log);

        return events
                .filter( e -> Objects.equals(e.getLevel(), "ERROR"))
                .toList();

    }
/*
    public static void main( String[] args ) throws IOException {
        Path path = Path.of("log/log_analytics_engine_sample.jsonl");

        List<LogEvent> events = JsonlLogParser.engine(path)
                .toList();
        Stream<LogEvent> event = JsonlLogParser.engine(path);

        Map<String, Long> errorsByLevel = event
                .collect(Collectors.groupingBy(DTO.LogEvent::getLevel, Collectors.counting()));


        errorsByLevel.forEach((level, count) -> {
            System.out.println(level + " -> " + count);
        });


        Map<Integer, Long> errorsByStatusCount = event
                .filter(e -> e.getStatus() >= 400)
                .collect(Collectors.groupingBy(DTO.LogEvent::getStatus, Collectors.counting()));

        errorsByStatusCount.forEach((status, count) -> {
            System.out.println(status + " || " + count);
        });


        Map<String, Double> averageDurationByService = event
                //.filter(e -> e.getDurationMs() > 0)
                .filter(e -> !Objects.equals(e.getLevel(), "ERROR"))
                .collect(Collectors.groupingBy(java.io.whiteking.dto.LogEvent::getService, Collectors.averagingDouble(java.io.whiteking.dto.LogEvent::getDurationMs)));

        averageDurationByService.forEach((service, duration) ->{
            System.out.println("Service: " + service + " Duration: " + duration);
        });
    }*/


}
