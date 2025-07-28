import Foundation
import SwiftData

final class LottoDrawResultRepository {
    private let modelContext: ModelContext
    
    init(modelContext: ModelContext) {
        self.modelContext = modelContext
    }
    
    func addLottoResult(_ lottoDrawResult : LottoDrawResultModel) {
        modelContext.insert(lottoDrawResult)
        do {
            try modelContext.save()
        } catch {
            print(error)
        }
    }
    
    func getLottoResult(_ drwNo: Int) -> LottoDrawResultModel? {
        let predicate = #Predicate<LottoDrawResultModel>{ $0.drwNo == drwNo}
        do {
            let fetchDescriptor = FetchDescriptor<LottoDrawResultModel>(predicate: predicate)
            let fetchResult = try modelContext.fetch(fetchDescriptor)
            return fetchResult.first
        } catch {
            return nil;
        }
    }
    
    func deleteLottoResult(_ drwNo: Int) {
        if let model = getLottoResult(drwNo) {
            modelContext.delete(model)
            do {
                try modelContext.save()
            } catch {
                
            }
        }
    }
    
}
