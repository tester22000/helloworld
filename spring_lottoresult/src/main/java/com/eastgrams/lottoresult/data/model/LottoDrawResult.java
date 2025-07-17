package com.eastgrams.lottoresult.data.model;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.text.DecimalFormat;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="lotto_draw_result")
public class LottoDrawResult {
    private static final String SUCCESS_RESPONSE = "success";
    private static final DecimalFormat formatter = new DecimalFormat("#,###");

    @Id
    @Column(name="drw_no")
    @SerializedName("drwNo")
    @Schema(description = "draw no")
    private Integer  drwNo;

    @Column(name="drw_no_date")
    @SerializedName("drwNoDate")
    @Schema(description = "drawn date")
    private String drwNoDate;

    @Column(name="drwt_no1")
    @SerializedName("drwtNo1")
    @Schema(description = "drawn result lotto number 1")
    private Integer drwtNo1;

    @Column(name="drwt_no2")
    @SerializedName("drwtNo2")
    @Schema(description = "drawn result lotto number 2")
    private Integer drwtNo2;

    @Column(name="drwt_no3")
    @SerializedName("drwtNo3")
    @Schema(description = "drawn result lotto number 3")
    private Integer drwtNo3;

    @Column(name="drwt_no4")
    @SerializedName("drwtNo4")
    @Schema(description = "drawn result lotto number 4")
    private Integer drwtNo4;

    @Column(name="drwt_no5")
    @SerializedName("drwtNo5")
    @Schema(description = "drawn result lotto number 5")
    private Integer drwtNo5;

    @Column(name="drwt_no6")
    @SerializedName("drwtNo6")
    @Schema(description = "drawn result lotto number 6")
    private Integer drwtNo6;

    @Column(name="bnus_no")
    @SerializedName("bnusNo")
    @Schema(description = "drawn result lotto bonus number")
    private Integer bnusNo;

    @Column(name="tot_sell_amnt")
    @SerializedName("totSellamnt")
    private Long totSellAmnt;

    @Column(name="first_win_amnt")
    @SerializedName("firstWinamnt")
    private Long firstWinAmnt;

    @Column(name="first_prz_wner_co")
    @SerializedName("firstPrzwnerCo")
    private Long  FirstPrzWnerCo;

    @Column(name="first_accum_amnt")
    @SerializedName("firstAccumamnt")
    private Long firstAccumAmnt;

    @Column(name="return_value")
    @SerializedName("returnValue")
    private String returnValue;


    public boolean isSuccess() {
        return SUCCESS_RESPONSE.equals(returnValue);
    }

    public String firstAccumamntString() {
        return formatter.format(firstAccumAmnt);
    }

    public String firstWinAmountString() {
        return formatter.format(firstWinAmnt);
    }
}
