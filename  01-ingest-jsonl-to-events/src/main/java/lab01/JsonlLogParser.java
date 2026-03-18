package lab01;

import com.fasterxml.jackson.databind.ObjectMapper;
import lab01.dto.LogEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class JsonlLogParser {
    private static ObjectMapper mapper = new ObjectMapper();


    public static LogEvent parse(String line){
        try {
            return mapper.readValue(line, LogEvent.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public static Stream<LogEvent> engine(Path path) throws IOException {
        return Files.lines(path).filter(line -> !line.isEmpty())
                .map(JsonlLogParser::parse);
    }
}
