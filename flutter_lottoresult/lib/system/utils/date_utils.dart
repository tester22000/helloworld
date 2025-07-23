import 'package:flutter_lottoresult/system/extensions/datetime_extensions.dart';
import 'package:timezone/timezone.dart';


class DateUtils {
  static TZDateTime getKoreanTime() {
    return KoreanDateTimeExtension.getKoreanTime();
  }

  static TZDateTime toKoreanTime(DateTime time) {
    return time.toKoreanTime();
  }

  static TZDateTime getKoreanTimeFromYmd(int year, int month, int day) {
    return KoreanDateTimeExtension.getKoreanTimeFromYmd(year, month, day);
  }

  static String getYYYYMMDD(DateTime date) {
    return date.getYYYYMMMDD();
  }

  static String getDateString(DateTime date) {
    return date.getDateString();
  }

  static DateTime dayAdd(DateTime date, int days) {
    return date.dayAdd(days);
  }

  static DateTime weekAdd(DateTime date, int weeks) {
    return date.weekAdd(weeks);
  }

  static int dayDiff(DateTime date1, DateTime date2) {
    if (date1.isAfter(date2)) {
      return date1.difference(date2).inDays;
    } else {
      return date2.difference(date1).inDays;
    }
  }

  static int weekDiff(DateTime date1, DateTime date2) {
    final days = dayDiff(date1, date2);
    return (days / 7).toInt();
  }
}
