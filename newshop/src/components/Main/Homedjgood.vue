<template>
  <el-table
    :data="tableData"
    class="table3"
    :header-cell-style="{background:'#eff3f6'}"
  >
    <el-table-column
      fixed
      prop="
    url"
      label="商品图片"
      width="250"
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
      label="商品信息"
      width="380"
    />
    <el-table-column
      prop="condition"
      label="商品状态"
      width="120"
    />
    <el-table-column
      fixed="right"
      label="操作"
      width="150"
    >
      <template slot-scope="scope">
        <el-button type="primary" size="small" @click="dongJie(scope.row.id)">冻结</el-button>
        <el-button type="primary" size="small" @click="jieDong(scope.row.id)">解冻</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import request from '/src/config/request.js'
export default {
  data() {
    return {
      tableData: [{
        id: '',
        url: 'https://img2.baidu.com/it/u=3547734642,2083669832&fm=26&fmt=auto',
        name: '奥妙洗衣凝珠',
        price: '18.88',
        information: '护衣不伤衣，除渍效果强',
        condition: '未冻结'
      }]
    }
  },
  mounted() {
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
  }

}
</script>

<style lang="scss" scoped>
.table3{
    position: absolute;
    width: 70%;
    height: 600px;
    left: 12%;
    top: 18%;
}

</style>
