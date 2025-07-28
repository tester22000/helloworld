import SwiftUI

@Observable
class LottoDrawResultViewModel {
    private var lottoService : LottoService
    @MainActor init() {
        self.lottoService = LottoService.shared
    }
    var drwNo: Int? {
        didSet {
            Task {
                try? await fetchLottoDrawResult()
            }
        }
    }
    var drawData: LottoDrawResultModel?
}

extension LottoDrawResultViewModel {
    func setLottoService(lottoService: LottoService){
        self.lottoService = lottoService
    }
    func fetchLottoDrawResult() async throws {
        self.drawData = try? await lottoService.getLottoDrawResult(drwNo!)
    }
    func hasPrevious() -> Bool {
        guard let drwNo = drwNo else { return false }
        return drwNo > 1
    }
    func hasNext() -> Bool {
        guard let drwNo = drwNo else { return false }
        return drwNo < lastDrawnNo()
    }
    func inc() {
        if hasNext() {
            drwNo = drwNo! + 1
        }
    }
    func dec() {
        if hasPrevious() {
            drwNo = drwNo! - 1
        }
    }
}
