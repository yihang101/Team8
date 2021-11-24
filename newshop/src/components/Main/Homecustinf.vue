<template>

  <el-table
    :data="tableData"
    style="width: 70%;"
    max-height="650px"
    class="table1"
    :header-cell-style="{background:'#eff3f6'}"
  >

    <el-table-column
      fixed
      prop="name"
      label="客户名称"
      width="150"
    />
    <el-table-column
      prop="tel"
      label="联系方式"
      width="250"
    />
    <el-table-column
      prop="address"
      label="默认交易地址"
    />
    <el-table-column
      fixed="right"
      label="操作"
      width="150"
    >
      <template slot-scope="scope">
        <el-button type="primary" size="small" @click="handleClick(scope.row.name)">查看购买历史</el-button>
      </template>
    </el-table-column>
  </el-table>

</template>

<script>
export default {
  data() {
    return {
      tableData: [{
      }]
      /* FormData: {
        name: ''
      } */

    }
  },
  mounted() {
    /* request.get('/api/cust/get').then(res => {
      this.tableData = res
    }) */
  },
  methods: {
    handleClick(name) {
      /* this.FormData.name = name
      console.log(this.FormData)
      request.post('/api/hisg/find', this.FormData) */
      this.$router.push('/main/Homecustlishi')
    }

  }

}
</script>

<style>
.table1{
  position: absolute;
  left: 12%;
  top:18%
}

</style>
