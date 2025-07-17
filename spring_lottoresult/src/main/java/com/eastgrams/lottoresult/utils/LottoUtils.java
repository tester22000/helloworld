package com.eastgrams.lottoresult.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LottoUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATE_FORMATTER2 = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final LocalDate START_DATE = LocalDate.of(2002, 12, 7);
    private static final int DRAW_HOUR_MIN = 2045;

    public static int getDrawNo(){
        return (int)(ChronoUnit.WEEKS.between(START_DATE, DateUtils.getKoreaDate()) + 1);
    }

    public static int getLastDrawnNo() {
        int drwNo = (int) (ChronoUnit.WEEKS.between(START_DATE, DateUtils.getKoreaDate()) + 1);
        if (DateUtils.getKoreaDate().getDayOfWeek() != DayOfWeek.SATURDAY)
            return drwNo;
        if (isBeforeDrawTime()) {
            return drwNo - 1;
        }
        return drwNo;
    }

    public static boolean isSaturday() {
        return DateUtils.getKoreaDate().getDayOfWeek() == DayOfWeek.SATURDAY;
    }

    public static boolean isBeforeDrawTime() {
        LocalDateTime currentDateTime = DateUtils.getKoreaDateTime();
        return currentDateTime.getHour() * 100 + currentDateTime.getMinute() <= DRAW_HOUR_MIN;
    }

    public static int getMaxDrawNo(){
        LocalDateTime currentDateTime = DateUtils.getKoreaDateTime();
        int drwNo = (int)(ChronoUnit.WEEKS.between(START_DATE, currentDateTime) + 1);
        if (currentDateTime.getDayOfWeek() != DayOfWeek.SATURDAY)
            return drwNo + 1;
        return drwNo;
    }

    public static LocalDate getDrawDate(int drwNo) {
        return ChronoUnit.WEEKS.addTo(START_DATE, (long)(drwNo - 1));
    }

    public static String getDrawDateString(int drwNo) {
        return ChronoUnit.WEEKS.addTo(START_DATE, (long)(drwNo - 1)).format(DATE_FORMATTER);
    }

    public static int getDrawDateInt(int drwNo) {
        return Integer.parseInt(ChronoUnit.WEEKS.addTo(START_DATE, (long)(drwNo - 1)).format(DATE_FORMATTER2));
    }
}
