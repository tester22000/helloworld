package com.eastgrams.swinglotto.model;

import com.google.gson.annotations.SerializedName;
import java.text.DecimalFormat;

public class LottoDrawServiceResult {
    private static final String SUCCESS_RESPONSE = "success";
    private static final DecimalFormat formatter = new DecimalFormat("#,###");

    @SerializedName("totSellamnt") public long totalSellAmount;
    @SerializedName("returnValue") public String result; // 요청결과
    @SerializedName("drwNoDate") public String drawDate; // 날짜
    @SerializedName("firstWinamnt") public long firstWinAmount; //1등 상금액
    @SerializedName("firstPrzwnerCo") public int firstWinCount; // 1등 당첨인원
    @SerializedName("firstAccumamnt") public long firstWinTotalAmount;
    @SerializedName("drwtNo1") public int drawNo1;// 로또번호 1
    @SerializedName("drwtNo2") public int drawNo2;// 로또번호 2
    @SerializedName("drwtNo3") public int drawNo3;// 로또번호 3
    @SerializedName("drwtNo4") public int drawNo4;// 로또번호 4
    @SerializedName("drwtNo5") public int drawNo5;// 로또번호 5
    @SerializedName("drwtNo6") public int drawNo6;// 로또번호 6
    @SerializedName("bnusNo") public int bonusNo;// 로또 보너스 번호
    @SerializedName("drwNo") public int drawNo;// 로또회차

    public boolean isSuccess() {
        return SUCCESS_RESPONSE.equals(result);
    }

    public String firstAccumamntString() {
        return formatter.format(firstWinTotalAmount);
    }

    public String firstWinAmountString() {
        return formatter.format(firstWinAmount);
    }

    @Override
    public String toString() {
        return "LottoDrawServiceResult{" +
                "totalSellAmount=" + totalSellAmount +
                ", result='" + result + '\'' +
                ", drawDate='" + drawDate + '\'' +
                ", firstWinAmount=" + firstWinAmount +
                ", firstWinCount=" + firstWinCount +
                ", firstWinTotalAmount=" + firstWinTotalAmount +
                ", drawNo1=" + drawNo1 +
                ", drawNo2=" + drawNo2 +
                ", drawNo3=" + drawNo3 +
                ", drawNo4=" + drawNo4 +
                ", drawNo5=" + drawNo5 +
                ", drawNo6=" + drawNo6 +
                ", bonusNo=" + bonusNo +
                ", drawNo=" + drawNo +
                '}';
    }
}
