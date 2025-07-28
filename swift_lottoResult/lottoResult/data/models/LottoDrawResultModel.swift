import SwiftData

@Model
final class LottoDrawResultModel : Identifiable, Decodable {
    var returnValue : String
    var drwNoDate : String
    var totSellamnt: UInt64
    var firstWinamnt: UInt64
    var firstPrzwnerCo: Int
    var firstAccumamnt: UInt64
    var drwtNo1: Int
    var drwtNo2: Int
    var drwtNo3: Int
    var drwtNo4: Int
    var drwtNo5: Int
    var drwtNo6: Int
    var bnusNo: Int
    var drwNo: Int

    var id : Int { drwNo }
    
    init(returnValue: String, drwNoDate: String, totSellamnt: UInt64, firstWinamnt: UInt64, firstPrzwnerCo: Int, firstAccumamnt: UInt64, drwtNo1: Int, drwtNo2: Int, drwtNo3: Int, drwtNo4: Int, drwtNo5: Int, drwtNo6: Int, bnusNo: Int, drwNo: Int) {
        self.returnValue = returnValue
        self.drwNoDate = drwNoDate
        self.totSellamnt = totSellamnt
        self.firstWinamnt = firstWinamnt
        self.firstPrzwnerCo = firstPrzwnerCo
        self.firstAccumamnt = firstAccumamnt
        self.drwtNo1 = drwtNo1
        self.drwtNo2 = drwtNo2
        self.drwtNo3 = drwtNo3
        self.drwtNo4 = drwtNo4
        self.drwtNo5 = drwtNo5
        self.drwtNo6 = drwtNo6
        self.bnusNo = bnusNo
        self.drwNo = drwNo
    }
   
    enum CodingKeys : String, CodingKey {
        case returnValue
        case drwNoDate
        case totSellamnt
        case firstWinamnt
        case firstPrzwnerCo
        case firstAccumamnt
        case drwtNo1
        case drwtNo2
        case drwtNo3
        case drwtNo4
        case drwtNo5
        case drwtNo6
        case bnusNo
        case drwNo
    }
    
    required init(from decoder: Decoder) throws {
        let container = try decoder.container(keyedBy: CodingKeys.self)
        self.returnValue = try container.decode(String.self, forKey: .returnValue)
        self.drwNoDate = try container.decode(String.self, forKey: .drwNoDate)
        self.totSellamnt = try container.decode(UInt64.self, forKey: .totSellamnt)
        self.firstWinamnt = try container.decode(UInt64.self, forKey: .firstWinamnt)
        self.firstPrzwnerCo = try container.decode(Int.self, forKey: .firstPrzwnerCo)
        self.firstAccumamnt = try container.decode(UInt64.self, forKey: .firstAccumamnt)
        self.drwtNo1 = try container.decode(Int.self, forKey: .drwtNo1)
        self.drwtNo2 = try container.decode(Int.self, forKey: .drwtNo2)
        self.drwtNo3 = try container.decode(Int.self, forKey: .drwtNo3)
        self.drwtNo4 = try container.decode(Int.self, forKey: .drwtNo4)
        self.drwtNo5 = try container.decode(Int.self, forKey: .drwtNo5)
        self.drwtNo6 = try container.decode(Int.self, forKey: .drwtNo6)
        self.bnusNo = try container.decode(Int.self, forKey: .bnusNo)
        self.drwNo = try container.decode(Int.self, forKey: .drwNo)
    }

        func encode(to encoder: Encoder) throws {
            var container = encoder.container(keyedBy: CodingKeys.self)
            try container.encode(returnValue, forKey: .returnValue)
            try container.encode(drwNoDate, forKey: .drwNoDate)
            try container.encode(totSellamnt, forKey: .totSellamnt)
            try container.encode(firstWinamnt, forKey: .firstWinamnt)
            try container.encode(firstPrzwnerCo, forKey: .firstPrzwnerCo)
            try container.encode(firstAccumamnt, forKey: .firstAccumamnt)
            try container.encode(drwtNo1, forKey: .drwtNo1)
            try container.encode(drwtNo2, forKey: .drwtNo2)
            try container.encode(drwtNo3, forKey: .drwtNo3)
            try container.encode(drwtNo4, forKey: .drwtNo4)
            try container.encode(drwtNo5, forKey: .drwtNo5)
            try container.encode(drwtNo6, forKey: .drwtNo6)
            try container.encode(bnusNo, forKey: .bnusNo)
            try container.encode(drwNo, forKey: .drwNo)
        }
}

extension LottoDrawResultModel {
    static let RETURN_VALUE_SUCCESS = "success"
}
