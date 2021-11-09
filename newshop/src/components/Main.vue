<template>
  <div>
    <headline />
    <daohang />
    <router-view class="item" />
  </div>

</template>

<script>
import Daohang from './Daohang.vue'
import Headline from './Headline.vue'
/* import Headline from './components/Headline.vue' */

export default {

  components: {
    Daohang,
    Headline
  }
}
</script>

<style>
.item{
  position:relative;
  margin-top: 50px;
  margin-left: 100px;
}
  *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
  }

</style>
