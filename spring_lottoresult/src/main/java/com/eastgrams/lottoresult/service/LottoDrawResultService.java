package com.eastgrams.lottoresult.service;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import com.eastgrams.lottoresult.data.repository.LottoDrawResultRepository;
import com.eastgrams.lottoresult.service.external.lottoresult.LottoDrawResultExternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LottoDrawResultService {
    private final LottoDrawResultRepository lottoDrawResultRepository;
    private final LottoDrawResultExternalService lottoDrawResultExternalService;

    public Optional<LottoDrawResult> getByDrwNo(int drwNo){

        Optional<LottoDrawResult> result = lottoDrawResultRepository.findByDrwNo(drwNo);
        if (result.isPresent()) {
            return result;
        }

        result = lottoDrawResultExternalService.getLottoDrawResult(drwNo);
        if(result.isPresent()){
            lottoDrawResultRepository.save(result.get());
            return result;
        }
        return Optional.empty();
    }
}
