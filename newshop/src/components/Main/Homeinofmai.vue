<template>
  <el-table
    :data="tableData"
    class="table"
  >

    <el-table-column
      fixed
      prop="name"
      label="买家姓名"
      width="150"
    />
    <el-table-column
      prop="tel"
      label="联系方式"
      width="150"
    />
    <el-table-column
      prop="address"
      label="地址"
      width="500"
    />
    <el-table-column
      fixed="right"
      label="操作"
    >
      <template slot-scope="scope">
        <el-button type="primary" size="small" @click="handleClick(scope.row.name)">售卖</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import Vue from 'vue'
import { Table, TableColumn } from 'element-ui'
/* import request from '/86173/桌面/shop/src/config/request' */
/* import shopSwiper from './ShopSwiper.vue' */

Vue.use(Table).use(TableColumn)
export default {
  data() {
    return {
      tableData: []
    }
  }
  /*   mounted() {
    request.get('/api/cust/get').then(res => {
      this.tableData = res
    })
  },
  methods: {
    handleClick(name) {
      request.put(`/api/hisg/sell/${name}`)
      this.$confirm('售卖成功', '提示', {
        confirmButtonText: '确定',
        type: 'warning',
        center: true
      })
    }

  } */

}
</script>

<style>
    .table{
        position: relative;
        width: 55%;
        height: 550;
        left: 250px;
        top:-600px;
    }
</style>
