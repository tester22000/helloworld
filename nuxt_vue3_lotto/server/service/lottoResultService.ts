import {LottoDrawResult} from '@/data/model/lottoDrawResult'
import {getLottoResult, insertLottoResult} from '#server/data/repository/lottoDrawResultRepository'
import {getLottoDrawResultFromService} from '#server/service/external/lottoExternalService'
import {getLastDrawnNo} from '@/utils/lottoUtils'

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
      throw Error('Internal Error')
   }
   return fromDb
}
