package utils

import (
	"time"
)

type DateUtil struct {
	timeZone *time.Location
}

var DatUtilObj = DateUtil{timeZone: getKoreanLocation()}

func getKoreanLocation() *time.Location {
	loc, _ := time.LoadLocation("Asia/Seoul")
	return loc
}

func (l DateUtil) GetKoreanDate() time.Time {
	now := time.Now()
	return now.In(l.timeZone)
}

func (l DateUtil) ToKoreanDate(date time.Time) time.Time {
	return date.In(l.timeZone)
}

func (l DateUtil) GetKoreanDateFromYmd(year int, month time.Month, day int) time.Time {
	return time.Date(year, month, day, 0, 0, 0, 0, l.timeZone)
}

func (l DateUtil) GetYYYYMMDD(date time.Time) string {
	return date.Format("20060102")
}

func (l DateUtil) ToDateString(date time.Time) string {
	return date.Format("2006-01-02")
}

func (l DateUtil) DayDiff(date1, date2 time.Time) int {
	if date1.Before(date2) {
		return int(date2.Sub(date1).Hours() / 24)
	}
	return int(date1.Sub(date2).Hours() / 24)
}

func (l DateUtil) DayAdd(date time.Time, days int) time.Time {
	return date.AddDate(0, 0, days)
}

func (l DateUtil) WeekDiff(date1, date2 time.Time) int {
	if date1.Before(date2) {
		return int(date2.Sub(date1).Hours() / (7 * 24))
	}
	return int(date1.Sub(date2).Hours() / (7 * 24))
}

func (l DateUtil) WeekAdd(date time.Time, days int) time.Time {
	return date.AddDate(0, 0, days*7)
}
