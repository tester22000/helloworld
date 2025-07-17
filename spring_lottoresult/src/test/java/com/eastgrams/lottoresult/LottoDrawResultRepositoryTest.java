package com.eastgrams.lottoresult;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import com.eastgrams.lottoresult.data.repository.LottoDrawResultRepository;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LottoDrawResultRepositoryTest {
    @Autowired
    private LottoDrawResultRepository lottoDrawResultRepository;
    Gson gson = new Gson();

    private LottoDrawResult getTestLottoDrawResult(int drwNo){
        String jsonStr = """
                        {"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2} 
                """;
        LottoDrawResult result = gson.fromJson(jsonStr, LottoDrawResult.class);
        result.setDrwNo(drwNo);
        return result;
    }

    @Test
    @DisplayName("Test Save, Find, Delete")
    void testSaving() {
        int drwNo = 1000;
        lottoDrawResultRepository.deleteById(drwNo);
        Optional<LottoDrawResult> result = lottoDrawResultRepository.findById(drwNo);
        assertTrue(result.isEmpty());
        LottoDrawResult lottoDrawResult = getTestLottoDrawResult(drwNo);
        lottoDrawResultRepository.save(lottoDrawResult);
        result = lottoDrawResultRepository.findById(drwNo);
        assertTrue(result.isPresent());
        result = lottoDrawResultRepository.findByDrwNo(drwNo);
        assertTrue(result.isPresent());
    }
}
