<template>
  <div>
    <div class="toleft">
      <div class="label"><i class="el-icon-lock" />   守护隐私</div>
      <div class="label"><i class="el-icon-receiving" />   用心保护</div>
      <div class="label"><i class="el-icon-truck" />   准时送达</div>
    </div>
    <div class="left">
      <el-radio-group v-model="labelPosition" size="small" />
      <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign" class="form1">
        <h1 style="margin-left:13%;margin-bottom:100px;color:#eba0b3">请填写您的详细信息</h1>
        <el-form-item>
          <i class="el-icon-user" style="font-size:30px" />
          <label style="font-size:25px;color:#2b73af">您的姓名:</label>
          <el-input v-model="formLabelAlign.name" class="right" style="width:20%" clearable />
        </el-form-item>
        <el-form-item>
          <i class="el-icon-goods" style="font-size:30px" />
          <label style="font-size:25px;color:#2b73af">收货地址:</label>
          <el-input v-model="formLabelAlign.address" class="right" style="width:20%" clearable />
        </el-form-item>
        <el-form-item>
          <i class="el-icon-phone" style="font-size:30px" />
          <label style="font-size:25px;color:#2b73af">联系方式:</label>
          <el-input v-model="formLabelAlign.tel" class="right" style="width:20%" clearable />
          <el-form-item>
            <el-button type="success" style="margin-left:220px;margin-top:20px" @click="handleclick">提交信息</el-button>
          </el-form-item>
        </el-form-item></el-form>
    </div>
  </div>
</template>

<script>
import Vue from 'vue'
import { Form, RadioGroup, FormItem, RadioButton, Button, Icon, TimePicker } from 'element-ui'
/* import request from '/86173/桌面/shop/src/config/request.js' */
Vue.use(Form).use(RadioGroup).use(FormItem).use(RadioButton).use(Button).use(Icon).use(TimePicker)
export default {
  data() {
    return {
      labelPosition: 'right',
      formLabelAlign: {
        name: '',
        address: '',
        tel: ''
      }
    }
  },
  methods: {
    handleclick() {
      /*  request.post('/api/cust/insert', this.formLabelAlign)
      this.$router.push('/sell/shopcard') */
    }
  }
}
</script>

<style scoped lang="scss">
.left{
 float:left;
 width: 80%;
 min-height:100vh;
 background: url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fbpic.588ku.com%2Fback_pic%2F05%2F42%2F57%2F955a69db655b1df.jpg&refer=http%3A%2F%2Fbpic.588ku.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1637547009&t=cb4978cb6b82ab01166f219e5198417e');
 background-size: 100% 98%;
}
.footer{
  bottom: 0px;
  height: 10px;
}
.toleft{
  float: left;
    width:20%;
    min-height:100vh;
    background-color: #f0c9cf;
}
.form1{
  width: 1500px;
  margin-left: 500px;
  margin-top: 200px;
}
.label{
  margin-top: 150px;
  font-size: 55px;
color:#61649f;
/*   border:5px solid #ed556a;
 */}
</style>
