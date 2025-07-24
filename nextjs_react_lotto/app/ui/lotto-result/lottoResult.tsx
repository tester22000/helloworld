'use client'

import Link from 'next/Link'
import LottoNumber from "@/components/lottoNum"
import { type LottoDrawResultModel } from '@/data/model/lottoDrawResultModel';
import { ChevronLeftIcon, ChevronRightIcon } from '@heroicons/react/24/solid'

// export function LottoResult({data, changeDrwNo} : {data: LottoDrawResultModel, changeDrwNo: Function}) {
export function LottoResult({
    data, 
    changeDrwNo, 
    lastDrwNo} : {
        data: LottoDrawResultModel, 
        changeDrwNo: Function,
        lastDrwNo: number
    }) {
    const draw_year = data ?  data.drwNoDate.substring(0,4) : 0;
    const draw_month = data? data.drwNoDate.substring(5,7) : 0;
    const draw_date = data? data.drwNoDate.substring(8,10) : 0;

    const drwNo = data ? data.drwNo  : lastDrwNo;
    const nextResult = () => {
        changeDrwNo(drwNo+1);
    }
    const prevResult = () => {
        changeDrwNo(drwNo-1);
    }

    const createDrwNoURL = (num: number) => {
        return `/?drwNo=${num}`
    }
    return (
        <div className="w-screen">
            <div className="border-1 border-solid border-[#ddd] bg-white text-center mb-[40px] px-[60px] pt-[60px] pb-[90px]">
                <h4 className="text-[28px] font-[300]"><strong className="font-[500] text-[#d43301]">{data ? data.drwNo : ""}회</strong> 당첨결과</h4>
                <p className="mt-[9px] font-[300] text-[#767676] leading-[22px] text-[14px]">({draw_year}년 {draw_month}월 {draw_date}일 추첨)</p>
                <div className="inline-block mt-[26px]">
                    { drwNo > 0 &&
                    <Link href="#" className="mt-[40px] float-left" onClick={prevResult}>
                        <ChevronLeftIcon className="w-8" />
                    </Link>
                    }
                    <div className="float-left relative ">
                        <strong className="absolute left-[0] bottom-[-30px] right-[0] text-[16px] font-normal text-[#555]">당첨번호</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] leading-[22px] text-[#767676] after:content-[''] after:block after:clear-both">
                            <LottoNumber num={data ? data.drwtNo1 : 0} withMargin={false} />
                            <LottoNumber num={data ? data.drwtNo2 : 0} withMargin={true} />
                            <LottoNumber num={data ? data.drwtNo3 : 0} withMargin={true} />
                            <LottoNumber num={data ? data.drwtNo4 : 0} withMargin={true} />
                            <LottoNumber num={data ? data.drwtNo5 : 0} withMargin={true} />
                            <LottoNumber num={data ? data.drwtNo6 : 0} withMargin={true} />
                        </p>
                    </div>
                    <div className="ml-[60px] float-left relative 
                    before:w-[20px] before:h-[4px] before:mt-[-2px] before:ml-[-10px] before:mb-[0px] before:content-[''] before:absolute before:bg-[#999] before:left-[-30px] before:top-[50%] 
                    after:w-[4px] after:h-[20px] after:mt-[-10px] after:ml-[-2px] after:mb-[0px] after:content-[''] after:absolute after:left-[-30px] after:top-[50%] after:bg-[#999]">
                        <strong className="absolute left-0 bottom-[-30px] right-0 text-[16px] font-normal text-[#555]">보너스</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] text-[#767676] leading-[22px] after:content-[''] after:block after:clear-both">
                            <LottoNumber num={data ? data.bnusNo : 0} withMargin={false} />
                        </p>
                    </div>
                    { drwNo < lastDrwNo && 
                    <Link href="#" className="mt-[40px] float-right" onClick={nextResult}>
                        <ChevronRightIcon className="w-8" />
                    </Link>
                    }
                </div>
            </div>
        </div>
    )
}