<template>
  <div>
    <div class="column">
      <div class="demo-image__lazy">
        <el-image src="https://rescdn.qqmail.com/zh_CN/htmledition/images/webp/tg-silence1e9c5d.jpg" class="pic" />
      </div>
    </div>
    <div class="column1">
      <el-form ref="formdate" class="from" :model="formdate">
        <el-card class="box-card" style="background-image:url('https://rescdn.qqmail.com/zh_CN/htmledition/images/webp/tg-bird1fbc69.png');background-position:-250px -550px;">
          <div slot="header" class="clearfix">
            <div class="block" style="padding-left:200px"><el-avatar :size="50" :src="circleUrl" /></div>
          </div>
          <div>
            <i class="el-icon-user" style="font-size:25px" />
            <label for="">用户名: </label>
            <el-input
              v-model="formdate.name"
              style="width:300px;margin-bottom:30px ;"
              placeholder="请输入用户名"
              clearable
            /></div>
          <div>
            <i class="el-icon-key" style="font-size:25px" />
            <label for=""> 密   码  : </label>
            <el-input
              v-model="formdate.pwd"
              placeholder="请输入密码"
              style="width:300px;margin-bottom:20px "
              show-password
            />
          </div>
          <el-button type="primary" style="margin-left:200px" @click.prevent="login">登录</el-button>
        </el-card>

      </el-form>
    </div>

  </div>
</template>

<script>
import Vue from 'vue'
import { Button, Select, Input, Icon, Image, Card, Avatar } from 'element-ui'
import request from '/src/config/request.js'

Vue.use(Button).use(Select).use(Input).use(Icon).use(Avatar).use(Image).use(Card)
export default {
  components: {
    // shopSwiper
  },
  data() {
    return {
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      imgList: ['https://pic.maizuo.com/usr/movie/91b11879d8071c8fd7285ab36add1828.jpg@1024h_768w_50Q?x-oss-process=image/quality,Q_70', 'https://pic.maizuo.com/usr/movie/cff6d98fbb9303e376219e26b85722af.jpg@1024h_768w_50Q?x-oss-process=image/quality,Q_70', 'https://pic.maizuo.com/usr/movie/b1192f47b486d0addba48084a4741918.jpg@1024h_768w_50Q?x-oss-process=image/quality,Q_70'],
      formdate: {
        name: '',
        pwd: ''
      }
    }
  },
  methods: {
    login() {
      request.post('http://localhost:8081/user/login', this.formdate).then(res => {
        if (res === 1) {
          this.$router.push('/main')
        } else {
          this.$alert('用户名密码错误', '提示', {
            confirmButtonText: '确定'
          })
          this.formdate = Object.assign({}, '')// 重置form表单
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
#nav {
  padding: 30px;
  }
  .column {
  float: left;
  width: 20%;
}
.column1{
  float: right;
  width: 40%;
}
label{
  font-size: 30px;
}
.pic{
  position: fixed;
  top: 30%;
  left: 20%;
}
.from{
  position: fixed;
  top:30%;
  right: 20%;
}

</style>
