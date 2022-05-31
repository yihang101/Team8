<template>
  <div>
    <Title />
    <sellbar class="column1" />
    <router-view class="item" />
  </div>
</template>

<script>
import Sellbar from './Sellbar.vue'
import Title from './Title.vue'
export default {
  components: { Sellbar, Title }

}
</script>

<style>
.item{
  position:relative;
  margin-top: 50px;
  margin-left: 100px;
}
  .column1 {
  float: left;
  width: 20%;
}
  *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
  }
</style>
