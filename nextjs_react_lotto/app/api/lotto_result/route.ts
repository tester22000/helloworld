import type { NextRequest } from 'next/server'
import { getLottoDrawResult } from '@/server/service/lottoService'
import { getLastDrawnNo} from '@/utils/lottoUtils'

export async function GET(request: NextRequest) {
  try {
    const searchParams = request.nextUrl.searchParams;
    const drwNo = searchParams.get('drwNo') ?  parseInt(searchParams.get('drwNo') ) : getLastDrawnNo();

    console.log('drwNo=${drwNo');
    const result = await getLottoDrawResult(drwNo);

    return new Response(JSON.stringify(result), {
      status: 200,
      headers: {
        'Content-Type': 'application/json',
      },
    });
  } catch (error) {
    console.error('Error fetching data:', error);
    return new Response(JSON.stringify({ message: 'Internal Server Error' }), {
      status: 500,
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }
}