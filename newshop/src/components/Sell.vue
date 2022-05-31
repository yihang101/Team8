<template>
  <div>
    <headline />
    <navbar class="column1" />
    <!--   <cascbar class="column1" /> -->
    <router-view />
  </div>
</template>

<script>
import navbar from './NavrBar.vue'
/* import cascbar from './cascbar.vue'
 */import headline from './Title.vue'

export default {
  components: {
    navbar,
    headline
    /*     cascbar
 */ },
  data() {
    return {
      userList: [
        { name: '安其拉', id: 'a1' },
        { name: '安琪', id: 'a2' },
        { name: '陈仙仙', id: 'c1' },
        { name: '成小龙', id: 'c2' },
        { name: '程野', id: 'c3' },
        { name: '丁小明', id: 'd1' },
        { name: '丁小龙', id: 'd2' },
        { name: '丁小野', id: 'd3' },
        { name: '冯小明', id: 'f1' },
        { name: '冯小龙', id: 'f2' },
        { name: '冯小野', id: 'f3' },
        { name: '高小明', id: 'g1' },
        { name: '高小龙', id: 'g2' },
        { name: '高小野', id: 'g3' },
        { name: '高小阳', id: 'g4' },
        { name: '郭小名', id: 'g5' },
        { name: '黄小明', id: 'h1' },
        { name: '黄小龙', id: 'h2' },
        { name: '黄小野', id: 'h3' },
        { name: '郝小阳', id: 'h4' },
        { name: '郝小名', id: 'h5' },
        { name: '李小明', id: 'l1' },
        { name: '李小龙', id: 'l2' },
        { name: '李小野', id: 'l3' },
        { name: '李小阳', id: 'l4' },
        { name: '李小一', id: 'l5' },
        { name: '李小二', id: 'l6' },
        { name: '李小三', id: 'l7' },
        { name: '李小四', id: 'l8' },
        { name: '李小五', id: 'l9' }
      ],
      asideMenu: [
        {
          path: '/',
          lable: '首页',
          icon: 'home'
        },
        {
          path: '/video',
          lable: '视频管理',
          icon: 'video-play'
        },
        {
          path: '/user',
          lable: '用户管理',
          icon: 'user'
        },
        {
          lable: '其他',
          icon: 'location',
          children: [
            {
              path: 'page1',
              lable: '页面1',
              icon: 'setting'
            },
            {
              path: 'page2',
              lable: '页面2',
              icon: 'setting'
            }
          ]
        }
      ]
    }
  }
}
</script>

<style scoped lang="scss">
  .column1 {
  float: left;
  width: 20%;
}
 .toleft {
    float: left;
    width: 60%
    }
</style>
