import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';

class LottoResultPageState {
  final int drwNo;
  final LottoDrawResult? drawResult;
  const LottoResultPageState({required this.drwNo, this.drawResult});

  LottoResultPageState copyWith({int? drwNo, LottoDrawResult? drawResult}) {
    return LottoResultPageState(
      drwNo: drwNo ?? this.drwNo,
      drawResult: drawResult ?? this.drawResult,
    );
  }

}
