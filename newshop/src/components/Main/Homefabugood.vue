<template>
  <el-form
    ref="ruleForm"
    :model="ruleForm"
    :rules="rules"
    label-width="100px"
    class="demo-ruleForm"
    style=" position: relative;
    width: 55%;
    height: 550;
    left: 300px;
    top:-625px;"
  >
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="ruleForm.name" />
    </el-form-item>

    <el-form-item label="商品图片" />
    <el-upload
      action="https://localhost:8081/test/upload"
      class="avatar-uploader"
      :show-file-list="false"
      :on-success="handleSuccess"
      :before-upload="beforeUpload"
      style="position: relative; left: 100px; top: -55px; "
    >
      <img v-if="imageUrl" :src="imageUrl" class="avatar">
      <i v-else class="el-icon-plus avatar-uploader-icon" />
    </el-upload>

    <el-form-item label="商品价格" prop="price">
      <el-input v-model="ruleForm.price" />
    </el-form-item>
    <!-- <el-form-item label="商品数量" prop="number">
      <el-input v-model="ruleForm.number" />
    </el-form-item> -->
    <el-form-item label="商品描述" prop="information">
      <el-input v-model="ruleForm.information" type="textarea" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submit">立即创建</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import Vue from 'vue'
import { Table, TableColumn, Upload } from 'element-ui'
/* import request from '/86173/桌面/shop/src/config/request' */

Vue.use(Table).use(TableColumn).use(Upload)
export default {
  data() {
    return {
      imageUrl: '',
      ImgDisk: '',
      NameImg: '',
      ruleForm: {
        name: '',
        price: '',
        /* number: '', */
        url: '',
        information: '',
        condition: '已冻结'
      },
      rules: {
        name: [
          { required: true, message: '请输入商品名称', trigger: 'blur' }
        ],
        price: [
          { required: true, message: '请输入价格', trigger: 'change' }
        ],
        number: [
          { required: true, message: '请输入数量', trigger: 'change' }
        ],
        information: [
          { required: true, message: '请填写商品信息', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    handleSuccess(res, file) {
      this.userNameImgUrl = URL.createObjectURL(file.raw)
    },
    beforeUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },

    /*     submit() {
      request.post('/api/good/insert', this.ruleForm)
      this.$confirm('发布成功', '提示', {
        confirmButtonText: '确定',
        type: 'warning',
        center: true
      })
    }, */
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }

  }

}

</script>

<style>
</style>
