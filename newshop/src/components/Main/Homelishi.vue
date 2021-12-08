<template>

  <el-table
    :data="tableData"
    class="table3"
    max-height="600px"
    :header-cell-style="{background:'#eff3f6'}"
  >

    <el-table-column
      fixed
      prop="url"
      label="商品图片"
      width="300"
    >
      <template slot-scope="scope">
        <img :src="scope.row.url" min-width="70" height="70">
      </template>
    </el-table-column>
    <el-table-column
      prop="name"
      label="商品名称"
      width="200"
    />
    <el-table-column
      prop="price"
      label="商品价格"
      width="150"
    />
    <el-table-column
      prop="information"
      label="商品详情"
    />
    <el-table-column
      prop="customer"
      label="买家"
      width="150"
    />
  </el-table>

</template>

<script>
import Vue from 'vue'
import { Table, TableColumn } from 'element-ui'
import request from '/src/config/request.js'
/* import shopSwiper from './ShopSwiper.vue' */

Vue.use(Table).use(TableColumn)
export default {
  data() {
    return {
      tableData: [{
        url: '',
        name: '',
        price: '',
        information: '',
        customer: ''
      }]
    }
  },
  mounted() {
    request.get('/api/hisg/get').then(res => {
      console.log(res)
      this.tableData = res
    })
  }
}
</script>

<style>
.table3{
    position: absolute;
    width: 70%;
    height: 600px;
    left: 12%;
    top: 18%;
  }
</style>
