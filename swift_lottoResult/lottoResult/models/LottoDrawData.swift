struct LottoDrawData : Identifiable, Decodable {
    let returnValue : String
    let drwNoDate : String
    let totSellamnt: UInt64
    let firstWinamnt: UInt64
    let firstPrzwnerCo: Int
    let firstAccumamnt: UInt64
    let drwtNo1: Int
    let drwtNo2: Int
    let drwtNo3: Int
    let drwtNo4: Int
    let drwtNo5: Int
    let drwtNo6: Int
    let bnusNo: Int
    let drwNo: Int

    var id : Int { drwNo }
}

extension LottoDrawData {
    static let RETURN_VALUE_SUCCESS = "success"
}
