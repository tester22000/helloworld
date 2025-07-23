import 'dart:convert';


// ignore_for_file: public_member_api_docs, sort_constructors_first

class LottoDrawResult {
    final int drwNo;
    final String drwNoDate;
    final int drwtNo1;
    final int drwtNo2;
    final int drwtNo3;
    final int drwtNo4;
    final int drwtNo5;
    final int drwtNo6;
    final int bnusNo;
    final int totSellAmnt;
    final int firstWinAmnt;
    final int FirstPrzWnerCo;
    final int firstAccumAmnt;
    final String returnValue;

    LottoDrawResult({
        required this.drwNo,
        required this.drwNoDate,
        required this.drwtNo1,
        required this.drwtNo2,
        required this.drwtNo3,
        required this.drwtNo4,
        required this.drwtNo5,
        required this.drwtNo6,
        required this.bnusNo,
        required this.totSellAmnt,
        required this.firstWinAmnt,
        required this.FirstPrzWnerCo,
        required this.firstAccumAmnt,
        required this.returnValue,
    });

    Map<String, dynamic> toJson() {
        return <String, dynamic>{
        'drwNo': drwNo,
        'drwNoDate': drwNoDate,
        'drwtNo1': drwtNo1,
        'drwtNo2': drwtNo2,
        'drwtNo3': drwtNo3,
        'drwtNo4': drwtNo4,
        'drwtNo5': drwtNo5,
        'drwtNo6': drwtNo6,
        'bnusNo': bnusNo,
        'totSellamnt': totSellAmnt,
        'firstWinamnt': firstWinAmnt,
        'firstPrzwnerCo': FirstPrzWnerCo,
        'firstAccumamnt': firstAccumAmnt,
        'returnValue': returnValue,
        };
    }

    Map<String, dynamic> toDB() {
        return <String, dynamic>{
        'drw_no': drwNo,
        'drw_no_date': drwNoDate,
        'drwt_no1': drwtNo1,
        'drwt_no2': drwtNo2,
        'drwt_no3': drwtNo3,
        'drwt_no4': drwtNo4,
        'drwt_no5': drwtNo5,
        'drwt_no6': drwtNo6,
        'bnus_no': bnusNo,
        'tot_sell_amnt': totSellAmnt,
        'first_win_amnt': firstWinAmnt,
        'first_prz_wner_co': FirstPrzWnerCo,
        'first_accum_amnt': firstAccumAmnt,
        'return_value': returnValue,
        };
    }

    factory LottoDrawResult.fromJson(Map<String, dynamic> map) {
        return LottoDrawResult(
        drwNo: map['drwNo'] as int,
        drwNoDate: map['drwNoDate'] as String,
        drwtNo1: map['drwtNo1'] as int,
        drwtNo2: map['drwtNo2'] as int,
        drwtNo3: map['drwtNo3'] as int,
        drwtNo4: map['drwtNo4'] as int,
        drwtNo5: map['drwtNo5'] as int,
        drwtNo6: map['drwtNo6'] as int,
        bnusNo: map['bnusNo'] as int,
        totSellAmnt: map['totSellamnt'] as int,
        firstWinAmnt: map['firstWinamnt'] as int,
        FirstPrzWnerCo: map['firstPrzwnerCo'] as int,
        firstAccumAmnt: map['firstAccumamnt'] as int,
        returnValue: map['returnValue'] as String,
        );
    }


    factory LottoDrawResult.fromDB(Map<String, dynamic> map) {
        return LottoDrawResult(
        drwNo: map['drw_no'] as int,
        drwNoDate: map['drw_no_date'] as String,
        drwtNo1: map['drwt_no1'] as int,
        drwtNo2: map['drwt_no2'] as int,
        drwtNo3: map['drwt_no3'] as int,
        drwtNo4: map['drwt_no4'] as int,
        drwtNo5: map['drwt_no5'] as int,
        drwtNo6: map['drwt_no6'] as int,
        bnusNo: map['bnus_no'] as int,
        totSellAmnt: map['tot_sell_amnt'] as int,
        firstWinAmnt: map['first_win_amnt'] as int,
        FirstPrzWnerCo: map['first_prz_wner_co'] as int,
        firstAccumAmnt: map['first_accum_amnt'] as int,
        returnValue: map['return_value'] as String,
        );
    }

    String toJsonString() => json.encode(toJson());

    factory LottoDrawResult.fromJsonString(String source) =>
        LottoDrawResult.fromJson(json.decode(source) as Map<String, dynamic>);
}
