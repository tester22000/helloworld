import { 
    getDateFromYmd ,
    getKoreanDate,
    weekDiff,
    addWeeks
} from "@/app/lib/utils/dateUtils"

const START_DATE = getDateFromYmd(2002, 12, 7)
const DRAW_HOUR_MIN = 2045
const DATE_SATURDAY = 6

function isBeforeDrawTime(date: Date) {
    return (date.getHours() * 100 + date.getMinutes()) < DRAW_HOUR_MIN
}

export const getLastDrawnNo = () => {
    const date = getKoreanDate(new Date());
    const drwNo = weekDiff(START_DATE, date) + 1
    if (date.getDay() != DATE_SATURDAY || !isBeforeDrawTime(date)){
        return drwNo
    }
    return drwNo - 1
}

export const getMaxDrawNo = () => {
    const date = getKoreanDate(new Date());
    const drwNo = weekDiff(START_DATE, date) + 1
    return   date.getDay() != DATE_SATURDAY ?  drwNo + 1 : drwNo
}

export const getDrawDate = (drwNo: number) => {
    return addWeeks(START_DATE, drwNo-1)
}
