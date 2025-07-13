import { getLottoDrawResult } from "@/app/lib/external/lottoservice";

test('get lotto result', async () => {
    let result = await getLottoDrawResult(1177)
    expect(result.drwNo == 1177).toBe(true)
    result = await getLottoDrawResult(1176)
    expect(result.drwNo == 1176).toBe(true)
})