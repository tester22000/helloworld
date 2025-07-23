import 'package:flutter_lottoresult/system/constants.dart';
import 'package:flutter_lottoresult/system/timezone/latest.dart' as tz;
import 'package:timezone/timezone.dart' as tz;

class KoreanTimeZone {
  static final KoreanTimeZone _instance = KoreanTimeZone._internal();
  late tz.Location _seoul;

  KoreanTimeZone._internal() {
    tz.initializeTimeZones();
    _seoul = tz.getLocation(Constants.seoulTimeZone);
  }

  factory KoreanTimeZone() {
    return _instance;
  }

  tz.Location getSeoul() {
    return _seoul;
  }
}
