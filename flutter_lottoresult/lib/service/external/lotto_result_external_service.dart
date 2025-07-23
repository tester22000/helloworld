import 'package:dio/dio.dart';
import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class LottoResultExternalService {
  final Dio _dio;

  LottoResultExternalService(this._dio);

  Future<LottoDrawResult> getDrawResult(int drwNo) async {
    try {
      final response = await _dio.get(
        "common.do",
        queryParameters: {'method': 'getLottoNumber', 'drwNo': drwNo},
      );
      if (response.statusCode == 200) {
        return LottoDrawResult.fromJsonString(response.data);
      }
      throw Exception('Fail to get data');
    } catch (e) {
      rethrow;
    }
  }
}

final dioExtrenalLottoResultProvidere = Provider<Dio>((ref) {
  final Dio dio = Dio(
    BaseOptions(
      baseUrl: "https://www.dhlottery.co.kr/",
      connectTimeout: const Duration(seconds: 5),
      receiveTimeout: const Duration(seconds: 5),
    ),
  );

  dio.interceptors.add(LogInterceptor(requestBody: true, responseBody: true));
  return dio;
});

final lottoResultExternalServiceProvider = Provider<LottoResultExternalService>(
  (ref) {
    final dio = ref.watch(dioExtrenalLottoResultProvidere);
    return LottoResultExternalService(dio);
  },
);
