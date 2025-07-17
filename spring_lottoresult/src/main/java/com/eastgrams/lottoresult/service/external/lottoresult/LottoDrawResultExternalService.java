package com.eastgrams.lottoresult.service.external.lottoresult;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LottoDrawResultExternalService {
    private final LottoDrawResultExternalApi lottoDrawResultExternalApi;

    public Optional<LottoDrawResult> getLottoDrawResult(int drwNo){
        Call<LottoDrawResult> call = lottoDrawResultExternalApi.getLottoResult(drwNo);
        try {
            Response<LottoDrawResult> response = call.execute();
            if (response.isSuccessful() && response.body() != null){
                return Optional.of(response.body());
            }
        } catch( Exception ex){
            System.out.println(ex.getMessage());
        }
        return Optional.empty();
    }
}
