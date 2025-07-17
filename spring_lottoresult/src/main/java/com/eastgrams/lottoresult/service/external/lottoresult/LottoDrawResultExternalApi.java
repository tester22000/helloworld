package com.eastgrams.lottoresult.service.external.lottoresult;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LottoDrawResultExternalApi {
    @GET("common.do?method=getLottoNumber")
    Call<LottoDrawResult> getLottoResult(
            @Query("drwNo") int drawNo
    );
}
