import 'package:flutter_lottoresult/service/lotto_result_service.dart';
import 'package:flutter_lottoresult/system/utils/lotto_utils.dart';
import 'package:flutter_lottoresult/ui/pages/lotto_result/notifier/lotto_result_state.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

class LottoResultPageStateNotifier extends StateNotifier<LottoResultPageState> {
  final LottoResultService _lottoResultService;
  LottoResultPageStateNotifier({required LottoResultService service})
    : _lottoResultService = service,
      super(LottoResultPageState(drwNo: LottoUtils.getLastDrawNo()));

  Future<void> getLottoResult(int drwNo) async {
    final result = await _lottoResultService.getLottoDrawwResult(drwNo);
    state = state.copyWith(drwNo: drwNo, drawResult: result);
  }
}

final lottoResultPageStateProvider =
    StateNotifierProvider<LottoResultPageStateNotifier, LottoResultPageState>((
      ref,
    ) {
      return LottoResultPageStateNotifier(
        service: ref.read(lottoResultServiceProvider),
      );
    });
