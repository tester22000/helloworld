import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';
import 'package:flutter_lottoresult/data/repository/lotto_draw_result_repository.dart';
import 'package:flutter_lottoresult/service/external/lotto_result_external_service.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class LottoResultService {
  final LottoResultExternalService _externalService;
  final LottoDrawResultRepository _lottoDrawResultRepository;

  LottoResultService(this._externalService, this._lottoDrawResultRepository);

  Future<LottoDrawResult> getLottoDrawwResult(int drwNo) async {
    LottoDrawResult? result = _lottoDrawResultRepository
        .getLottoDrawResultByDrwNo(drwNo);
    if (result == null) {
      result = await _externalService.getDrawResult(drwNo);
      _lottoDrawResultRepository.insertLottoDrawResult(result);
    }
    return result;
  }
}

final lottoResultServiceProvider = Provider<LottoResultService>((ref) {
  final externalService = ref.watch(lottoResultExternalServiceProvider);
  final lottoDrawResultRepository = ref.watch(
    lottoDrawResultRepositoryProvider,
  );
  return LottoResultService(externalService, lottoDrawResultRepository);
});
