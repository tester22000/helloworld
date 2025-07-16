package repository_test

import (
	"testing"

	"eastgrams.com/go_lottoresult/app/data/models"
	"eastgrams.com/go_lottoresult/app/data/repository"
)

var _json_data = `{"totSellamnt":118628811000,"returnValue":"success","drwNoDate":"2022-01-29","firstWinamnt":1246819620,"drwtNo6":42,"drwtNo4":22,"firstPrzwnerCo":22,"drwtNo5":32,"bnusNo":39,"firstAccumamnt":27430031640,"drwNo":1000,"drwtNo2":8,"drwtNo3":19,"drwtNo1":2}`

func TestLottoDrawResultRepository(t *testing.T) {
	var repo = repository.LottoDrawResultRepositoryObj
	const drwNo = 1000

	repo.Delete(drwNo)
	notExist := repo.Get(drwNo)
	if notExist.DrwNo != 0 {
		t.Error("data shouln't exist")
	}

	lottoResult, err := models.GetLottoDrawResultFronJsonString(_json_data)
	if err != nil {
		t.Error("json decoding error", err)
	}
	if lottoResult.DrwNo != 1000 {
		t.Errorf("json decoding error drwNo=%d; expected=%d", lottoResult.DrwNo, 1000)
	}
	repo.Add(lottoResult)
	exist := repo.Get(drwNo)

	if exist.DrwNo != 1000 {
		t.Errorf("Get Error drwNo=%d; expected=%d", exist.DrwNo, 1000)
	}

}
