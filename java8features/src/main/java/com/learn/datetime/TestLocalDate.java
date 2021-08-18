package com.learn.datetime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestLocalDate {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        //Get info about the LocalDate
        System.out.println(today);
        System.out.println(today.getDayOfYear());
        System.out.println(today.getYear());
        System.out.println(today.isLeapYear());

        LocalDate tomorrow = LocalDate.of(2021, Month.MAY, 5);

        String dateOfJoining = "01/01/2000";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MM/yyyy][dd-MM-yyyy]");

        LocalDate joinDate = LocalDate.parse(dateOfJoining, formatter);
        System.out.println(joinDate.getYear());

        //Operations on Date
        LocalDate previousDate = today.plusDays(11).plus(2, ChronoUnit.MONTHS).minusYears(3);
        System.out.println(previousDate);
        System.out.println(previousDate.getDayOfWeek());
        LocalDate localDate2025 = today.withYear(2025);

        //Formatting Dates
        String formattedDate = previousDate.format(DateTimeFormatter.ofPattern("dd MMMM, yyyy"));
        System.out.println(formattedDate);


        //Period
        Period oneYearTwoMonthsFiveDays = Period.of(1,2,5);
        LocalDate addedPeriodDate = today.plus(oneYearTwoMonthsFiveDays);
        System.out.println(addedPeriodDate);


        Period experience = Period.between(joinDate, today);
        System.out.println(experience);
        System.out.println(experience.getYears()  + " " + experience.getMonths());

        long monthsBetweenTwoDates = ChronoUnit.MONTHS.between(joinDate, today);
        System.out.println(monthsBetweenTwoDates);

        LocalDate lastDate = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(lastDate);

        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(nextMonday);


        List<LocalDate> nextTenDays = Stream
                .iterate(LocalDate.now(), date -> date.plusDays(1))
                .limit(10)
                .collect(Collectors.toList());

        System.out.println(nextTenDays);

        LocalDate tempDate = today;
        while(tempDate.isBefore(LocalDate.of(2021, 05,25))){
            tempDate =tempDate.plusDays(1);
            System.out.println(tempDate);
        }
    }
}
