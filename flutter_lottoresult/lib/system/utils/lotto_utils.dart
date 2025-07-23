import 'package:flutter_lottoresult/system/extensions/tz_datetime_extensions.dart';
import 'package:flutter_lottoresult/system/utils/date_utils.dart';
import 'package:timezone/timezone.dart';

class LottoUtils {
  static final _startDate = DateUtils.getKoreanTimeFromYmd(2002, 12, 7);
  static final _drawHourMin = 2045;

  static bool isBeforeDrawTime(TZDateTime time) {
    return time.hour * 100 + time.minute < _drawHourMin;
  }

  static int getLastDrawNo() {
    final curTime = DateUtils.getKoreanTime();
    final drwNo = DateUtils.weekDiff(_startDate, curTime) + 1;
    if (curTime.weekday != DateTime.saturday || isBeforeDrawTime(curTime)) {
      return drwNo;
    }
    return drwNo - 1;
  }

  static int getMaxDrawNo() {
    final curTime = DateUtils.getKoreanTime();
    final drwNo = DateUtils.weekDiff(_startDate, curTime);
    if (curTime.weekday != DateTime.saturday) {
      return drwNo;
    }
    return drwNo + 1;
  }

  static TZDateTime getDrawDate(int drwNo) {
    return _startDate.weekAdd(drwNo - 1);
  }
}
