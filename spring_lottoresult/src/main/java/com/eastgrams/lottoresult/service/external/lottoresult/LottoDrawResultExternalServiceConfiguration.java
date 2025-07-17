package com.eastgrams.lottoresult.service.external.lottoresult;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class LottoDrawResultExternalServiceConfiguration {

    @Bean
    public Retrofit lottoResultRetrofit(OkHttpClient okHttpClient){
        String lottoResultBaseUrl = "https://www.dhlottery.co.kr/";
        return new Retrofit.Builder()
                .baseUrl(lottoResultBaseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public LottoDrawResultExternalApi lottoDrawResultExternalApi(Retrofit lottoResultRetrofit){
        return lottoResultRetrofit.create(LottoDrawResultExternalApi.class);
    }
}
