<template>
  <div
    style="height: 120px; line-height:50px; border-bottom: 1px solid black;display: flex;
  background:url('https://img2.baidu.com/it/u=647394006,2018330860&fm=26&fmt=auto')"
  >
    <div style="position:absolute;left:20%;top:3%;font-size:50px;font-weight:bold">线</div>
    <div style="position:absolute;left:40%;top:3%;font-size:50px;font-weight:bold">上</div>
    <div style="position:absolute;left:60%;top:3%;font-size:50px;font-weight:bold">商</div>
    <div style="position:absolute;left:80%;top:3%;font-size:50px;font-weight:bold">城</div>
    <div class="drops">
      <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link" style="font-size:20px;font-weight:bold">
          登录<i class="el-icon-arrow-down el-icon--right" />
        </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item @click.native="gotolink1">客户入口</el-dropdown-item>
          <el-dropdown-item @click.native="gotolink2">商家入口</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>

</template>

<script>
export default {
  methods: {
    gotolink2() {
      this.$router.push('/sell/login')
    },
    gotolink1() {
      this.$router.push('/sell/custlogin')
    }
  }
}
</script>

<style>
  .el-dropdown-link {
    cursor: pointer;
    color: #eb840f;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
  .drops{
    position: absolute;
    right: 1%;
    top:6%;
  }
</style>
