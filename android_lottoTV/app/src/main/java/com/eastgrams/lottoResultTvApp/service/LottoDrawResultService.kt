package com.eastgrams.lottoResultTvApp.service

import com.eastgrams.lottoResultTvApp.data.LottoDrawServiceResult
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.jvm.java

interface LottoDrawResultService {
    @GET("common.do")
    suspend fun getLottoResult(
        @Query("method") method: String = "getLottoNumber",
        @Query("drwNo") drawNo: Int,
    ): LottoDrawServiceResult

    companion object {
        private const val BASE_URL = "https://www.dhlottery.co.kr/"
        fun create(): LottoDrawResultService {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client =  OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LottoDrawResultService::class.java)
        }
    }
}