<template>
  <div class="bg">
    <div class="button1">
      <el-button type="primary" @click="back">返回</el-button>
    </div>
    <div class="registerbox">
      <div>
        <h2>客户注册</h2>
      </div>
      <el-form ref="ruleForm" :model="ruleForm" status-icon :rules="rules" label-width="110px" class="registerform">
        <el-form-item label="用户名" prop="name">
          <el-input v-model="ruleForm.name" type="text" placeholder="请输入用户名" autocomplete="off" />
        </el-form-item>
        <el-form-item label="密码" prop="pwd">
          <el-input v-model="ruleForm.pwd" type="text" placeholder="请输入密码" autocomplete="off" />
        </el-form-item>
        <el-form-item label="联系方式" prop="tel">
          <el-input v-model.number="ruleForm.tel" placeholder="请输入电话" />
        </el-form-item>
        <el-form-item label="默认交易地点" prop="address">
          <el-input v-model.number="ruleForm.address" type="textarea" placeholder="请输入默认交易地点" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      ruleForm: {
        name: '',
        pwd: '',
        tel: '',
        address: ''
      },
      rules: {
        name: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 3, max: 12, message: '长度在 3 到 12 个字符', trigger: 'blur' }
        ],
        pwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
        ],
        tel: [
          { required: true, message: '请输入联系方式', trigger: 'blur' },
          {
            validator: function(rule, value, callback) {
              if (/^[1][3,4,5,7,8][0-9]{9}$/.test(value) === false) {
                callback(new Error('手机号格式错误'))
              } else {
                callback()
              }
            },
            trigger: 'blur'
          }
        ],
        address: [
          { required: true, message: '请输入默认交易地点', trigger: 'blur' },
          { min: 6, message: '长度大于6个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    /* submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    }, */
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    back() {
      this.$router.push('/sell/custlogin')
    }
  }

}
</script>

<style>
.bg{
  min-height:90vh;
  background:url('https://img0.baidu.com/it/u=837759144,3176462439&fm=26&fmt=auto')
}
.registerbox{
  position: absolute;
  top: 55%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 750px;
  height: 550px;
  background-color: rgb(255, 219, 183);
  border-radius: 3px;
}
.registerform{
  box-sizing: border-box;
    position: absolute;
    bottom: 10%;
    width: 90%;
    padding: 0 20px;
    align-items: center;
}
h2{
  position: flex;
  margin-top: 5%;
  text-align: center;
  font-size: 30px;
}
.button1{
  position: absolute;
  bottom: 5%;
  right: 5%;
}
</style>
