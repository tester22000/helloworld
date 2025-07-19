import {getLottoDrawResult} from '#server/service/lottoResultService'
import {getLastDrawnNo} from '@/utils/lottoUtils'

export default defineEventHandler(async (event) => {
    try {
        const drwNo = getLastDrawnNo();
        return await getLottoDrawResult(drwNo);
    } catch (err) {
        if (err instanceof Error) {
            throw createError({
                statusCode: 500,
                statusMessage: err.message,
            })
        }
    }

})