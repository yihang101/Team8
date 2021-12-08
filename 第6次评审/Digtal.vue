<template>
  <div id="box" class="dv">
    <input type="text" placeholder="请搜索" @input="searchAction($event)">
    <ul v-if="searchResult.length>0">
      <li v-for="(v,index) in searchResult" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" type="primary" round class="button">购买</el-button>
        <!--  <el-card :body-style="{ padding: '10px' }" class="coloum">
          <img :src="datalist[index].url" class="image">
          <div style="padding: 16px;margin-right:40px">
            <span style="margin-left:35%;font-size:20px;font-weight:bold">{{ datalist[index].name }}</span>
            <div style="margin-left:40%;font-size:20px;font-weight:bold">惊爆价:<el-tag style="font-size:20px;font-weight:bold" effect="dark"> {{ datalist[index].price }}￥ </el-tag>
              <el-button type="primary" round class="button" @click="handleclick">购买</el-button>
            </div>
            <p>{{ datalist[index].information }}</p>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
            </div>
          </div>
        </el-card> -->
      </li>
    </ul>

    <ul v-else>
      <li v-for="(v,index) in datalist" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" type="primary" round class="button">购买</el-button>
      </li>
    </ul>
  </div>
</template>

<style>
  .time {
    font-size: 15px;
    color: #999;
    margin-top: 10%;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    margin-left: 5%;
  }

  .image {
    width: 50%;
    display: block;
    position: relative;
  left: 210px;
  }
input{
  position: relative;
  left: 420px;
  top:5px;
  width:300px;
  text-align: center;
  font-size: 20px;
}
  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
.coloum{
    width: 50%;
      left: 170px;
      position: relative;
      top: 40px;
      background: #ccccd6;
}
  .clearfix:after {
      clear: both
  }
  .login{
    float: right;
    margin-bottom: 0px;
    margin-right: 100px;
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
	#box img{
		width: 200px;
		height: 150px;
	}
  h4{
    text-align: center;
  }
  p{
    text-align: center;
  }
</style>

<script>
import Vue from 'vue'
/* import request from '/86173/桌面/shop/src/config/request.js' */
import { Menu, Submenu, MenuItemGroup, MenuItem, Row, Card, Col, Tag } from 'element-ui'
import { throttle } from '../libs/utils'
Vue.use(Menu).use(MenuItemGroup).use(MenuItem).use(Submenu).use(Row).use(Card).use(Col).use(Tag)
export default {
  data() {
    return {
      searchResult: [],
      currentDate: new Date(),
      price: '288$',
      datalist: [
        { name: 'PS5(限量)',
          price: 10888,
          url: 'https://p6.itc.cn/images01/20210318/a1794aecc70b49bb88f0a7d8cfdf640c.png',
          information: '商品有限，先到先得'
        },
        { name: '华为折叠屏手机',
          price: 9888,
          url: 'https://i04piccdn.sogoucdn.com/b3146a50eafb65b3',
          information: '创新科技，全新体验'
        }, { name: '索爱蓝牙音箱',
          price: 128,
          url: 'https://i03piccdn.sogoucdn.com/fe4ac4d71f6e06a8',
          information: '完美音质，便携好用'
        },
        { name: '三星相机',
          price: 588,
          url: 'https://i01piccdn.sogoucdn.com/b20b6d4070e58122',
          information: '高清像素，功能多样'
        }
      ]
    }
  },
  mounted() {
    /*  request.get('/api/hisg/get').then(res => {
      this.datalist = res
    }) */
  },
  methods: {
    handleclick() {
      this.$router.push('/message')
    },
    searchAction: throttle(function(e) {
      const inputValue = e.target.value

      this.searchResult = this.datalist.filter((item) => {
        if (item.name.includes(inputValue)) {
          return item
        }
      })
    }, 1000)
  }

}
</script>
<style>
ul{
  margin-top:65px ;
  overflow:scroll;
  height: 850px;
}
input {
      border: 2px solid #B8B8B8;
      height: 40px;
      width: 15%;
      font-size: 16px;
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
</style>
