import {
    getKoreanDate,
    dayDiff,
    weekDiff,
    getDateFromYmd,
    getYYYYMMDD,
    addDays,
    addWeeks
} from '@/app/lib/utils/dateUtils'


test('daydiff', () => {
    const startDate = getDateFromYmd(2005,1,1)
    const nextDate = getDateFromYmd(2005,1,2)
    const nextWeekDate = getDateFromYmd(2005,1,8)

    expect(dayDiff(startDate, nextDate)).toBe(1)
    expect(dayDiff(startDate, nextWeekDate)).toBe(7)
});

test('weekDiff', () => {
    const startDate = getDateFromYmd(2005,1,1)
    const nextDate = getDateFromYmd(2005,1,2)
    const nextWeekDate = getDateFromYmd(2005,1,8)

    expect(weekDiff(startDate, nextDate)).toBe(0)
    expect(weekDiff(startDate, nextWeekDate)).toBe(1)
});

test('dateStr', () => {
    expect(getYYYYMMDD(getDateFromYmd(2005,1,1))).toBe("20050101")
    expect(getYYYYMMDD(getDateFromYmd(2005,2,1))).toBe("20050201")
    expect(getYYYYMMDD(getDateFromYmd(2005,3,1))).toBe("20050301")
    expect(getYYYYMMDD(getDateFromYmd(2005,4,1))).toBe("20050401")
    expect(getYYYYMMDD(getDateFromYmd(2005,5,1))).toBe("20050501")
    expect(getYYYYMMDD(getDateFromYmd(2005,6,1))).toBe("20050601")
    expect(getYYYYMMDD(getDateFromYmd(2005,7,1))).toBe("20050701")
    expect(getYYYYMMDD(getDateFromYmd(2005,8,1))).toBe("20050801")
    expect(getYYYYMMDD(getDateFromYmd(2005,9,1))).toBe("20050901")
    expect(getYYYYMMDD(getDateFromYmd(2005,10,1))).toBe("20051001")
    expect(getYYYYMMDD(getDateFromYmd(2005,11,1))).toBe("20051101")
    expect(getYYYYMMDD(getDateFromYmd(2005,12,1))).toBe("20051201")
});

test('add days', ()=> {
    const startDate = getDateFromYmd(2005,1,1)
    expect(dayDiff(startDate, addDays(startDate, 1))).toBe(1)
    expect(dayDiff(startDate, addDays(startDate, 7))).toBe(7)
    expect(dayDiff(startDate, addDays(startDate, 100))).toBe(100)
    expect(dayDiff(startDate, addDays(startDate, -10))).toBe(10)
})

test('add weeks', () => {
    const startDate = getDateFromYmd(2005,1,1)
    expect(dayDiff(startDate, addWeeks(startDate, 1))).toBe(7)
    expect(dayDiff(startDate, addWeeks(startDate, 100))).toBe(700)
})