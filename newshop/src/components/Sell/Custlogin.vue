<template>
  <div class="bg">

    <div>
      <div class="piclocation">
        <el-image src="https://img2.baidu.com/it/u=769807122,1327121341&fm=26&fmt=auto" />
      </div>
    </div>

    <div class="login_box">

      <!--表单提交区域-->
      <el-form ref="loginFormRef" :rules="loginFormRules" label-width="70px" class="login_form" :model="loginForm">
        <!--用户名-->
        <el-form-item label="用户名" style="font-size:20px;font-weight:bold" prop="username" class="item">
          <el-input v-model="loginForm.username" prefix-icon="iconfont icon-user" placeholder="请输入账号" clearable />
        </el-form-item>
        <!--密码-->
        <el-form-item label="密码" style="font-size:20px;font-weight:bold" prop="password" class="item">
          <el-input v-model="loginForm.password" type="password" prefix-icon="iconfont icon-3702mima" placeholder="请输入密码" show-password clearable />
        </el-form-item>
        <!--按钮区-->
        <el-form-item class="btns">
          <el-button type="primary" @click="login">登录</el-button>
          <el-button type="primary" @click="register">注册</el-button>
          <el-button type="info" @click="resetLoginForm">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
/* import request from '/src/config/request.js' */
export default {
  data() {
    return {
      loginForm: {
        // 登录的表单数据的绑定对象
        username: '',
        password: ''
      },
      loginFormRules: {
        // 验证用户名是否合法
        username: [
          { required: true, message: '请输入登录名称', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        // 验证密码是否合法
        password: [
          { required: true, message: '请输入登录密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created() {

  },
  mounted() {
  },
  methods: {
    resetLoginForm() { // 点击重置按钮,重置登录表单
      console.log(this)
      this.$refs.loginFormRef.resetFields()
    },
    login() { // 点击登录按钮，跳转到Home.vue
      /*  request.post('/api/user/login', this.formdate).then(res => {
        if (res === 1) {
          this.$router.push('/main')
        } else {
          this.$alert('用户名密码错误', '提示', {
            confirmButtonText: '确定'
          })
          this.formdate = Object.assign({}, '')// 重置form表单
        }
      }) */
      this.$router.push('/sell/custlishi')
    },
    register() { // 跳转到注册界面
      this.$router.push('/sell/register')
    }
  }
}

</script>

<style>
.bg{
  min-height:90vh;
  background:url('https://img0.baidu.com/it/u=837759144,3176462439&fm=26&fmt=auto')
}
.piclocation{
  position: absolute;
  left:0%;
  bottom:0%
}
.login_box {
  position: absolute;
  top: 55%;
  left: 62%;
  transform: translate(-50%, -50%);
  width: 600px;
  height: 450px;
  border-radius: 3px;
/*   background-color: azure; */
}
.login_form {
    box-sizing: border-box;
    position: absolute;
    bottom: 25%;
    width: 95%;
    padding: 0 20px;
    align-items: center;
}
.item {
  align-items: center;
}
.btns {
    display: flex;
    justify-content: flex-end;
    left: 20%;
}
</style>

