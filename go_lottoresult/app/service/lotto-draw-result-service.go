package service

import (
	"eastgrams.com/go_lottoresult/app/data/models"
	"eastgrams.com/go_lottoresult/app/data/repository"
	"eastgrams.com/go_lottoresult/app/service/external"
	"eastgrams.com/go_lottoresult/app/utils"
)

type LottoDrawResultService struct{}

var LottoDrawResultServiceObj = LottoDrawResultService{}

func (l LottoDrawResultService) GetLottoDrawResult(drwNo int) models.LottoDrawResult {
	var lastDrawNo = utils.LottoUtilObj.GetLastDrawNo()
	if drwNo > lastDrawNo {
		drwNo = lastDrawNo
	}
	result := repository.LottoDrawResultRepositoryObj.Get(drwNo)
	if result.DrwNo == 0 {
		result, _, _ := external.LottoDrawResultExternalServiceObj.GetResult(drwNo)
		if result.DrwNo == drwNo {
			defer func(result models.LottoDrawResult) {
				repository.LottoDrawResultRepositoryObj.Add(result)
			}(result)
		}
		return result
	}
	return result
}
