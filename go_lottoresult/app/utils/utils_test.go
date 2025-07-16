package utils_test

import (
	"os"
	"strings"
	"testing"

	"time"

	"eastgrams.com/go_lottoresult/app/utils"
)

func TestFindFile(t *testing.T) {
	dirName, err := os.Getwd()
	if err != nil {
		t.Error("get current directory error", err)
	}

	result, err := utils.FindFile(".env", dirName)
	if err != nil {
		t.Error("file find error", err)
	}
	if strings.Contains(result, ".env") == false {
		t.Errorf("file name must contains '.env'; actual=%s", result)
	}
}

func TestDateUtils(t *testing.T) {
	curTime := time.Now().UTC()
	toKorTime := utils.DatUtilObj.ToKoreanDate(curTime)
	curKorTime := utils.DatUtilObj.GetKoreanDate()

	if utils.DatUtilObj.GetYYYYMMDD(toKorTime) != utils.DatUtilObj.GetYYYYMMDD(curKorTime) {
		t.Errorf("get korean time is difference %s %s", utils.DatUtilObj.GetYYYYMMDD(toKorTime), utils.DatUtilObj.GetYYYYMMDD(curKorTime))
	}

	checkYmd := "20000101"
	checkYmd2 := "2000-01-01"
	dateFromYmd := utils.DatUtilObj.GetKoreanDateFromYmd(2000, 1, 1)

	if utils.DatUtilObj.GetYYYYMMDD(dateFromYmd) != checkYmd {
		t.Errorf("GetKoreanDateFromYmd error %s expected:%s", utils.DatUtilObj.GetYYYYMMDD(dateFromYmd), checkYmd)
	}

	if utils.DatUtilObj.ToDateString(dateFromYmd) != checkYmd2 {
		t.Errorf("GetKoreanDateFromYmd error %s expected:%s", utils.DatUtilObj.ToDateString(dateFromYmd), checkYmd2)
	}

	dayAddCheck := utils.DatUtilObj.GetKoreanDateFromYmd(2000, 1, 11)

	if utils.DatUtilObj.DayDiff(dateFromYmd, dayAddCheck) != 10 {
		t.Errorf("DayDiff error %d expected:10", utils.DatUtilObj.DayDiff(dateFromYmd, dayAddCheck))
	}

	if utils.DatUtilObj.DayDiff(dateFromYmd, dayAddCheck) != utils.DatUtilObj.DayDiff(dayAddCheck, dateFromYmd) {
		t.Errorf("DayDiff error start-end=%d end-start=%d", utils.DatUtilObj.DayDiff(dateFromYmd, dayAddCheck), utils.DatUtilObj.DayDiff(dayAddCheck, dateFromYmd))
	}

	if !dayAddCheck.Equal(utils.DatUtilObj.DayAdd(dateFromYmd, 10)) {
		t.Errorf("DayAdd error output:%s;  expected:%s", dayAddCheck, utils.DatUtilObj.DayAdd(dateFromYmd, 10))
	}

	dayAddDate := utils.DatUtilObj.DayAdd(dateFromYmd, 100)
	if utils.DatUtilObj.DayDiff(dateFromYmd, dayAddDate) != 100 {
		t.Errorf("DayDiff error %d expected:100", utils.DatUtilObj.DayDiff(dateFromYmd, dayAddDate))
	}
	if !utils.DatUtilObj.DayAdd(dayAddDate, -100).Equal(dateFromYmd) {
		t.Errorf("DayDiff error date not same %s %s", utils.DatUtilObj.DayAdd(dayAddDate, -100), dateFromYmd)
	}

	if utils.DatUtilObj.WeekDiff(dayAddCheck, dateFromYmd) != 1 {
		t.Errorf("WeekDiff error %d expected:2", utils.DatUtilObj.WeekDiff(dayAddCheck, dateFromYmd))
	}
	if utils.DatUtilObj.WeekDiff(dayAddCheck, dateFromYmd) != utils.DatUtilObj.WeekDiff(dateFromYmd, dayAddCheck) {
		t.Errorf("WeekDiff error %d isn't equal to %d", utils.DatUtilObj.WeekDiff(dayAddCheck, dateFromYmd), utils.DatUtilObj.WeekDiff(dateFromYmd, dayAddCheck))
	}

	weeAddCheckBase := utils.DatUtilObj.GetKoreanDateFromYmd(2002, 12, 7)
	weekAddResult := utils.DatUtilObj.WeekAdd(weeAddCheckBase, 1180-1)
	weekAddCheckDate := utils.DatUtilObj.GetKoreanDateFromYmd(2025, 7, 12)

	if !weekAddCheckDate.Equal(weekAddResult) {
		t.Errorf("WeekAdd Error %s must equal to %s", weekAddResult, weekAddCheckDate)
	}
}

func TestWeekUtil(t *testing.T) {
	weekAddCheckDate := utils.DatUtilObj.GetKoreanDateFromYmd(2025, 7, 12)
	checkDate := utils.LottoUtilObj.GetDrawDate(1180)
	if !checkDate.Equal(weekAddCheckDate) {
		t.Errorf("GetDrawDate Error %s must equal to %s", weekAddCheckDate, checkDate)
	}
}
