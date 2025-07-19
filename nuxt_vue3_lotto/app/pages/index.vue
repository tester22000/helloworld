<script setup  lang="ts">
import { useRoute } from 'vue-router'
import { getLastDrawnNo } from '@/utils/lottoUtils'

const route = useRoute()
const drwNo = Number(route.query.drwNo) || getLastDrawnNo();
</script>

<template>
  <main>
    <div class="inline-block relative">
      <Suspense>
          <template #default>
            <LottoResult :drwNo=drwNo />
          </template>
          <template #fallback>
            <LottoResultFallBack />
          </template>
      </Suspense>
    </div>
  </main>
</template>