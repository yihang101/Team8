<template>
  <div id="box">
    <input type="text" placeholder="请搜索" class="input" @input="searchAction($event)">
    <ul v-if="searchResult.length>0" class="ul">
      <li v-for="(v,index) in searchResult" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" class="button">购买</el-button>
      </li></ul>

    <ul v-else class="ul">
      <li v-for="(v,index) in datalist" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" class="button">购买</el-button>
      </li></ul>
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
export default {
  data() {
    return {
      searchResult: [],
      datalist: [
        { name: '新鲜草莓',
          price: 28.8,
          url: 'https://img2.baidu.com/it/u=3385841003,1992474648&fm=26&fmt=auto',
          information: '新鲜草莓，厂家直发'
        },
        { name: '牛角包',
          price: 8.8,
          url: 'https://img1.baidu.com/it/u=3349008787,676681666&fm=26&fmt=auto',
          information: '精心烘焙，尽享美味'
        }, { name: '每日坚果',
          price: 12.8,
          url: 'https://img0.baidu.com/it/u=259586349,2717684003&fm=26&fmt=auto',
          information: '营养坚果，元气每天'
        },
        { name: '三文鱼派',
          price: 58.8,
          url: 'https://img1.baidu.com/it/u=1210134805,2875221101&fm=26&fmt=auto',
          information: '新鲜营养'
        }
      ]
    }
  },
  methods: {
    searchAction(e) {
      const inputValue = e.target.value

      this.searchResult = this.datalist.filter((item) => {
        if (item.name.includes(inputValue)) {
          return item
        }
      })
    }
  }
}
</script>
