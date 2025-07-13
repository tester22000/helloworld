'use server'

import type { LottoDrawResult } from '@/app/lib/domain'
import { getLastDrawnNo } from '@/app/lib/utils/lottoUtils'
import axios from 'axios'

const LOTTO_CHECK_BASE_URL = 'https://www.dhlottery.co.kr/'

export async function getLottoDrawResultFromService(drawNo?: number): Promise<LottoDrawResult | undefined> {
    const checkDrawNo = drawNo ? drawNo : getLastDrawnNo()

    try {
        const res = await axios.get('https://www.dhlottery.co.kr/common.do', {
            params: {
                method: 'getLottoNumber',
                drwNo: checkDrawNo
            },
        })
        if (res.status == 200)
            return res.data
    } catch (error) {
        console.log(error)
    }
    return null
}