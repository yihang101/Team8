<template>
  <div id="box" class="dv">
    <div class="button2">
      <el-button type="primary" class="shoucang" @click="goback">返回</el-button>
    </div>
    <ul v-if="searchResult.length>0" class="ul">
      <li v-for="(v,index) in searchResult" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：$   {{ v.price }}</p>
        <el-button type="danger" @click="handleDelete">
          删除<i class="el-icon-delete2 el-icon--right" />
        </el-button>
        <el-button type="danger" @click="addgouwuche">
          加入购物车<i class="el-icon-delete2 el-icon--right" />
        </el-button>
      </li>
    </ul>

    <ul v-else class="ul">
      <li v-for="(v,index) in datalist" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：$   {{ v.price }}</p>
        <el-button type="danger" @click="handleDelete(datalist[index].number)">
          删除<i class="el-icon-delete2 el-icon--right" />
        </el-button>
        <el-button type="danger" @click="addgouwuche(datalist[index].id)">
          加入购物车<i class="el-icon-delete2 el-icon--right" />
        </el-button>
      </li>
    </ul>
  </div>
</template>

<style>
.ul{
  margin-top:65px ;
  overflow:scroll;
  height: 850px;
}
  ::-webkit-scrollbar {
	width: 6px;
	height: 8px;
	background-color: white;
}

/*定义滚动条轨道 内阴影+圆角*/
::-webkit-scrollbar-track {
	border-radius: 10px;
	background-color: #F5F5F5;
}

/*定义滑块 内阴影+圆角*/
::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: #9E9E9E;
}
  #box ul{
		display: flex;
		flex-wrap: wrap;
	}
  #box li{
		padding: 3px;
		list-style: none;
		margin-right: 15px;
    height: 300px;
		border: 1px solid #eee;
	}
  .input{
  position: relative;
  left: 420px;
  top:5px;
  width:300px;
  text-align: center;
  font-size: 20px;
       border: 2px solid #B8B8B8;
      height: 40px;
      width: 15%;
      font-size: 16px;
}
  #box img{
		width: 200px;
		height: 150px;
	}
    .image {
    width: 50%;
    display: block;
    position: relative;
  left: 210px;
  }
    h4{
    text-align: center;
  }
  p{
    text-align: center;
  }
</style>

<script>
import request from '/src/config/request.js'
export default {
  data() {
    return {
      goodid: '',
      custid: '',
      searchResult: [],
      currentDate: new Date(),
      option: '',
      datalist: [
        { id: '',
          number: '',
          name: '天然榉木碗',
          price: 18.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.99114.com%2Fgroup1%2FM00%2FBF%2F1D%2FwKgGS1kXbB-ABY_3AAFMmGV770I881_600_600.jpg&refer=http%3A%2F%2Fimg1.99114.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452345&t=d2d6f955fcd76a4e6f74327966798569',
          information: '天然卫生，易清洁'
        }
      ],
      FormData: {
        custid: '',
        goodid: ''

      }
    }
  },
  mounted() {
    this.custid = this.$route.query.custid
    request.get(`/api/collect/getcollect/${this.custid}`).then(res => {
      console.log(res)
      this.datalist = res
    })
  },
  methods: {
    goback() {
      this.custid = this.$route.query.custid
      this.$router.push({
        path: '/Sell/Custlishi',
        query: {
          custid: this.custid
        }
      })
    },
    handleDelete(id) {
      console.log(id)
      this.$confirm('确定删除该商品？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        // 删除数组中指定的元素
        request.delete(`/api/collect/cancelcollect/${id}`).then(res => {})
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
    addgouwuche(id) {
      this.FormData.custid = this.$route.query.custid
      this.FormData.goodid = id
      console.log(this.FormData)
      this.$confirm('确定加入购物车？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        request.post('/api/buycar/addbuycar', this.FormData).then(res => {})
        // 删除数组中指定的元素
        this.$message({
          type: 'success',
          message: '加入成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消加入'
        })
      })
    },
    handleclick() {
      this.$router.push('/message')
    }
  }

}
</script>

