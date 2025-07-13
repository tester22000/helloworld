import { getDateFromYmd, getKoreanDate, weekDiff } from "@/app/lib/utils/dateUtils";
import { getLastDrawnNo, getMaxDrawNo, getDrawDate } from "@/app/lib/utils/lottoUtils";

test('lastDrawnNo maxDrawNo', () => {
    const startDate = getDateFromYmd(2002, 12, 7)
    const date = getKoreanDate(new Date())
    const lastNo = getLastDrawnNo()
    const maxNo = getMaxDrawNo()

    console.log(`date=${date}`)
    console.log(`lastNo=${lastNo} maxNo=${maxNo}`)

    if ( date.getDay() != 6) {
        expect( lastNo == maxNo).toBe(false)
    } else {
        expect( lastNo == maxNo).toBe(true)
    }
});


test('getDrawDate', () => {
    const checkDrwNo = 1177
    const expectDrawDate = getDateFromYmd(2025, 6, 21)
    const drawDate = getDrawDate(checkDrwNo)
    console.log(`expectDrawDate=${expectDrawDate} drawDate=${drawDate}`)
    expect(expectDrawDate.getTime() == drawDate.getTime()).toBe(true)
})