const DAY_TIMES = 1000 * 3600 * 24
const WEEK_TIMES = 1000 * 60 * 60 * 24 * 7

function getSDateFromYmd(year:number, month:number, day:number) {
    return {
        year : `${year}`,
        month: month < 10 ?  `0${month}` : `${month}`,
        day: day < 10 ? `0${day}` : `${day}`,
    }
}

function getSDate(date: Date) {
    const year = date.getFullYear()
    const month = date.getMonth()+1
    const day = date.getDate()
    return getSDateFromYmd(year, month, day)
}

export const getKoreanDate = (date:Date) => {
    return new Date(date.toLocaleString('en-US', { timeZone: 'Asia/Seoul' }))
}

export const getDateFromYmd = (year:number, month:number, day:number) => {
    const dateObj = getSDateFromYmd(year, month, day)
    return getKoreanDate(new Date(`${dateObj.year}-${dateObj.month}-${dateObj.day}T00:00:00+09:00`))
}

export const getYYYYMMDD = (date:Date) => {
    const koreanDate = getKoreanDate(date)
    const dateObj = getSDate(getKoreanDate(date))
    return `${dateObj.year}${dateObj.month}${dateObj.day}`
}

export const getDateString = (date:Date) => {
    const koreanDate = getKoreanDate(date)
    const dateObj = getSDate(getKoreanDate(date))
    return `${dateObj.year}-${dateObj.month}-${dateObj.day}`
}


export const dayDiff = (start:Date, end:Date) => {
    const timeDiffs = (end >= start) ?  end.getTime() - start.getTime() : start.getTime() - end.getTime();
    return Math.trunc(timeDiffs / DAY_TIMES)
}

export const addDays = (start:Date, days:number) => {
    const newDate = new Date(start)
    newDate.setDate(start.getDate() + days)
    return newDate
}

export const addWeeks = (start:Date, weeks:number) => {
    const newDate = new Date(start)
    newDate.setDate(start.getDate() +  weeks*7)
    return newDate
}

export const weekDiff = (start:Date, end:Date) => {
    const timeDiffs = (end >= start) ?  end.getTime() - start.getTime() : start.getTime() - end.getTime();
    return Math.trunc(timeDiffs / WEEK_TIMES)
}
