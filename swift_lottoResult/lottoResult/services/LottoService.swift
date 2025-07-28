import SwiftUI
import SwiftData

struct LottoService {
    private let modelContainer: ModelContainer
    private let modelContext: ModelContext
    private var repository : LottoDrawResultRepository
    
    @MainActor static let shared = LottoService()
    
    @MainActor private init() {
        let storeURL = URL.documentsDirectory.appending(path:"lotto.sqlite.db")
        self.modelContainer = try! ModelContainer(
            for: LottoDrawResultModel.self,
            configurations: ModelConfiguration(url: storeURL)
        )
        self.modelContext = modelContainer.mainContext
        self.repository = LottoDrawResultRepository(modelContext: modelContext)
    }
    
    func getLottoDrawResult(_ drwNo: Int) async -> LottoDrawResultModel? {
        guard let model = repository.getLottoResult(drwNo) else {
            do {
                if let model = try await LottoExternalService.getLottoDrawResult(drwNo) {
                    repository.addLottoResult(model)
                    return model
                }
            } catch {}
            return nil
        }
        return model
    }
    
}
