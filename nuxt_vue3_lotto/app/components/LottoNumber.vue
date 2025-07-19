<script setup lang="ts">
import { ref, toRefs, useCssModule } from 'vue'

interface Props{
  num: number;
  withMargin?: boolean;
}
const props = withDefaults(defineProps<Props>(),{
  num:0,
  withMargin: false
})

const {num, withMargin} = toRefs(props);

const $style = useCssModule();
const ball_styles = [
  $style.ball1,
  $style.ball2,
  $style.ball3,
  $style.ball4,
  $style.ball5,
  $style.ball6,
]


const selectedStyle = ball_styles[Math.floor(num.value / 10)];
const marginStyle = withMargin?.value ? "ml-[20px]" : "";

</script>

<template>
  <span :class="[
      'float-left',
      marginStyle,
      $style.ball_645,
      $style.lrg,
      selectedStyle]">
      {{num}}
  </span>
</template>

<style module>
@import '@styles/lottoball.module.css';
</style>