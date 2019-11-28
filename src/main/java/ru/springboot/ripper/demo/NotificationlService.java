package ru.springboot.ripper.demo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NotificationlService {
    private final AlarmProperties alarmProperties;

    public void sendEmail() {
        System.out.println("Send email to "+ alarmProperties.getEmail());
    }
}
