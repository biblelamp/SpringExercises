package cz.javageek.news.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

@ConfigurationProperties(prefix = "web-reader")
public class WebReaderConfig {

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration interval = Duration.ofSeconds(60);

    private List<String> channels = List.of();

    private WebReaderConfig() {
    }

    public static WebReaderConfig createWebReaderConfig() {
        return new WebReaderConfig();
    }

    public Duration getInterval() {
        return interval;
    }

    public void setInterval(Duration interval) {
        this.interval = interval;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
}
