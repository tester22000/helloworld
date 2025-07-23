import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';
import 'package:flutter_lottoresult/service/external/lotto_result_external_service.dart';

void main() {
  group('LottoResultExternalService test', () {
    late ProviderContainer container;

    setUp(() {
      container = ProviderContainer();
    });

    tearDown(() {
      container.dispose();
    });

    test('fetch lottoresult with 200 statuscode', () async {
      final drwNo = 1000;
      
      final LottoResultExternalService service = container.read(lottoResultExternalServiceProvider);
      final result = await service.getDrawResult(drwNo);

      expect(result, isA<LottoDrawResult>());
      expect(result.drwNo, drwNo);
    });
  });
}
