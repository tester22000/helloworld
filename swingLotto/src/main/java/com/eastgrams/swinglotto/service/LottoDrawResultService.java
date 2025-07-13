package com.eastgrams.swinglotto.service;

import com.eastgrams.swinglotto.model.LottoDrawServiceResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LottoDrawResultService {
    @GET("common.do?method=getLottoNumber")
    Call<LottoDrawServiceResult> getLottoResult(
            @Query("drwNo") int drawNo
    );
}
