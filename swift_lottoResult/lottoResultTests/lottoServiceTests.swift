
import Testing
@testable import lottoResult

struct LottoServiceTests {

    @Test("get lotto draw result") func testDrawDate() async throws {
        // Write your test here and use APIs like `#expect(...)` to check expected conditions.
        let testDrwNo = 1178
        let result = try? await LottoService.getLottoDrawResult(testDrwNo)
        #expect(result != nil)
        #expect(result?.drwNo == testDrwNo)
        let testDrwNo2 = 4000
        let result2 = try? await LottoService.getLottoDrawResult(testDrwNo2)
        #expect(result2 == nil)
    }
}
