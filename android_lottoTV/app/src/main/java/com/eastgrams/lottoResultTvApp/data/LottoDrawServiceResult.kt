package com.eastgrams.lottoResultTvApp.data

import com.google.gson.annotations.SerializedName
import java.text.DecimalFormat

data class LottoDrawServiceResult(
    @field:SerializedName("totSellamnt") val totalSellAmount: Long,
    @field:SerializedName("returnValue") val result: String, // 요청결과
    @field:SerializedName("drwNoDate") val drawDate: String, // 날짜
    @field:SerializedName("firstWinamnt") val firstWinAmount: Long, //1등 상금액
    @field:SerializedName("firstPrzwnerCo") val firstWinCount: Int, // 1등 당첨인원
    @field:SerializedName("firstAccumamnt") val firstWinTotalAmount: Long,
    @field:SerializedName("drwtNo1") val drawNo1: Int,// 로또번호 1
    @field:SerializedName("drwtNo2") val drawNo2: Int,// 로또번호 2
    @field:SerializedName("drwtNo3") val drawNo3: Int,// 로또번호 3
    @field:SerializedName("drwtNo4") val drawNo4: Int,// 로또번호 4
    @field:SerializedName("drwtNo5") val drawNo5: Int,// 로또번호 5
    @field:SerializedName("drwtNo6") val drawNo6: Int,// 로또번호 6
    @field:SerializedName("bnusNo") val bonusNo: Int,// 로또 보너스 번호
    @field:SerializedName("drwNo") val drawNo: Int,// 로또회차
) {
    fun isSuccess(): Boolean {
        return SUCCESS_RESPONSE == result
    }

    fun firstAccumamntString(): String {
        return formatter.format(firstWinTotalAmount)
    }

    fun firstWinAmountString(): String {
        return formatter.format(firstWinAmount)
    }

    companion object {
        const val SUCCESS_RESPONSE = "success"
        private val formatter = DecimalFormat("#,###");
    }
}