<template>
  <div>

    <form class="toleft">
      <div>
        <i class="el-icon-user" />
        <label for=""> 用户名 : </label>
        <el-input
          v-model="username"
          style="width:300px;margin-bottom:20px ;"
          placeholder="请输入用户名"
          clearable
        />
      </div>
      <div>
        <i class="el-icon-key" />
        <label for=""> 旧密码  : </label>
        <el-input
          v-model="password"
          placeholder="请输入旧的密码"
          style="width:300px;margin-bottom:20px "
          clearable
        />
      </div>
      <div>
        <i class="el-icon-key" />
        <label for=""> 新密码  : </label>
        <el-input
          v-model="password"
          placeholder="请输入新的密码"
          style="width:300px;margin-bottom:20px "
          show-password
        />
      </div>
      <el-button type="primary" style="margin-left:150px">确认修改</el-button>
    </form>

  </div>
</template>

<script>
export default {
  data: function() {
    return {
      username: '',
      password: ''
    }
  }
}
</script>
  <style scoped lang="scss">
    .toleft {
    float: left;
    width: 60%;
    margin-top: 200px;
    margin-left: 260px;
    }
  </style>

