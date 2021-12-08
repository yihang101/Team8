<template>

  <el-form
    ref="ruleForm"
    :model="ruleForm"
    :rules="rules"
    label-width="100px"
    class="demo-ruleForm"
    style=" position: absolute;
    width: 55%;
    height: 550px;
    left: 15%;
    top: 20%;"
  >
    <el-form-item label="商品名称" prop="name">
      <el-input v-model="ruleForm.name" />
    </el-form-item>
    <el-form-item label="上传图片" prop="url">
      <el-upload
        class="upload-demo"
        action="/api/file/upload"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :file-list="fileList"
        list-type="picture"
      >
        <el-button size="small" type="primary">点击上传</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
      </el-upload>
    </el-form-item>

    <el-form-item label="商品价格" prop="price">
      <el-input v-model="ruleForm.price" />
    </el-form-item>
    <!-- <el-form-item label="商品数量" prop="number">
      <el-input v-model="ruleForm.number" />
    </el-form-item> -->
    <el-form-item label="商品描述" prop="information">
      <el-input v-model="ruleForm.information" type="textarea" :rows="5" />
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
import request from '/src/config/request.js'

Vue.use(Table).use(TableColumn).use(Upload)
export default {
  data() {
    return {
      res: '',
      imageUrl: '',
      ImgDisk: '',
      NameImg: '',
      ruleForm: {
        name: '',
        price: '',
        /* number: '', */
        url: '',
        information: '',
        condition: '未冻结'
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

    submit() {
      if (this.ruleForm.name !== '' && this.ruleForm.price !== '' && this.ruleForm.price !== '') {
        request.post('/api/good/insert', this.ruleForm).then(res => {
          console.log(res)
          this.res = res
          if (this.res === 1) {
            this.$confirm('已经存在商品', '提示', {
              confirmButtonText: '确定',
              type: 'warning',
              center: true
            })
          } else if (this.res === 2) {
            this.$confirm('商品价格不能为负', '提示', {
              confirmButtonText: '确定',
              type: 'warning',
              center: true
            })
          } else {
            this.$confirm('发布成功', '提示', {
              confirmButtonText: '确定',
              type: 'warning',
              center: true
            })
          }
        })
      } else {
        this.$confirm('信息有误', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        })
      }
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }

  }

}

</script>

<style>
/* .backgs{
  position: absolute;
  width: 70%;
  height: 50%;
} */
</style>
