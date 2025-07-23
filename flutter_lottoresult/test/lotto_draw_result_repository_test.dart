import 'package:flutter_lottoresult/data/repository/lotto_draw_result_repository.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';

void main() async {
  await dotenv.load(fileName: ".env");
  group('LottoDrawResultRepository test', () {
    late ProviderContainer container;

    setUp(() {
      container = ProviderContainer();
    });

    tearDown(() {
      container.dispose();
    });

    test('fetch lottoresult with 200 statuscode', () async {
      final drwNo = 1000;
      final jsonStr = '''
{"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2}
''';
      final LottoDrawResult result = LottoDrawResult.fromJsonString(jsonStr);
      final repo = container.read(lottoDrawResultRepositoryProvider);

      repo.deleteLottoDrawResult(drwNo);
      LottoDrawResult? out1 = repo.getLottoDrawResultByDrwNo(drwNo);
      expect(out1, null);

      repo.insertLottoDrawResult(result);
      out1 = repo.getLottoDrawResultByDrwNo(drwNo);
      expect(out1 == null, false);
      expect(out1?.drwNo, drwNo);
    });
  });
}
