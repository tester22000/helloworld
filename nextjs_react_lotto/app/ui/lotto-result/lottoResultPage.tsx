'use client'

import { useState, useEffect } from "react"
import { useSearchParams } from 'next/navigation';
import { getLastDrawnNo } from '@/utils/lottoUtils'
import { type LottoDrawResultModel } from '@/data/model/lottoDrawResultModel';
import { LottoResultInfo } from "@/app/ui/lotto-result/lottoResultInfo";
import {LottoResult} from '@/app/ui/lotto-result/lottoResult'

export default function LottoResultPage() {
    const searchParams = useSearchParams();
    const drwNoInitial = searchParams.get('drwNo') ? parseInt(searchParams.get('drwNo')) : getLastDrawnNo();
    const [drwNo, setDrwNo] = useState<number>(drwNoInitial);
    const[data, setData] = useState<LottoDrawResultModel>(null);
    const[lastDrwNo, setLastDrwNo] = useState<number>(getLastDrawnNo());

    useEffect(() => {
        async function fetchData() {
            const url = `/api/lotto_result?drwNo=${drwNo}`;
            const response = await fetch(url);
            const lottoResult = await response.json() as LottoDrawResultModel;
            setData(lottoResult);            
        }
        fetchData();
    },[drwNo]);

    const changeDrwNo = (newDrwNo : number) => {
        setDrwNo(newDrwNo);
    };

    return (
        <main>
            <div className="inline-block relative">
                
                <LottoResult changeDrwNo={changeDrwNo} data={data} lastDrwNo={lastDrwNo}/>
                <LottoResultInfo data={data}/>
            </div>
        </main>
    )
}