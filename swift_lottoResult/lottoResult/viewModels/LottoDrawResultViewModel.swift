import SwiftUI

@Observable
class LottoDrawResultViewModel {
    var drwNo: Int? {
        didSet {
            Task {
                try? await fetchLottoDrawResult()
            }
        }
    }
    var drawData: LottoDrawData?
}

extension LottoDrawResultViewModel {
    func fetchLottoDrawResult() async throws {
        self.drawData = try? await LottoService.getLottoDrawResult(drwNo!)
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
