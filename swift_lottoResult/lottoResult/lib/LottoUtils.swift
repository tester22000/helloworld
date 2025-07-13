import Foundation

private let START_DATE = Date.from(year:2002, month:12, day:7)!
private let DRAW_HOUR_MIN = 2045

func getDrawNo() -> Int {
    return Date.totalWeeks(from: START_DATE, to: Date()) + 1
}

func lastDrawnNo() -> Int {
    let drwNo = getDrawNo()
    let currentDate = Date()
    let dateComponent = Calendar.current.dateComponents([.weekday, .hour, .minute], from: currentDate)
    if Calendar.current.dateComponents([.weekday], from: currentDate).weekday != 6 {
        return drwNo
    }
    if dateComponent.hour! * 100 + dateComponent.minute! < DRAW_HOUR_MIN {
        return drwNo - 1
    }
    return drwNo
}

func getMaxDrawNo() -> Int {
    let drwNo = getDrawNo()
    let currentDate = Date()
    let dateComponent = Calendar.current.dateComponents([.weekday, .hour, .minute], from: currentDate)
    if dateComponent.weekday != 6 {
        return drwNo + 1
    }
    return drwNo
}

func getDrawDate(_ drwNo: Int) -> String {
    return Date.addWeeks(from: START_DATE, weeks: drwNo-1).getYYYYMMDD()
}
