import 'package:flutter_lottoresult/system/timezone/korea_timezone.dart';
import 'package:intl/intl.dart';
import 'package:timezone/timezone.dart';

extension KoreanDateTimeExtension on DateTime {
  TZDateTime toKoreanTime() {
    return TZDateTime.from(toUtc(), KoreanTimeZone().getSeoul());
  }

  String getYYYYMMMDD() {
    return DateFormat('yyyyMMdd').format(this);
  }

  String getDateString() {
    return DateFormat('yyyy-MM-dd').format(this);
  }

  static TZDateTime getKoreanTime() {
    return TZDateTime.from(DateTime.now().toUtc(), KoreanTimeZone().getSeoul());
  }

  static TZDateTime getKoreanTimeFromYmd(int year, int month, int day) {
    return TZDateTime(KoreanTimeZone().getSeoul(), year, month, day, 0, 0, 0);
  }

  DateTime dayAdd(int days) {
    return add(Duration(days: days));
  }

  DateTime weekAdd(int days) {
    return add(Duration(days: days * 7));
  }
}