package com.eastgrams.lottoResultTvApp.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.TimeZone

object CalendarUtils {
    private val SIMPLE_MMDDHHMMSS_FORMATTER = SimpleDateFormat("yyyyMMddHHmmss")
    private val KOREA_TIME_ZONE: TimeZone = TimeZone.getTimeZone("Asia/Seoul")

    private fun getKoreaZoneId() : ZoneId {
        return KOREA_TIME_ZONE.toZoneId()
    }

    fun getKoreaDate(): LocalDate {
        return LocalDate.now(getKoreaZoneId())
    }

    fun getKoreaDateTime(): LocalDateTime {
        return LocalDateTime.now(getKoreaZoneId())
    }

    fun getKoreaCalendar() : Calendar {
        return GregorianCalendar.from(ZonedDateTime.now(getKoreaZoneId() ))
    }

    fun getKoreaLocalDateTime(calendar: Calendar): LocalDateTime {
        return LocalDateTime.ofInstant(calendar.toInstant(), getKoreaZoneId())
    }

    fun getCalendarFromKoreaLocalDateTime(localDateTime: LocalDateTime) : Calendar {
        return GregorianCalendar.from(ZonedDateTime.of(localDateTime, getKoreaZoneId()))
    }

    fun getYYYYMMDDHHMMSS(calendar: Calendar):String {
        return  SIMPLE_MMDDHHMMSS_FORMATTER.format(calendar.time)
    }
}