package repository

import (
	"eastgrams.com/go_lottoresult/app/data/models"
)

type LottoDrawResultRepository struct {
}

func (l LottoDrawResultRepository) Add(result models.LottoDrawResult) {
	Db.Create(&result)
}

func (l LottoDrawResultRepository) Delete(drwNo int) {
	var LottoDrawResult models.LottoDrawResult
	Db.Delete(&LottoDrawResult, drwNo)
}

func (l LottoDrawResultRepository) Get(drwNo int) models.LottoDrawResult {
	var LottoDrawResult models.LottoDrawResult
	Db.First(&LottoDrawResult, drwNo)
	return LottoDrawResult
}

var LottoDrawResultRepositoryObj = LottoDrawResultRepository{}
