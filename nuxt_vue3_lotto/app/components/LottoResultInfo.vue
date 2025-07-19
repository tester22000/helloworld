<script setup lang="ts">
import { type LottoDrawResult } from '@/data/model/lottoDrawResult'
import { numberFormat } from '@/utils/numberUtils';
import { toRef } from 'vue'

interface Props{
    data: LottoDrawResult
}
const props = defineProps<Props>();
const data = toRef(props, 'data');

const style_padding= 'pt-[13px] px-[9px] pb-[15px] '
const style_th = 'bg-[#f5f5f5] font-normal leading-[22px]'
const style_td = 'bg-[#fff] font-[#767676] font-[300] leading-[22px] font-normal leading-[22px] align-middle'
const style_line = "border-b-[1px] border-b-[#ddd] border-l-[1px] border-l-[#ddd] border-solid"
</script>

<template>
        <table className="w-full table-fixed border-t-[1px] border-solid border-t-[#333]">
            <colgroup>
                <col className="w-[85px]"/>
                <col />
                <col className="w-[145px]"/>
                <col />
            </colgroup>
            <thead>
                <tr>
                    <th :class="[style_padding, style_th, style_line]" scope="col">순위</th>
                    <th :class="[style_padding, style_th, style_line]" scope="col">등위별 총 당첨금액</th>
                    <th :class="[style_padding, style_th, style_line]" scope="col">당첨게임 수</th>
                    <th :class="[style_padding, style_th, style_line]" scope="col">1게임당 당첨금액</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td :class="[style_padding, style_th, style_line, 'text-center']">1등</td>
                    <td :class="[style_padding, style_th, style_line, 'text-end']"><strong class="font-[300] text-[#d43301]">{{ numberFormat(data.firstAccumamnt)}}원</strong></td>
                    <td :class="[style_padding, style_th, style_line, 'text-center']">{{data.firstPrzwnerCo}}</td>
                    <td :class="[style_padding, style_th, style_line, 'text-end']">{{numberFormat(data.firstWinamnt)}}원</td>
                </tr>
            </tbody>
        </table>
</template>