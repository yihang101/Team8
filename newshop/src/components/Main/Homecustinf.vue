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
      <template>

        <el-button type="text" @click="table = true">查看购买历史</el-button>
        <el-drawer
          title="我嵌套了表格!"
          :visible.sync="table"
          direction="rtl"
          size="50%"
        >
          <el-table :data="gridData">
            <el-table-column property="date" label="日期" width="150" />
            <el-table-column property="name" label="姓名" width="200" />
            <el-table-column property="address" label="地址" />
          </el-table>
        </el-drawer>

      </template>
    </el-table-column>
  </el-table>

</template>

<script>
export default {
  data() {
    return {
      table: false,
      loading: false,
      gridData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }],
      formLabelWidth: '80px',
      timer: null,

      tableData: [{
        name: 'smm',
        tel: '18358355517',
        address: '浙江工商大学'
      },
      {
        name: 'sjl',
        tel: '139573587456',
        address: '浙江工商大学'
      },
      {
        name: 'jack',
        tel: '13819024645',
        address: '浙江工商大学'
      }
      ]
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
