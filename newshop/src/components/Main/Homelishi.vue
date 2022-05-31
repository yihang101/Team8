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
      width="400"
    />

    <el-table-column
      label="售后"
      width="150"
    >
      <template slot-scope="scope">
        <el-button v-if="scope.row.flag===1" class="copl">处理</el-button>
        <div v-else>否</div>
      </template>
    </el-table-column>

    <el-table-column
      prop="customer"
      label="买家"
      width="150"
    />
  </el-table>

</template>

<script>
import Vue from 'vue'
import { Table, TableColumn, Button } from 'element-ui'
import request from '/src/config/request.js'
/* import shopSwiper from './ShopSwiper.vue' */

Vue.use(Table).use(TableColumn).use(Button)
export default {
  data() {
    return {
      tableData: [{
        url: 'https://img0.baidu.com/it/u=1239475587,3702728625&fm=26&fmt=auto',
        name: '苹果',
        price: '7.8',
        information: '香甜可口',
        customer: 'jack',
        flag: 1
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
  .copl{
    background-color:springgreen ;
    color: black;
  }
</style>
