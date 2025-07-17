package com.eastgrams.lottoresult.api;

import com.eastgrams.lottoresult.data.model.LottoDrawResult;
import com.eastgrams.lottoresult.service.LottoDrawResultService;
import com.eastgrams.lottoresult.utils.LottoUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/lotto_draw_result")
@Tag(name="Lotto Result", description = "show lotto draw result")
public class LottoDrawResultApi {
    private final LottoDrawResultService lottoDrawResultService;

    public LottoDrawResultApi(LottoDrawResultService lottoDrawResultService){
        this.lottoDrawResultService = lottoDrawResultService;
    }

    private ResponseEntity<LottoDrawResult> getLottoDrawResult(int drwNo) {
        Optional<LottoDrawResult> result = lottoDrawResultService.getByDrwNo(drwNo);
        return result.map(
                        lottoDrawResult -> new ResponseEntity<>(lottoDrawResult, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT)
                );
    }

    @GetMapping("/")
    @Operation(summary = "Get a latest lotto drawn result.")
    public ResponseEntity<LottoDrawResult> getLatestLottoResult() {
        return getLottoDrawResult(LottoUtils.getLastDrawnNo());
    }


    @GetMapping("/{drwNo}")
    @Operation(summary = "Get a lotto drawn result by drwNo", description = "Returns a single lotto drawn result  based on its drwNo")
    public ResponseEntity<LottoDrawResult> getProductById(
            @Parameter(description = "drwNo of the lotto drawn result to retrieve", required = true)
            @PathVariable int drwNo) {
        int lastDrwNo = LottoUtils.getLastDrawnNo();
        drwNo = drwNo > lastDrwNo ? lastDrwNo : drwNo;
        return getLottoDrawResult(drwNo);
    }
}
