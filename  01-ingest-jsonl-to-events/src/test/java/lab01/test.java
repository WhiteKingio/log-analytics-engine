package lab01;

import lab01.dto.LogEvent;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
public class test {

@Test
    public void test() throws IOException {

        LogEngine logEngine = new LogEngine();

        List<LogEvent> erros =  logEngine.getErrorsEvents(Path.of("log/log_analytics_engine_sample.jsonl"));

        erros.forEach(e -> {
            System.out.println(e.getService());
        });

    }
}
