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
      prop="custname"
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
    />
    <el-table-column
      prop="number"
      label="购买数量"
      width="100"
    />
    <el-table-column
      fixed="right"
      label="操作"
    >
      <template>
        <el-button
          type="primary"
          size="small"
          @click="handleClick"
        >{{ statename }}</el-button>，
        <el-button
          type="primary"
          size="small"
          @click="handle2Click"
        > 取消订单 </el-button>
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
      statename: '售卖',
      tableData: [{
        goodname: '奥妙洗衣凝珠',
        custname: 'smm',
        tel: '139576958451',
        address: '浙江工商大学',
        state: ' 下单',
        number: '2 '
      }],
      FormData: {
        goodname: '',
        custname: '',
        number: ' ',
        state: ' '
      }

    }
  },
  mounted() {
    request.get('/api/cust/get').then(res => {
      this.tableData = res
    })
  },
  methods: {
    handleClick(custname, goodname, number) {
      this.FormData.goodname = goodname
      this.FormData.custname = custname
      this.FormData.number = number
      console.log(this.FormData)

      if (this.statename === '售卖') {
        this.$confirm('操作成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        },
        this.statename = '确认订单'
        )
      } else if (this.statename === '确认订单') {
        this.$confirm('操作成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        },
        this.statename = '备货完成'
        )
      } else if (this.statename === '备货完成') {
        this.$confirm('操作成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        },
        this.statename = '开始发货'
        )
      } else {
        this.$confirm('售卖失败', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        })
      }
    },
    handle2Click(custname, goodname, number) {
      this.FormData.goodname = goodname
      this.FormData.custname = custname
      this.FormData.number = number
      if (this.statename === '开始发货') {
        this.$confirm('不可取消', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        }
        )
      } else {
        // console.log(this.FormData)
      //  request.post('/api/hisg/find', this.FormData).then(res => {})
        this.$confirm('取消成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        }
        )
      }
    }
  }
}
</script>

<style>
.table3 {
  position: absolute;
  width: 70%;
  height: 600px;
  left: 12%;
  top: 18%;
}
</style>
