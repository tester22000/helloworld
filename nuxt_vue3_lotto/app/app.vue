<script setup lang="ts">
import {getLastDrawnNo} from '@/utils/lottoUtils'

const lottoState = useLottoResultGlobal();
console.log(`lottoState.value.lastDrwNo=${lottoState.value.lastDrwNo}`)
</script>
<template>
  <nuxtPage/>
</template>
