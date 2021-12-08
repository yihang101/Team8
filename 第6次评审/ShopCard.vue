<template>
  <div id="box" class="dv">
    <input type="text" placeholder="请搜索" @input="searchAction($event)">
    <ul v-if="searchResult.length>0">
      <li v-for="(v,index) in searchResult" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" type="primary" round class="button" @click="buy()">购买</el-button>
      </li>
    </ul>

    <ul v-else>
      <li v-for="(v,index) in datalist" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：   {{ v.price }}</p>
        <el-button style="margin-left:53px;" type="primary" round class="button" @click="buy()">购买</el-button>
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
       border: 2px solid #B8B8B8;
      height: 40px;
      width: 15%;
      font-size: 16px;
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
        { name: '耐克运动鞋-1',
          price: 588,
          url: 'https://img.alicdn.com/imgextra/i3/92688455/O1CN01YjCDwW2CKRS3NTHzK_!!92688455.jpg_430x430q90.jpg',
          information: '9折优惠，欢迎选购'
        },
        { name: '安踏潮鞋1992-2',
          price: 388,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqny.smzdm.com%2F202003%2F11%2F5e68a6423e7254287.jpg_d250.jpg&refer=http%3A%2F%2Fqny.smzdm.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640234043&t=9b971472acdf9c58eebe0e7f67a6ec6a',
          information: '全新配色，潮男必备'
        }, { name: '匹克M-1',
          price: 788,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fy.zdmimg.com%2F202006%2F07%2F5edbe1a8166d12983.jpg_d250.jpg&refer=http%3A%2F%2Fy.zdmimg.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1640234064&t=e78cbec1e43c54088a50bc0d16af704b',
          information: '野场利器，不可错过'
        },
        { name: '乔丹aj-1',
          price: 888,
          url: 'https://i01piccdn.sogoucdn.com/88a7919d512b230f',
          information: '时尚搭配，限时优惠'
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
    buy() {
      this.$router.push('shopf')
    },
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
    }, 3000)
  }

}
</script>
<style>
ul{
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
</style>
