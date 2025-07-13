package com.eastgrams.lottoResultTvApp.utils

import com.eastgrams.lottoResultTvApp.utils.CalendarUtils.getKoreaDate
import com.eastgrams.lottoResultTvApp.utils.CalendarUtils.getKoreaDateTime
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import kotlin.random.Random.Default.nextInt

private val DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd")
private val DATE_FORMATTER2 = DateTimeFormatter.ofPattern("yyyyMMdd")
private val START_DATE = LocalDate.of(2002, 12, 7)
private const val DRAW_HOUR_MIN = 2045

fun getDrawNo(): Int {
    return ChronoUnit.WEEKS.between(START_DATE, getKoreaDate()).toInt() + 1
}

fun lastDrawnNo(): Int {
    val drwNo = ChronoUnit.WEEKS.between(START_DATE, getKoreaDate()).toInt() + 1
    if (getKoreaDate().dayOfWeek != DayOfWeek.SATURDAY)
        return drwNo
    if (isBeforeDrawTime()) {
        return drwNo - 1
    }
    return drwNo
}

fun isSaturday(): Boolean {
    return getKoreaDate().dayOfWeek == DayOfWeek.SATURDAY
}

fun isBeforeDrawTime(): Boolean {
    val currentDateTime = getKoreaDateTime()
    return currentDateTime.hour * 100 + currentDateTime.minute <= DRAW_HOUR_MIN
}

fun getMaxDrawNo(): Int {
    val drwNo = ChronoUnit.WEEKS.between(START_DATE, getKoreaDate()).toInt() + 1
    if (getKoreaDate().dayOfWeek != DayOfWeek.SATURDAY)
        return drwNo + 1
    return drwNo
}

fun getDrawDate(drwNo: Int): LocalDate {
    return ChronoUnit.WEEKS.addTo(START_DATE, drwNo.toLong() - 1)
}

fun getDrawDateString(drwNo: Int): String {
    return ChronoUnit.WEEKS.addTo(START_DATE, drwNo.toLong() - 1).format(DATE_FORMATTER)
}

fun getDrawDateInt(drwNo: Int): Int {
    return ChronoUnit.WEEKS.addTo(START_DATE, drwNo.toLong() - 1).format(DATE_FORMATTER2).toInt()
}

fun randomNumbers(): Set<Int> {
    var numbers = mutableSetOf<Int>()
    while (numbers.size < 6) {
        val num = nextInt(from = 1, until = 46)
        if (!numbers.contains(num)) {
            numbers.add(num)
        }
    }
    return numbers
}
