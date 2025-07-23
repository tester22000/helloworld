import 'package:flutter/material.dart';
import 'package:flutter_lottoresult/data/model/lotto_draw_result.dart';
import 'package:flutter_lottoresult/system/utils/lotto_utils.dart';
import 'package:flutter_lottoresult/ui/pages/lotto_result/notifier/lotto_result_state_notifier.dart';
import 'package:flutter_lottoresult/ui/widgets/color_sized_box.dart';
import 'package:flutter_lottoresult/ui/widgets/lotto_ball.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:intl/intl.dart';

class LottoResultHeader extends StatelessWidget {
  final int drwNo;
  const LottoResultHeader(this.drwNo);

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text(
            "$drwNo회",
            style: TextStyle(
              decoration: TextDecoration.none,
              color: Colors.red[700],
              fontSize: 26.0,
            ),
          ),
          SizedBox(width: 12),
          Text(
            "당첨결과",
            style: TextStyle(
              decoration: TextDecoration.none,
              color: Colors.grey[400],
              fontSize: 26.0,
            ),
          ),
        ],
      ),
    );
  }
}

class LottoResultDateInfo extends StatelessWidget {
  final String? drwDate;
  const LottoResultDateInfo(this.drwDate);

  @override
  Widget build(BuildContext context) {
    final year = drwDate?.substring(0, 4) ?? "";
    final month = drwDate?.substring(5, 7) ?? "";
    final date = drwDate?.substring(8, 10) ?? "";
    return Center(
      child: Row(
        mainAxisSize: MainAxisSize.min,
        children: [
          Text(
            "($year년 $month월 $date일 추첨)",
            style: TextStyle(
              decoration: TextDecoration.none,
              color: Colors.grey[400],
              fontSize: 16.0,
            ),
          ),
        ],
      ),
    );
  }
}

class LottoResultWinNumbers extends StatelessWidget {
  final LottoDrawResult? result;
  const LottoResultWinNumbers(this.result);
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.min,
          children: [
            LottoBall(number: result?.drwtNo1 ?? 0, leftMargin: false),
            LottoBall(number: result?.drwtNo2 ?? 0, leftMargin: true),
            LottoBall(number: result?.drwtNo3 ?? 0, leftMargin: true),
            LottoBall(number: result?.drwtNo4 ?? 0, leftMargin: true),
            LottoBall(number: result?.drwtNo5 ?? 0, leftMargin: true),
            LottoBall(number: result?.drwtNo6 ?? 0, leftMargin: true),
          ],
        ),
        SizedBox(height: 45),
        Text(
          "당첨번호",
          style: TextStyle(
            decoration: TextDecoration.none,
            color: Colors.grey[400],
            fontWeight: FontWeight.bold,
            fontSize: 16,
          ),
        ),
      ],
    );
  }
}

class LottoResultBonus extends StatelessWidget {
  final int? bnousNo;
  const LottoResultBonus(this.bnousNo);
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        Row(
          mainAxisAlignment: MainAxisAlignment.center,
          mainAxisSize: MainAxisSize.min,
          children: [LottoBall(number: bnousNo ?? 0, leftMargin: false)],
        ),
        SizedBox(height: 45),
        Text(
          "보너스",
          style: TextStyle(
            decoration: TextDecoration.none,
            color: Colors.grey[400],
            fontWeight: FontWeight.bold,
            fontSize: 16,
          ),
        ),
      ],
    );
  }
}

class LottoResultPrizeInfo extends StatelessWidget {
  static final Color _titleColor = Colors.grey[400]!;
  static final format = NumberFormat();
  final LottoDrawResult? result;
  const LottoResultPrizeInfo(this.result);

