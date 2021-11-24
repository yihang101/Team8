<template>
  <el-table
    :data="tableData"
    class="table3"
    :header-cell-style="{background:'#eff3f6'}"
  >
    <el-table-column
      fixed
      prop="goodname"
      label="商品名称"
      width="150"
    />
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
        <el-button type="primary" size="small" @click="handleClick(scope.row.name,scope.row.goodname)">售卖</el-button>
      </template>
    </el-table-column>
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
      }],
      FormData: {
        goodname: '',
        name: ''
      }

    }
  },
  mounted() {
    request.get('/api/cust/get').then(res => {
      this.tableData = res
    })
  },
  methods: {
    handleClick(name, goodname) {
      this.FormData.goodname = goodname
      this.FormData.name = name
      console.log(this.FormData)
      request.post('/api/hisg/find', this.FormData)
      this.$confirm('售卖成功', '提示', {
        confirmButtonText: '确定',
        type: 'warning',
        center: true
      })
    }

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
