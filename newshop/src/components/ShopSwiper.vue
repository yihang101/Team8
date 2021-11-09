<template>
  <div class="swiper-container">
    <div class="swiper-wrapper">
      <slot />
    </div>
    <div class="swiper-pagination" />
  </div>
</template>

<script>
import Swiper from 'swiper/bundle'
import 'swiper/swiper-bundle.min.css'
export default {
  mounted() {
    new Swiper('.swiper-container', {
      /*     slidesPerView: 1,
      spaceBetween: 30,
      freeMode: true, */
      pagination: {
        el: '.swiper-pagination'
      }
    })
  }
}
</script>

<style scoped lang="scss">

</style>