  @override
  Widget build(BuildContext context) {
    final firstTotal = format.format(result?.firstAccumAmnt ?? 0);
    final firstPrize = format.format(result?.firstWinAmnt ?? 0);
    return Row(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              alignment: Alignment.center,
              width: 250,
              height: 50,
              color: _titleColor,
              child: Text(
                "1등 총 담첨금액",
                style: TextStyle(
                  color: Colors.black,
                  decoration: TextDecoration.none,
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
            ),
            ColorSizedBox(color: Colors.black, height: 1, width: 250),
            Container(
              alignment: Alignment.centerRight,
              width: 250,
              height: 50,
              color: Colors.white,
              child: Container(
                margin: EdgeInsets.only(right: 4),
                child: Text(
                  "$firstTotal원 ",
                  style: TextStyle(
                    color: Colors.red[800],
                    decoration: TextDecoration.none,
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                  ),
                  textAlign: TextAlign.end,
                ),
              ),
            ),
          ],
        ),
        SizedBox(width: 1),
        Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              alignment: Alignment.center,
              width: 150,
              height: 50,
              color: _titleColor,
              child: Text(
                "당첨게임 수",
                style: TextStyle(
                  color: Colors.black,
                  decoration: TextDecoration.none,
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ),
            ColorSizedBox(color: Colors.black, height: 1, width: 150),
            Container(
              alignment: Alignment.center,
              width: 150,
              height: 50,
              color: Colors.white,
              child: Text(
                "${result?.FirstPrzWnerCo ?? '-'}",
                style: TextStyle(
                  color: Colors.black54,
                  decoration: TextDecoration.none,
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
            ),
          ],
        ),
        SizedBox(width: 1),
        Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Container(
              alignment: Alignment.center,
              width: 250,
              height: 50,
              color: _titleColor,
              child: Text(
                "1게임당 당첨금액",
                style: TextStyle(
                  color: Colors.black,
                  decoration: TextDecoration.none,
                  fontSize: 18,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),
            ),
            ColorSizedBox(color: Colors.black, height: 1, width: 250),
            Container(
              alignment: Alignment.centerRight,
              width: 250,
              height: 50,
              color: Colors.white,
              child: Container(
                margin: EdgeInsets.only(right: 4),
                child: Text(
                  "$firstPrize원",
                  style: TextStyle(
                    color: Colors.black54,
                    decoration: TextDecoration.none,
                    fontSize: 18,
                    fontWeight: FontWeight.bold,
                  ),
                  textAlign: TextAlign.end,
                ),
              ),
            ),
          ],
        ),
      ],
    );
  }
}

class LottoResultNumberContainer extends ConsumerWidget {
  final LottoDrawResult? result;
  static final lastDrawNo = LottoUtils.getLastDrawNo();
  const LottoResultNumberContainer(this.result);
  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final drwNo = result?.drwNo ?? 0;
    return Center(
      child: Row(
        mainAxisSize: MainAxisSize.min,
        mainAxisAlignment: MainAxisAlignment.center,
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          // button
          IconButton(
            icon: const Icon(Icons.chevron_left),
            iconSize: 40.0,
            color: Colors.white,
            onPressed: drwNo > 0
                ? () {
                    ref
                        .read(lottoResultPageStateProvider.notifier)
                        .getLottoResult(drwNo - 1);
                  }
                : null,
          ),
          SizedBox(width: 10),
          LottoResultWinNumbers(result),
          SizedBox(width: 40),
          Container(
            margin: EdgeInsets.only(top: 8),
            alignment: Alignment.topCenter,
            child: Text(
              "+",
              style: TextStyle(
                decoration: TextDecoration.none,
                color: Colors.grey[400],
                fontSize: 35,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),
          SizedBox(width: 40),
          LottoResultBonus(result?.bnusNo),
          SizedBox(width: 10),
          IconButton(
            icon: const Icon(Icons.chevron_right),
            iconSize: 40.0,
            color: Colors.white,
            onPressed: drwNo != 0 && drwNo < lastDrawNo ? () {
                    ref
                        .read(lottoResultPageStateProvider.notifier)
                        .getLottoResult(drwNo + 1);
            } : null,
          ),
        ],
      ),
    );
  }
}

class LottoResultPage extends StatelessWidget {
  const LottoResultPage({super.key});

  @override
  Widget build(BuildContext context) {
    return const LottoResultPageView();
  }
}

class LottoResultPageView extends ConsumerStatefulWidget {
  const LottoResultPageView();

  @override
  ConsumerState<ConsumerStatefulWidget> createState() {
    return _LottoResultPageViewState();
  }
}

class _LottoResultPageViewState extends ConsumerState<LottoResultPageView> {
  @override
  void initState() {
    super.initState();
    ref
        .read(lottoResultPageStateProvider.notifier)
        .getLottoResult(LottoUtils.getLastDrawNo());
  }

  @override
  Widget build(BuildContext context) {
    return LottoResultPageDetail();
  }
}

class LottoResultPageDetail extends ConsumerWidget {
  const LottoResultPageDetail({super.key});

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final provider = ref.watch(lottoResultPageStateProvider);
    final drawResult = provider.drawResult;
    return Container(
      color: Colors.black,
      child: Center(
        child: Column(
          children: [
            SizedBox(height: 67),
            LottoResultHeader(provider.drwNo),
            LottoResultDateInfo(drawResult?.drwNoDate),
            SizedBox(height: 57),
            LottoResultNumberContainer(drawResult),
            SizedBox(height: 90),
            LottoResultPrizeInfo(drawResult),
          ],
        ),
      ),
    );
  }
}
