import Link from 'next/Link'
import LottoNumber from "./lottoNum"
import { LottoDrawResult } from "@/app/lib/domain"
import { getLottoDrawResult } from '@/app/lib/actions'
import { LottoResultInfo } from "./lottoResultInfo"
import { getLastDrawnNo } from '@/app/lib/utils/lottoUtils'
import { ChevronLeftIcon, ChevronRightIcon } from '@heroicons/react/24/solid'


export default async function LottoResultWrapper( {drwNo} : {drwNo : number}) {
    const lottoResult = await getLottoDrawResult(drwNo)
    return (
        <>
        <LottoResult data={lottoResult}/>
        <LottoResultInfo data={lottoResult}/>
        </>
    )
}


export function LottoResult({data} : {data: LottoDrawResult}) {
    const draw_year = data.drwNoDate.substring(0,4)
    const draw_month = data.drwNoDate.substring(5,7)
    const draw_date = data.drwNoDate.substring(8,10)
    const lastDrwNo = getLastDrawnNo()

    const drwNo = data.drwNo
    const createDrwNoURL = (num: number) => {
        return `/?drwNo=${num}`
    }
    return (
        <div className="w-screen">
            <div className="border-1 border-solid border-[#ddd] bg-white text-center mb-[40px] px-[60px] pt-[60px] pb-[90px]">
                <h4 className="text-[28px] font-[300]"><strong className="font-[500] text-[#d43301]">{data.drwNo}회</strong> 당첨결과</h4>
                <p className="mt-[9px] font-[300] text-[#767676] leading-[22px] text-[14px]">({draw_year}년 {draw_month}월 {draw_date}일 추첨)</p>
                <div className="inline-block mt-[26px]">
                    { drwNo > 0 &&
                    <Link href={createDrwNoURL(drwNo - 1)} className="mt-[40px] float-left">
                        <ChevronLeftIcon className="w-8" />
                    </Link>
                    }
                    <div className="float-left relative ">
                        <strong className="absolute left-[0] bottom-[-30px] right-[0] text-[16px] font-normal text-[#555]">당첨번호</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] leading-[22px] text-[#767676] after:content-[''] after:block after:clear-both">
                            <LottoNumber num={data.drwtNo1} withMargin={false} />
                            <LottoNumber num={data.drwtNo2} withMargin={true} />
                            <LottoNumber num={data.drwtNo3} withMargin={true} />
                            <LottoNumber num={data.drwtNo4} withMargin={true} />
                            <LottoNumber num={data.drwtNo5} withMargin={true} />
                            <LottoNumber num={data.drwtNo6} withMargin={true} />
                        </p>
                    </div>
                    <div className="ml-[60px] float-left relative 
                    before:w-[20px] before:h-[4px] before:mt-[-2px] before:ml-[-10px] before:mb-[0px] before:content-[''] before:absolute before:bg-[#999] before:left-[-30px] before:top-[50%] 
                    after:w-[4px] after:h-[20px] after:mt-[-10px] after:ml-[-2px] after:mb-[0px] after:content-[''] after:absolute after:left-[-30px] after:top-[50%] after:bg-[#999]">
                        <strong className="absolute left-0 bottom-[-30px] right-0 text-[16px] font-normal text-[#555]">보너스</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] text-[#767676] leading-[22px] after:content-[''] after:block after:clear-both">
                            <LottoNumber num={data.bnusNo} withMargin={false} />
                        </p>
                    </div>
                    { drwNo < lastDrwNo && 
                    <Link href={createDrwNoURL(drwNo + 1)} className="mt-[40px] float-right">
                        <ChevronRightIcon className="w-8" />
                    </Link>
                    }
                </div>
            </div>
        </div>
    )
}