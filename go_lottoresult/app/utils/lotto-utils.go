package utils

import "time"

type LottoUtil struct{}

var LottoUtilObj = LottoUtil{}

var _START_DATE = DatUtilObj.GetKoreanDateFromYmd(2002, 12, 7)

const _DRAW_HOUR_MIN = 2045

func isBeforeDrawTime(date time.Time) bool {
	return date.Hour()*100+date.Minute() < _DRAW_HOUR_MIN
}

func (l LottoUtil) GetLastDrawNo() int {
	curDate := DatUtilObj.GetKoreanDate()
	drwNo := DatUtilObj.WeekDiff(_START_DATE, curDate) + 1
	if curDate.Weekday() != time.Saturday || !isBeforeDrawTime(curDate) {
		return drwNo
	}
	return drwNo - 1
}

func (l LottoUtil) GetMaxDrawNo() int {
	curDate := DatUtilObj.GetKoreanDate()
	drwNo := DatUtilObj.WeekDiff(_START_DATE, curDate) + 1
	if curDate.Weekday() != time.Saturday {
		return drwNo
	}
	return drwNo + 1
}

func (l LottoUtil) GetDrawDate(drwNo int) time.Time {
	return DatUtilObj.WeekAdd(_START_DATE, drwNo-1)
}
