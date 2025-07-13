
import Testing
@testable import lottoResult

struct lottoUtilsTests {

    @Test("drwNo DrawDate ") func testDrawDate() async throws {
        // Write your test here and use APIs like `#expect(...)` to check expected conditions.
        let testDrwNo = 1178
        let drwDate = getDrawDate(testDrwNo)
        #expect(drwDate == "2025-06-28")
    }


}
