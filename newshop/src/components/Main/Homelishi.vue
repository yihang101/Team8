<template>
  <div>
    <el-table
      :data="tableData"
      style="width: 70%;"
      max-height="550px"
      class="table"
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
        width="150"
      />
      <el-table-column
        prop="price"
        label="商品价格"
        width="120"
      />
      <el-table-column
        prop="information"
        label="商品详情"
        width="300"
      />
      <el-table-column
        prop="customer"
        label="买家"
        width="100"
      />
    </el-table>
  </div>

</template>

<script>
import Vue from 'vue'
import { Table, TableColumn } from 'element-ui'
import request from '/86173/桌面/shop/src/config/request'
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
.table{
  position: relative;
  margin-left: 30px;
  margin-top: 120px;
}
</style>
