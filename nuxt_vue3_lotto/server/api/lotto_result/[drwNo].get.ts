import {getLottoDrawResult} from '#server/service/lottoResultService'
import {getLastDrawnNo} from '@/utils/lottoUtils'
import { getRouterParam } from 'h3';

export default defineEventHandler(async (event) => {
    try {
        const drwNo = Number(getRouterParam(event, 'drwNo') || getLastDrawnNo());
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