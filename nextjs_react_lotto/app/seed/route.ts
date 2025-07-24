import { createLottoResult } from '@/server/data/repository/lottoRequestRepository'

export async function GET() {
    try {
        await createLottoResult()
        return Response.json({ message: 'Database seeded successfully' });
    } catch (err) {
        return Response.json({ err }, { status: 500 });
    }
}