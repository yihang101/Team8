<template>
  <div class="">
    <div class="button1">
      <el-button type="primary" @click="back">返回</el-button>
    </div>
    <div>
      <el-table
        :data="tableData"
        style="width: 70%;"
        max-height="600px"
        class="table4"
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
      </el-table>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        url: '',
        name: '',
        price: '',
        information: ''
      }]
    }
  },
  mounted() {
    /* request.get('/api/hisg/get').then(res => {
      console.log(res)
      this.tableData = res
    }) */
  },
  methods: {
    back() {
      this.$router.push('/sell/custlogin')
    }
  }
}
</script>

<style>
.table4{
  position: absolute;
  left: 17%;
  top: 25%;
}
.button1{
  position: absolute;
  bottom: 5%;
  right: 5%;
}
</style>
