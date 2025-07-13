import { getLottoDrawResult } from "@/app/lib/external/lottoservice";
import { getLottoResult, insertLottoResult, deleteLottoResult } from "@/app/lib/db/lotto_result";

test('lotto_result_db', async () =>{
    const testDrwNo = 1000;
    await deleteLottoResult(testDrwNo)
    expect(await getLottoResult(testDrwNo)).toBe(null)
    const drawResult = await getLottoDrawResult(testDrwNo)
    if (drawResult) {
        await insertLottoResult(drawResult)
    }
    const lottoResult = await getLottoResult(testDrwNo)
    console.log(JSON.stringify(lottoResult))
    expect(lottoResult).not.toBe(null)
    expect(lottoResult.drwNo).toBe(testDrwNo)
    await deleteLottoResult(testDrwNo)
    expect(await getLottoResult(testDrwNo)).toBe(null)
})