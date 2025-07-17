package com.eastgrams.lottoresult;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonConvertTest {

    @Test
    void testSringToObject() {
        String jsonStr = """
                {"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2} 
        """;

        Gson gson = new Gson();
        LottoDrawResult result = gson.fromJson(jsonStr, LottoDrawResult.class);
        assertEquals(1000, result.getDrwNo());
    }
}
