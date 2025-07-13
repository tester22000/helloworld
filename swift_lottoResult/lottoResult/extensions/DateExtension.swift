import Foundation

extension Date {
    static func from(year: Int, month: Int, day:Int) -> Date? {
        let calendar = Calendar(identifier: .gregorian)
        var dateComponents = DateComponents()
        dateComponents.year = year
        dateComponents.month = month
        dateComponents.day = day
        return calendar.date(from: dateComponents) ?? nil
    }
    static func totalWeeks(from: Date, to: Date) -> Int {
        Calendar.current.dateComponents([.weekOfMonth], from:from, to: to).weekOfMonth!
    }
    
    static func totalDays(from: Date, to: Date) -> Int {
        Calendar.current.dateComponents([.day], from:from, to: to).day!
    }
    
    static func addDays(from: Date, days: Int) -> Date {
        return Calendar.current.date(byAdding: DateComponents(day: days), to: from)!
    }
    
    static func addWeeks(from: Date, weeks: Int) -> Date {
        return Calendar.current.date(byAdding: DateComponents(weekOfMonth: weeks), to: from)!
    }

    func getYYYYMMDD() -> String {
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "yyyy-MM-dd"
        return dateFormatter.string(from: self)
    }
}
