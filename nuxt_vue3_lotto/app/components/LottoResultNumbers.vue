<script setup lang="ts">
import { type LottoDrawResult } from '@/data/model/lottoDrawResult'
import { ChevronLeftIcon, ChevronRightIcon } from '@heroicons/vue/24/solid'

import { toRef, inject, ref } from 'vue'

interface Props{
    data: LottoDrawResult
}
const props = defineProps<Props>();
const data = toRef(props, 'data');

const drwNo = inject('curDrwNo',ref(data.value.drwNo))

drwNo.value = drwNo.value || data.value.drwNo;

const draw_year = data.value.drwNoDate ? data.value.drwNoDate.substring(0,4) : "";
const draw_month = data.value.drwNoDate ? data.value.drwNoDate.substring(5,7) : "";
const draw_date = data.value.drwNoDate ? data.value.drwNoDate.substring(8,10) : "";

const lottoGrobal = useLottoResultGlobal()

</script>

<template>
    <div class="w-screen">
        <div class="border-1 border-solid border-[#ddd] bg-white text-center mb-[40px] px-[60px] pt-[60px] pb-[90px]">
            <h4 class="text-[28px] font-[300]"><strong class="font-[500] text-[#d43301]">{{data.drwNo}}회</strong> 당첨결과</h4>
            <p class="mt-[9px] font-[300] text-[#767676] leading-[22px] text-[14px]">({{draw_year}}년 {{draw_month}}월 {{draw_date}}일 추첨)</p>
            <div class="inline-block mt-[26px]">
                <NuxtLink v-show="drwNo > 0" class="mt-[40px] float-left" @click="drwNo--">
                    <ChevronLeftIcon class="w-8" />
                </NuxtLink>
                <div class="float-left relative ">
                    <strong class="absolute left-[0] bottom-[-30px] right-[0] text-[16px] font-normal text-[#555]">당첨번호</strong>
                    <p class="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] leading-[22px] text-[#767676] after:content-[''] after:block after:clear-both">
                        <LottoNumber :num=data.drwtNo1 :withMargin=false />
                        <LottoNumber :num=data.drwtNo2 :withMargin=true />
                        <LottoNumber :num=data.drwtNo3 :withMargin=true />
                        <LottoNumber :num=data.drwtNo4 :withMargin=true />
                        <LottoNumber :num=data.drwtNo5 :withMargin=true />
                        <LottoNumber :num=data.drwtNo6 :withMargin=true />
                    </p>
                </div>
                <div class="ml-[60px] float-left relative 
                before:w-[20px] before:h-[4px] before:mt-[-2px] before:ml-[-10px] before:mb-[0px] before:content-[''] before:absolute before:bg-[#999] before:left-[-30px] before:top-[50%] 
                after:w-[4px] after:h-[20px] after:mt-[-10px] after:ml-[-2px] after:mb-[0px] after:content-[''] after:absolute after:left-[-30px] after:top-[50%] after:bg-[#999]">
                    <strong class="absolute left-0 bottom-[-30px] right-0 text-[16px] font-normal text-[#555]">보너스</strong>
                    <p class="p-[30px] rounded-[30px] bg-[#fafafa] font-[300] text-[#767676] leading-[22px] after:content-[''] after:block after:clear-both">
                        <LottoNumber :num=data.bnusNo :withMargin=false />
                    </p>
                </div>
                <NuxtLink v-show="drwNo < lottoGrobal.lastDrwNo" class="mt-[40px] float-right" @click="drwNo++">
                    <ChevronRightIcon class="w-8" />
                </NuxtLink>
            </div>
        </div>
    </div>
</template>