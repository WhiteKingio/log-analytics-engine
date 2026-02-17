package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.JsonlLogParser;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogEngine {

    public static void main( String[] args ) throws IOException {
        Path path = Path.of("log/log_analytics_engine_sample.jsonl");

        Stream<DTO.LogEvent> event = JsonlLogParser.engine(path);

        Map<String, Long> errorsByLevel = event
                .collect(Collectors.groupingBy(DTO.LogEvent::getLevel, Collectors.counting()));

        errorsByLevel.forEach((level, count) -> {
            System.out.println(level + " -> " + count);
        });

    }
}
