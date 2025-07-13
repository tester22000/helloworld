import LottoNumber from "@/app/ui/lotto/lottoNum"
import { Suspense } from "react"
import { LottoResultSkeleton } from '@/app/ui/skeletons'
import { getLastDrawnNo } from '@/app/lib/utils/lottoUtils'
import LottoResultWrapper from '@/app/ui/lotto/lottoResult'

export default async function Page(props: {
    searchParams?: Promise<{
        drwNo: string;
    }>;
}) {
    const searchParams = await props.searchParams;
    const drwNo = searchParams?.drwNo ? parseInt(searchParams?.drwNo) : getLastDrawnNo();


    const createDrwNoURL = (num: number) => {
        return `/?drwNo=${num}`
    }

    return (
        <main>
            <div className="inline-block relative">
                <Suspense fallback={<LottoResultSkeleton drwNo={drwNo} />}>
                    <LottoResultWrapper drwNo={drwNo} />
                </Suspense>
            </div>
        </main>
    )
}