import { createLottoResult} from '#server/data/repository/lottoDrawResultRepository'

export default defineEventHandler(async (event) => {
    try {
        await createLottoResult()
        return { message: 'Database seeded successfully' }
    } catch (err) {
        if (err instanceof Error) {
            throw createError({
                statusCode: 500,
                statusMessage: err.message,
            })
        }
    }

})