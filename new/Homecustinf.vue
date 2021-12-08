<template>
  <div class="main0">
    <div class="main1">
      <el-table
        :data="tableData"
        style="width: 85%;"
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
          <el-button type="text" @click="table = true">查看购买历史</el-button>
        </el-table-column>
      </el-table>
    </div>
    <el-drawer
      :modal="false"
      title="购买历史"
      :visible.sync="table"
      direction="rtl"
      size="50%"
    >
      <el-table :data="gridData">
        <el-table-column property="name" label="商品名称" width="150" />
        <el-table-column property="price" label="商品价格" width="150" />
        <el-table-column property="information" label="商品详情" />
      </el-table>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      table: false,
      loading: false,
      gridData: [{
        name: '苹果',
        price: '18.8',
        information: '香甜可口'
      }, {
        name: '匹克鞋子',
        price: '299',
        information: '耐穿舒适'
      }, {
        name: '奥妙洗衣凝胶',
        price: '29.8',
        information: '护肤不伤衣，去渍效果强'
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
  left: 15%;
  top:13%
}
.main1{
  position: absolute;
  top: 12%;
  width: 80%;
  height: 90%;
}
.main0{
  position: absolute;
  top: 0%;
  width: 100%;
  height: 80%;
}
</style>
