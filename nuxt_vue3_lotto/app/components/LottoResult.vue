<script async setup lang="ts">
import { ref , provide } from 'vue'
import {type LottoDrawResult} from '@/data/model/lottoDrawResult'

interface Props{
    drwNo?: number;
}
const props = defineProps<Props>();

const lastDrwNo = useLottoResultGlobal().value.lastDrwNo
const drwNo = ref(props.drwNo || lastDrwNo);
const url = `/api/lotto_result/${drwNo.value}`
const data = ref({} as LottoDrawResult)

//const { data, refresh } = await useAsyncData<LottoDrawResult>("useTest", () =>  $fetch(url));
data.value = await $fetch<LottoDrawResult>(url);

provide("curDrwNo",drwNo)


watch(drwNo, async(newDrwNo) => {
    if (newDrwNo) {
        const url = `/api/lotto_result/${newDrwNo}`
        //const { data, refresh } = await useAsyncData<LottoDrawResult>("uddtkkk", () =>  $fetch(url));
        data.value = await $fetch<LottoDrawResult>(url);
    }
},{ immediate: true})
</script>
<template>
    <div>
        <LottoResultNumbers :data=data! />
        <LottoResultInfo :data=data! />
    </div>
</template>