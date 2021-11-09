<template>
  <el-table
    :data="tableData"
    class="table"
  >
    <el-table-column
      fixed
      prop="url"
      label="商品图片"
      width="250"
    />
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
      label="商品信息"
      width="400"
    />
    <el-table-column
      prop="condition"
      label="商品状态"
      width="120"
    />
    <el-table-column
      fixed="right"
      label="操作"
      width="120"
    >
      <template slot-scope="scope">
        <el-button type="text" size="small" @click="dongJie(scope.row.id)">冻结</el-button>
        <el-button type="text" size="small" @click="jieDong(scope.row.id)">解冻</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
/* import request from '/86173/桌面/shop/src/config/request.js' */
export default {
  data() {
    return {
      tableData: [{
        id: '',
        url: '',
        name: '',
        price: '',
        information: '',
        condition: ''
      }]
    }
  }
  /*  mounted() {
    request.get('/api/good/get').then(res => {
      this.tableData = res
    })
  }, methods: {
    dongJie(id) {
      request.put(`/api/good/ice/${id}`)
      request.get('/api/good/get').then(res => {
        this.tableData = res
      })
    },
    jieDong(id) {
      request.put(`/api/good/reice/${id}`)
      request.get('/api/good/get').then(res => {
        this.tableData = res
      })
    }
  } */

}
</script>

<style>
.table{
    position: relative;
    width: 70%;
    height: 600px;
    margin-left: 25px;
    margin-top: -40px;
}
</style>
