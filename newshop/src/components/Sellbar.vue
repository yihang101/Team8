<template>
  <div>
    <el-menu
      style="width:150px; min-height: 90vh;"
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1">
        <template slot="title">
          <router-link to="/person/custlishi" tag="li">
            <i class="el-icon-menu" />
            <span style="">历史订单</span>
          </router-link>
        </template>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/person/ShopCart" tag="li">
          <i class="el-icon-menu" />
          <span>查看购物车</span>
        </router-link>
      </el-menu-item>
    </el-menu>

  </div>

</template>

<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style>

</style>
