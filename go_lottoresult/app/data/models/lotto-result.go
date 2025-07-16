package models

import (
	"encoding/json"
)

type LottoDrawResult struct {
	DrwNo          int    `gorm:"primaryKey;column:drw_no" json:"drwNo"`
	DrwNoDate      string `gorm:"column:drw_no_date" json:"drwNoDate"`
	DrwtNo1        int    `gorm:"column:drwt_no1" json:"drwtNo1"`
	DrwtNo2        int    `gorm:"column:drwt_no2" json:"drwtNo2"`
	DrwtNo3        int    `gorm:"column:drwt_no3" json:"drwtNo3"`
	DrwtNo4        int    `gorm:"column:drwt_no4" json:"drwtNo4"`
	DrwtNo5        int    `gorm:"column:drwt_no5" json:"drwtNo5"`
	DrwtNo6        int    `gorm:"column:drwt_no6" json:"drwtNo6"`
	BnusNo         int    `gorm:"column:bnus_no" json:"bnusNo"`
	TotSellAmnt    uint64 `gorm:"column:tot_sell_amnt" json:"totSellamnt"`
	FirstWinAmnt   uint64 `gorm:"column:first_win_amnt" json:"firstWinamnt"`
	FirstPrzWnerCo int    `gorm:"column:first_prz_wner_co" json:"firstPrzwnerCo"`
	FirstAccumAmnt uint64 `gorm:"column:first_accum_amnt" json:"firstAccumamnt"`
	ReturnValue    string `gorm:"column:return_value" json:"returnValue"`
}

func (l LottoDrawResult) TableName() string {
	return "lotto_draw_result"
}

func (l LottoDrawResult) ToJson() string {
	result, err := json.Marshal(l)
	if err != nil {
		return ""
	}
	return string(result)
}

func GetLottoDrawResultFronJsonString(jsonStr string) (LottoDrawResult, error) {
	var lottoDrawResult LottoDrawResult
	err := json.Unmarshal([]byte(jsonStr), &lottoDrawResult)
	return lottoDrawResult, err
}
