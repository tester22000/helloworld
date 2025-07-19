import {type LottoDrawResult} from '@/data/model/lottoDrawResult'
import {getLastDrawnNo} from '@/utils/lottoUtils'

const LOTTO_CHECK_BASE_URL = 'https://www.dhlottery.co.kr/common.do'

export async function getLottoDrawResultFromService(drawNo?: number): Promise<LottoDrawResult | null> {
    const checkDrawNo = drawNo ? drawNo : getLastDrawnNo()
    return new Promise( async (resolve, reject) => {
        try {
            const res = await $fetch<string>(LOTTO_CHECK_BASE_URL, {
                query : {
                    method: 'getLottoNumber',
                    drwNo: checkDrawNo
                }
            })
            resolve(JSON.parse(res) as LottoDrawResult)
            //resolve(res)
        } catch (error) {
            console.log(error)
        }
        resolve(null)
    })
}
