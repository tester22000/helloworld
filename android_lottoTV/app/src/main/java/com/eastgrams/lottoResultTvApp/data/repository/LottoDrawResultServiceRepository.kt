package com.eastgrams.lottoResultTvApp.data.repository

import com.eastgrams.lottoResultTvApp.data.LottoDrawServiceResult
import com.eastgrams.lottoResultTvApp.service.LottoDrawResultService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LottoDrawResultServiceRepository @Inject constructor(
    private val service: LottoDrawResultService
){
    suspend fun getLottoDrawResult(drwNo: Int): LottoDrawServiceResult {
        return service.getLottoResult(drawNo = drwNo)
    }
}