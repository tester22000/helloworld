package com.eastgrams.swinglotto.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceManager {
    private static LottoDrawResultService lottoDrawResultService;

    public static LottoDrawResultService getLottoDrawResultService() {
        final String BASE_URL = "https://www.dhlottery.co.kr/";
        if ( lottoDrawResultService == null){
            synchronized (ServiceManager.class){
                if (lottoDrawResultService == null) {
                    OkHttpClient okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                            .build();
                    lottoDrawResultService = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(LottoDrawResultService.class);
                }
            }
        }
        return lottoDrawResultService;
    }
}
