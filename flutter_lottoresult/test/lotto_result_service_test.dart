import 'package:flutter_lottoresult/data/repository/lotto_draw_result_repository.dart';
import 'package:flutter_lottoresult/service/lotto_result_service.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:flutter_dotenv/flutter_dotenv.dart';

void main() async {
  await dotenv.load(fileName: ".env");
  group('LottoDrawResultService test', () {
    late ProviderContainer container;

    setUp(() {
      container = ProviderContainer();
    });

    tearDown(() {
      container.dispose();
    });

    test('fetch lottoresult with 200 statuscode', () async {
      final drwNo = 1000;
      final repo = container.read(lottoDrawResultRepositoryProvider);
      repo.deleteLottoDrawResult(drwNo);
      final service = container.read(lottoResultServiceProvider);
      final result = await service.getLottoDrawwResult(drwNo);
      print(result);
      expect(result.drwNo, drwNo);
      final record1 = repo.getLottoDrawResultByDrwNo(drwNo);
      expect(record1 != null, true);
    });
  });
}
