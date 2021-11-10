<template>
  <div
    style="height: 100px; line-height:50px; border-bottom: 1px solid black;display: flex;
  background-color:#E8F4FF"
  >
    <div style=" width:250px; padding-left:30px; font-weight: bold; font-size:30px; color: #002447;margin-top:20px ">购物系统</div>
    <div style=" flex:1" />
    <div class="wel">WelCome</div>
  </div>

</template>

<script>
export default {
  methods: {
    open() {
      this.$prompt('请输入新密码', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消'

      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的密码是: ' + value
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        })
      })
    }
  }
}
</script>

<style scoped lang="scss">
.wel{
  width:250px; padding-left:30px; font-weight: bold; font-size:30px; color: #002447;margin-top:20px
}
</style>
