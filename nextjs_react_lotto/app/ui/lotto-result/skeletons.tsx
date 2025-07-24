'use client'

// Loading animation
const shimmer =
    'before:absolute before:inset-0 before:-translate-x-full before:animate-[shimmer_2s_infinite] before:bg-gradient-to-r before:from-transparent before:via-white/60 before:to-transparent';

export function LottoResultSkeleton( {drwNo} : {drwNo: number}) {
    return (
        <div className={`${shimmer} w-screen`}>
            <div className="border-1 border-solid border-[#ddd] bg-white text-center mb-[40px] px-[60px] pt-[60px] pb-[90px]">
                <h4 className="text-[28px] font-[300]"></h4>
                <p className="mt-[9px] font-[300] text-[#767676] leading-[22px] text-[14px]"></p>
                <div className="inline-block mt-[26px]">
                    <div className="float-left relative ">
                        <strong className="absolute left-[0] bottom-[-30px] right-[0] text-[16px] font-normal text-[#555]">당첨번호</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] leading-[22px] text-[#767676] after:content-[''] after:block after:clear-both">
                        </p>
                    </div>
                    <div className="ml-[60px] float-left relative 
                    before:w-[20px] before:h-[4px] before:mt-[-2px] before:ml-[-10px] before:mb-[0px] before:content-[''] before:absolute before:bg-[#999] before:left-[-30px] before:top-[50%] 
                    after:w-[4px] after:h-[20px] after:mt-[-10px] after:ml-[-2px] after:mb-[0px] after:content-[''] after:absolute after:left-[-30px] after:top-[50%] after:bg-[#999]">
                        <strong className="absolute left-0 bottom-[-30px] right-0 text-[16px] font-normal text-[#555]">보너스</strong>
                        <p className="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] text-[#767676] leading-[22px] after:content-[''] after:block after:clear-both">
                        </p>
                    </div>
                </div>
            </div>
        </div>
    )
}
