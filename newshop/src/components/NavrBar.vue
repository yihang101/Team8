<template>
  <div>
    <el-row class="tac">
      <el-col :span="12" style="border-right: 1px solid black;">
        <el-menu
          style="min-height:90vh"
          default-active="2"
          class="el-menu-vertical-demo"
          background-color="#ede3e7"
          text-color="#7a7374"
          active-text-color="#2d0c13"
        >
          <!-- <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-location" />
              <span>导航一</span>
            </template>
            </el-submenu> -->
          <el-menu-item index="1">
            <template slot="title">
              <router-link to="/sell/shopcard" tag="li">
                <i class="el-icon-menu" />
                <span>商品详情</span>
              </router-link>
            </template>
          </el-menu-item>
          <!--   <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项1</el-menu-item>
            </el-submenu> -->

          <!-- <el-menu-item index="2">
            <router-link to="/sell/login" tag="li">
              <i class="el-icon-menu" />
              <span>商家入口</span>
            </router-link>
          </el-menu-item> -->
          <!-- <el-menu-item index="3">
            <router-link to="/sell/reset" tag="li">
              <i class="el-icon-document" />
              <span>忘记密码</span>
            </router-link>
          </el-menu-item> -->
          <!-- <el-menu-item index="4">
            <i class="el-icon-setting" />
            <span slot="title">导航四</span>
          </el-menu-item> -->
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import Vue from 'vue'
import { Menu, Submenu, MenuItemGroup, MenuItem, Row } from 'element-ui'

Vue.use(Menu).use(MenuItemGroup).use(MenuItem).use(Submenu).use(Row)
export default {

}
</script>

<style scoped>
span{
  font-size: 20px;
  font-weight: 800;
}
</style>
