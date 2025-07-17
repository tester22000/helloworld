package com.eastgrams.lottoresult;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import com.eastgrams.lottoresult.service.LottoDrawResultService;
import com.eastgrams.lottoresult.service.external.lottoresult.LottoDrawResultExternalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = LottoResultApplication.class)
class LottoDrawResultServiceTest {

    @Autowired
    private LottoDrawResultService lottoDrawResultService;

    @Test
    @DisplayName("lottoDrawService Get")
    void testLottoDrawResultGet(){
        int drwNo = 1100;
        Optional<LottoDrawResult> result = lottoDrawResultService.getByDrwNo(drwNo);
        assertTrue(result.isPresent());
        assertEquals(drwNo, result.get().getDrwNo());
    }
}
