<template>
  <div>
    <headline />
    <navbar class="column1" />
    <router-view />
  </div>
</template>

<script>
import navbar from './NavrBar.vue'
import headline from './Title.vue'
export default {
  components: {
    navbar,
    headline
  }
}
</script>

<style scoped lang="scss">
  .column1 {
  float: left;
  width: 20%;
}
 .toleft {
    float: left;
    width: 60%
    }
</style>
