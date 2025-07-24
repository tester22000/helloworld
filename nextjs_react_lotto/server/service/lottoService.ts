'use server'
import { getLastDrawnNo } from '@/utils/lottoUtils'
import { getLottoResult , insertLottoResult } from '@/server/data/repository/lottoRequestRepository'
import { getLottoDrawResultFromService } from '@/server/service/external/lottoExternalService'
import { type LottoDrawResultModel } from '@/data/model/lottoDrawResultModel';

export async function getLottoDrawResult(drwNo : number) : Promise<LottoDrawResultModel | undefined>  {
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