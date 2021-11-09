<template>
  <div>
    <el-menu
      style="width:200px; min-height: 90vh;"
      default-active="2"
      class="el-menu-vertical-demo"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
    >
      <el-menu-item index="1">
        <template slot="title">
          <router-link to="/main" tag="li">
            <i class="el-icon-menu" />
            <span>历史商品</span>
          </router-link>
        </template>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/main/Homefabugood" tag="li">
          <i class="el-icon-menu" />
          <span>发布商品</span>
        </router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <template slot="title">
          <router-link to="/main/Homeinofmai" tag="li">
            <i class="el-icon-menu" />
            <span>查看买家信息</span>
          </router-link>
        </template>
      </el-menu-item>
      <el-menu-item index="4">
        <router-link to="/main/Homedjgood" tag="li">
          <i class="el-icon-menu" />
          <span>冻结商品</span>
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
