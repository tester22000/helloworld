import 'package:flutter_lottoresult/system/extensions/datetime_extensions.dart';
import 'package:flutter_lottoresult/system/utils/date_utils.dart';
import 'package:flutter_lottoresult/system/utils/lotto_utils.dart';
import 'package:flutter_test/flutter_test.dart';

void main() async {
  group('LottoDrawResultService test', () {
    setUp(() {});

    tearDown(() {});

    test('test dateutil', () async {
      final curTime = DateTime.now().toUtc();
      final toKorTime = curTime.toKoreanTime();
      final curKorTime = DateUtils.getKoreanTime();
      expect(toKorTime.getYYYYMMMDD(), curKorTime.getYYYYMMMDD());

      final baseTime = DateUtils.getKoreanTimeFromYmd(2000, 1, 1);
      expect(
        baseTime.dayAdd(10).getYYYYMMMDD(),
        DateUtils.getKoreanTimeFromYmd(2000, 1, 11).getYYYYMMMDD(),
      );
      expect(
        DateUtils.dayDiff(
          baseTime,
          DateUtils.getKoreanTimeFromYmd(2000, 1, 11),
        ),
        10,
      );
      expect(
        baseTime.weekAdd(1).getYYYYMMMDD(),
        DateUtils.getKoreanTimeFromYmd(2000, 1, 8).getYYYYMMMDD(),
      );
      expect(
        DateUtils.weekDiff(
          baseTime,
          DateUtils.getKoreanTimeFromYmd(2000, 1, 11),
        ),
        1,
      );
    });

    test('test lottoutil', () async {
      int drwNo = 1181;
      final drwTime = DateUtils.getKoreanTimeFromYmd(2025, 7, 19);
      expect(
        LottoUtils.getDrawDate(drwNo).getYYYYMMMDD(),
        drwTime.getYYYYMMMDD(),
      );
    });
  });
}
