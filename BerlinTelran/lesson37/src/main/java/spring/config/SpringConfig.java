package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Configuration
@EnableScheduling
public class SpringConfig {

    @Scheduled(cron = "0 51 19 * * ?")
    public void scheduleFixedDelayTask() throws InterruptedException {
        System.out.println("schedule tasks using cron jobs - " + new Date());
    }
}
