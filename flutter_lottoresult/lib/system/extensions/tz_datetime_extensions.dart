
import 'package:intl/intl.dart';
import 'package:timezone/timezone.dart';

extension TZDateFormatExtension on TZDateTime {
  String getYYYYMMMDD() {
    return DateFormat('yyyyMMdd').format(this);
  }

  String getDateString() {
    return DateFormat('yyyy-MM-dd').format(this);
  }

  TZDateTime dayAdd(int days) {
    return add(Duration(days: days));
  }

  TZDateTime weekAdd(int days) {
    return add(Duration(days: days * 7));
  }
}