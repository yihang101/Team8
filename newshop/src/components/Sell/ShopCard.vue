<template>
  <div class="dv">

    <el-card :body-style="{ padding: '10px' }" class="coloum">
      <img :src="datalist[0].url" class="image">
      <div style="padding: 16px;margin-right:40px">
        <span style="margin-left:35%;font-size:20px;font-weight:bold">{{ datalist[0].name }}</span>
        <div style="margin-left:40%;font-size:20px;font-weight:bold">惊爆价:<el-tag style="font-size:20px;font-weight:bold" effect="dark"> {{ datalist[0].price }}￥ </el-tag>
          <el-button type="primary" round class="button" @click="handleclick">购买</el-button>
        </div>
        <p>{{ datalist[0].information }}</p>
        <div class="bottom clearfix">
          <time class="time">{{ currentDate }}</time>

        </div>
      </div>
    </el-card>
    <div>
      <el-button class="buttons" type="primary" round @click="gotolink">商家入口</el-button>
    </div>
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
  .buttons{
    position: fixed;
    right: 50px;
    bottom: 50px;
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
.dv{
  top: 0px;
   min-height:90vh;
}
  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
.coloum{
    width: 50%;
      left: 30%;
      position: absolute;
      top: 20%;
      background: #ccccd6;
}
  .clearfix:after {
      clear: both
  }
</style>

<script>
import Vue from 'vue'
import request from '/src/config/request.js'
import { Menu, Submenu, MenuItemGroup, MenuItem, Row, Card, Col, Tag, Image } from 'element-ui'

Vue.use(Menu).use(MenuItemGroup).use(MenuItem).use(Submenu).use(Row).use(Card).use(Col).use(Tag).use(Image)
export default {
  data() {
    return {
      currentDate: new Date(),
      price: '288$',
      photo: '',
      datalist: [
        { name: '目前无商品',
          price: '',
          information: 'this is info'
        }
      ]
    }
  },
  mounted() {
  },
  created() {
    request.get('http://localhost:8081/good/get').then(res => {
      console.log(res.data)
      this.datalist = res
    })
  },
  methods: {
    handleclick() {
      this.$router.push('/message')
    },
    Img(url) {
      return require(url)
    },
    gotolink() {
      this.$router.replace('/sell/login')
    }

  }

}
</script>
