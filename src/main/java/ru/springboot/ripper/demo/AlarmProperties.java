package ru.springboot.ripper.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("alarm")
public class AlarmProperties {
    private String email;
}
