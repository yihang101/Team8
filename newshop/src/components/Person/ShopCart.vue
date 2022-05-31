<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 83%"
      @selection-change="selected"
    >
      <el-table-column
        type="selection"
        width="50"
      />
      <el-table-column
        label="商品名称"
        width="680"
      >
        <template scope="scope">
          <div style="margin-left: 50px">
            <img :src="scope.row.goods.img" style="height: 50px;width: 50px">
            <span style="font-size: 18px;padding-left: 200px;">{{ scope.row.goods.descript }}</span>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label="单价"
        width="150"
        prop="price"
      />
      <el-table-column
        label="数量"
        width="200"
      >
        <template scope="scope">
          <div>
            <el-input
              v-model="scope.row.number"
              @change="handleInput(scope.row)"
            >
              <el-button slot="prepend" @click="del(scope.row)"><i class="el-icon-minus" /></el-button>
              <el-button slot="append" @click="add(scope.row)"><i class="el-icon-plus" /></el-button>
            </el-input>
          </div>
        </template>
      </el-table-column>
      <el-table-column
        label="小计"
        width="150"
        prop="goodTotal"
      />
      <el-table-column label="操作">
        <template scope="scope">
          <el-button type="danger" @click="handleDelete(scope.$index, scope.row)">
            删除<i class="el-icon-delete2 el-icon--right" />
          </el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <el-button type="info" style="float: right">{{ "商品总额：" + moneyTotal }}</el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        goods: {
          img: 'http://i1.mifile.cn/a1/pms_1474859997.10825620!80x80.jpg',
          descript: '小米手环2'
        },
        price: 149,
        number: 1,
        goodTotal: 149
      }, {
        goods: {
          img: 'http://i1.mifile.cn/a1/pms_1482321199.12589253!80x80.jpg',
          descript: '小米活塞耳机 清新版 黑色'
        },
        price: 29,
        number: 1,
        goodTotal: 29
      }, {
        goods: {
          img: 'http://i1.mifile.cn/a1/pms_1468288696.74437986!80x80.jpg',
          descript: '米家LED随身灯 增强版 蓝色'
        },
        price: 14.9,
        number: 1,
        goodTotal: 14.9
      }, {
        goods: {
          img: 'http://i1.mifile.cn/a1/pms_1476688193.46995320.jpg?width=140&height=140',
          descript: '10000mAh小米移动电源2 银色'
        },
        price: 79,
        number: 1,
        goodTotal: 79
      }],
      moneyTotal: 0,
      multipleSelection: []
    }
  },
  methods: {
    handleDelete(index, row) {
      this.$confirm('确定删除该商品？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 删除数组中指定的元素
        this.tableData.splice(index, 1)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    handleInput: function(value) {
      if (value.number == null || value.number === '') {
        value.number = 1
      }
      value.goodTotal = (value.number * value.price).toFixed(2)// 保留两位小数
      // 增加商品数量也需要重新计算商品总价
      this.selected(this.multipleSelection)
    },
    add: function(addGood) {
      // 输入框输入值变化时会变为字符串格式返回到js
      // 此处要用v-model，实现双向数据绑定
      if (typeof addGood.number === 'string') {
        addGood.number = parseInt(addGood.number)
      }
      addGood.number += 1
    },
    del: function(delGood) {
      if (typeof delGood.number === 'string') {
        delGood.number = parseInt(delGood.number)
      }
      if (delGood.number > 1) {
        delGood.number -= 1
      }
    },
    // 返回的参数为选中行对应的对象
    selected: function(selection) {
      this.multipleSelection = selection
      this.moneyTotal = 0
      // 此处不支持forEach循环，只能用原始方法了
      for (var i = 0; i < selection.length; i++) {
        // 判断返回的值是否是字符串
        if (typeof selection[i].goodTotal === 'string') {
          selection[i].goodTotal = parseInt(selection[i].goodTotal)
        }
        this.moneyTotal += selection[i].goodTotal
      }
    } }

}
</script>
