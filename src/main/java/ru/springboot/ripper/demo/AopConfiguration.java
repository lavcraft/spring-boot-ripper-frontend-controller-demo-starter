package ru.springboot.ripper.demo;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AlarmProperties.class)
public class AopConfiguration {
    @Bean
    public NotificationlService notificationlService(AlarmProperties ap) {
        return new NotificationlService(ap);
    }
}
