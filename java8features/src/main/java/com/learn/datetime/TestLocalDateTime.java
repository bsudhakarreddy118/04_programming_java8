package com.learn.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TestLocalDateTime {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime todayNow = LocalDateTime.now();
        System.out.println(todayNow);

        Duration duration = Duration.ofMinutes(120);
        LocalTime afterfiveHours = now.plus(duration);
        System.out.println(afterfiveHours);

//        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
        ZonedDateTime tokyoNow = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println(tokyoNow);

    }
}
