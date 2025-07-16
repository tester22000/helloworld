package service_test

import (
	"testing"

	"eastgrams.com/go_lottoresult/app/service"
)

func TestLottoResultService(t *testing.T) {
	const drwNo = 1000

	result := service.LottoDrawResultServiceObj.GetLottoDrawResult(drwNo)

	if result.DrwNo != drwNo {
		t.Errorf("drwNo error  %d; expected=%d", result.DrwNo, drwNo)
	}
}
