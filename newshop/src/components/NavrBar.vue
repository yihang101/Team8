<template>
  <el-row>
    <el-col :span="11">
      <el-menu
        style="width:200px; min-height: 90vh;"
        :default-active="$route.path"
        class="el-menu-vertical-demo"
        router
        background-color="#545c64"
        @open="handleOpen"
        @close="handleClose"
      >

        <el-menu-item index="/Sell/host">
          <i class="el-icon-s-home" />
          <span slot="title">商城主页</span>
        </el-menu-item>
        <el-menu-item index="/Sell/use">
          <i class="el-icon-document" />
          <span slot="title">生活用品</span>
        </el-menu-item>
        <el-menu-item index="/Sell/food">
          <i class="el-icon-menu" />
          <span slot="title"> 食品</span>
        </el-menu-item>
        <el-menu-item index="/Sell/shopcard">
          <i class="el-icon-goods" />
          <span slot="title">衣物</span>
        </el-menu-item>
        <el-menu-item index="/Sell/digtal">
          <i class="el-icon-setting" />
          <span slot="title">电器</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</template>

<script>
import Vue from 'vue'
import { Menu, Submenu, MenuItemGroup, MenuItem, Row } from 'element-ui'

Vue.use(Menu).use(MenuItemGroup).use(MenuItem).use(Submenu).use(Row)
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

<style scoped>
span{
  font-size: 20px;
}
</style>
