'use server'
import { getLastDrawnNo } from '@/app/lib/utils/lottoUtils'
import { getLottoResult , insertLottoResult } from '@/app/lib/db/lotto_result'
import { getLottoDrawResultFromService } from '@/app/lib/external/lottoservice'
import { LottoDrawResult } from './domain'

export async function getLottoDrawResult(drwNo : number) : Promise<LottoDrawResult | undefined>  {
   const lastDrawnNo = getLastDrawnNo()
   const getDrawwNo = drwNo <= lastDrawnNo ? drwNo: lastDrawnNo
   const fromDb = await getLottoResult(getDrawwNo)
   if (!fromDb) {
      const fromService = await getLottoDrawResultFromService(getDrawwNo)
      if ( fromService ) {
         await insertLottoResult(fromService)
         return fromService
      }
      throw Error('Data get Error')
   }
   return fromDb
}