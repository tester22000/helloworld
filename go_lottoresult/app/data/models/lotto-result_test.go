package models_test

import (
	"testing"

	"eastgrams.com/go_lottoresult/app/data/models"
)

var _json_data = `{"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2}`

func TestLottoDrawResul(t *testing.T) {

	result, err := models.GetLottoDrawResultFronJsonString(_json_data)
	if err != nil {
		t.Error("json decoding error", err)
	}

	if result.DrwNo != 1000 {
		t.Errorf("drwNo error %d; expected: %d;", result.DrwNo, 1000)
	}
}
