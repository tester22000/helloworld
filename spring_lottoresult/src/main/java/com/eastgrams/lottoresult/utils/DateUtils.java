package com.eastgrams.lottoresult.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateUtils {

    private static SimpleDateFormat SIMPLE_MMDDHHMMSS_FORMATTER = new SimpleDateFormat("yyyyMMddHHmmss");

    private static TimeZone KOREA_TIME_ZONE = TimeZone.getTimeZone("Asia/Seoul");

    private static ZoneId getKoreaZoneId()  {
        return KOREA_TIME_ZONE.toZoneId();
    }

    public static LocalDate getKoreaDate() {
        return LocalDate.now(getKoreaZoneId());
    }

    public static LocalDateTime getKoreaDateTime() {
        return LocalDateTime.now(getKoreaZoneId());
    }

    public static Calendar getKoreaCalendar() {
        return GregorianCalendar.from(ZonedDateTime.now(getKoreaZoneId() ));
    }

    public static LocalDateTime getKoreaLocalDateTime(Calendar calendar) {
        return LocalDateTime.ofInstant(calendar.toInstant(), getKoreaZoneId());
    }

    public static Calendar getCalendarFromKoreaLocalDateTime(LocalDateTime localDateTime)  {
        return GregorianCalendar.from(ZonedDateTime.of(localDateTime, getKoreaZoneId()));
    }

    public static String getYYYYMMDDHHMMSS(Calendar calendar){
        return  SIMPLE_MMDDHHMMSS_FORMATTER.format(calendar.getTime());
    }

}
