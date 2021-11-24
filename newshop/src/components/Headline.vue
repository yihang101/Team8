<template>
  <div
    style="height: 100px; line-height:50px; border-bottom: 1px solid black;display: flex;
  background-color:#cad3c3"
  >
    <div style=" width:250px; padding-left:30px; font-weight: bold; font-size:30px; color: #141e1b;margin-top:20px ">卖家管理系统</div>
    <div style=" flex:1" />
    <div style=" width:100px;margin-top:20px">
      <template>
        <el-button type="text" @click="open()">修改密码</el-button>
      </template>
    </div>
  </div>

</template>

<script>
import request from '/src/config/request.js'
import Vue from 'vue'
import { Menu, Submenu, MenuItemGroup, MenuItem, Row } from 'element-ui'

Vue.use(Menu).use(MenuItemGroup).use(MenuItem).use(Submenu).use(Row)
export default {
  data() {
    return {
      res: ''
    }
  },
  methods: {
    open() {
      this.$prompt(
        '请输入新密码',
        '提示',
        {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          inputValue: '',
          inputErrorMessage: '输入不能为空',
          inputValidator: (value) => { // 点击按钮时，对文本框里面的值进行验证
            if (!value) {
              return '密码为6-12位的字母和数字'
            }
          }
        }).then(({ value }) => {
        console.log(value)
        request.put(`/api/login/change/${value}`).then(res => {
          this.res = res
          if (this.res === 1) {
            this.$message.error('密码不符合规范，修改失败')
          } else {
            this.$message.success('修改成功')
          }
        })
      }).catch((err) => {
        console.log(err)
      })
    }
  }
}
</script>

<style>
.sad{
  background-color:rgb(78, 86, 87)
}
</style>
