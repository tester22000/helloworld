import Foundation

struct LottoService {
    
    static func getLottoDrawResult(_ drwNo: Int) async throws -> LottoDrawData? {
        let url = URL(string: "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=\(drwNo)")!
        let (data, _) = try await URLSession.shared.data(from: url)
        let decoder = JSONDecoder()
        do {
            let lottoDrawResult = try decoder.decode(LottoDrawData.self, from: data)
            if lottoDrawResult.returnValue == LottoDrawData.RETURN_VALUE_SUCCESS {
                return lottoDrawResult
            }
            return nil
        } catch {
            print("decode error \(error)")
        }
        return nil
    }
}
