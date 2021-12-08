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
        { name: '天然榉木碗',
          price: 18.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.99114.com%2Fgroup1%2FM00%2FBF%2F1D%2FwKgGS1kXbB-ABY_3AAFMmGV770I881_600_600.jpg&refer=http%3A%2F%2Fimg1.99114.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452345&t=d2d6f955fcd76a4e6f74327966798569',
          information: '天然卫生，易清洁'
        },
        { name: '环保牙杯',
          price: 28.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimgx.xiawu.com%2Fxzimg%2Fi3%2F429312012%2FO1CN01UkzlY61QjXRKlSb5w_%21%21429312012.jpg&refer=http%3A%2F%2Fimgx.xiawu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452283&t=b0be9348882a6b673358e6d49488f213',
          information: '全新环保材料'
        }, { name: '手工收纳篮',
          price: 12.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.tbw-xie.com%2FtuxieJDEwLmFsaWNkbi5jb20vaTQvMzA2NDI4OTg1Mi9PMUNOMDEyTWVHVkhYMTVwem9JVTNfISEzMDY0Mjg5ODUyJDk.jpg&refer=http%3A%2F%2Fwww.tbw-xie.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452438&t=b649f165fba81a128260d1c3f1af3734',
          information: '节省空间，居家必备'
        },
        { name: '纽扣杯垫',
          price: 8.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcbu01.alicdn.com%2Fimg%2Fibank%2F2015%2F799%2F073%2F2588370997_1668506035.jpg&refer=http%3A%2F%2Fcbu01.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452518&t=c98b3936cf6a6418491c6bf0da265712',
          information: '隔热好物'
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
