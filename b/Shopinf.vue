<template>
  <div class="main">
    <div class="imgshow">

      <el-carousel
        ref="carousel"
        :autoplay="autoplay"
        :interval="interval"
        :initial-index="initialIndex"
        :height="height"
        @change="onChange"
      >
        <el-carousel-item v-for="(item,index) in imgList" :key="index" name="index">
          <img
            v-if="item.type === 0"
            width="100%"
            height="100%"
            :src="item.url"
            alt="这是图片"
            class="banner"
          >
          <video-player
            v-else
            id="player"
            ref="videoPlayer"
            class="video-player vjs-custom-skin"
            :playsinline="true"
            :options="playerOptions"
            style="height: 100%"
            @play="onPlayerPlay($event)"
            @ended="onPlayerEnded($event)"
            @loadeddata="onPlayerLoadeddata($event)"
          />
        </el-carousel-item>

      </el-carousel>

    </div>
    <div style="position:absolute;left:15%;bottom:20%;font-size:20px;font-weight:bold">
      商品名称：<el-tag style="font-size:20px;font-weight:bold" type="danger" effect="dark"> {{ datalist[0].name }} </el-tag>
    </div>
    <div style="position:absolute;right:32%;bottom:25%;font-size:20px;font-weight:bold">
      价格:<el-tag style="font-size:20px;font-weight:bold" type="danger" effect="dark"> {{ datalist[0].price }}￥ </el-tag>
    </div>
    <div style="position:absolute;right:32%;bottom:35%;font-size:20px;font-weight:bold">
      商品数量:<el-tag style="font-size:20px;font-weight:bold" type="danger" effect="dark"> {{ datalist[0].number }} </el-tag>
    </div>
    <div style="position:absolute;right:35%;top:15%;font-size:20px;font-weight:bold">
      商品描述:
    </div>
    <div class="datashow">
      <p>{{ datalist[0].information }}</p>
    </div>
    <div class="count1"><span style="font-size:20px;font-weight:bold">购买数量:</span><el-input-number v-model="num" :min="1" :max="datalist[0].number" label="购买数量" @change="handleChange" /></div>
    <div>
      <el-button type="primary" class="button6" @click="gotolink">立即购买</el-button>
    </div>
    <div>
      <el-button type="primary" class="button7" @click="gotoshoucang">{{ shoucangjia }}</el-button>
    </div>
  </div>
</template>

<script>
import PubSub from 'pubsub-js'
import { videoPlayer } from 'vue-video-player'
import 'video.js/dist/video-js.css'
import request from '/src/config/request.js'
export default {
  components: {
    videoPlayer
  },
  data() {
    return {
      shoucangjia: '加入收藏夹',
      loname: '',
      name: '',
      num: '',
      autoplay: true,
      interval: 3000,
      initialIndex: 0, // 轮播默认滑动到第一个
      datalist: [
        {
          name: '奥妙洗衣凝珠球',
          goodid: '',
          information: '奥妙洗衣液，强力去渍，衣服白净！',
          price: '88',
          url: '',
          number: '15',
          condition: '',
          classify1: '',
          classify2: ''
        }
      ],
      imgList: [
        {
          type: 0,
          name: 'lj',
          url: 'https://img0.baidu.com/it/u=3858759242,2439350572&fm=26&fmt=auto'
        },
        {
          type: 0,
          name: 'logo',
          url: 'https://img2.baidu.com/it/u=1823682001,2058143068&fm=26&fmt=auto'
        },
        {
          type: 0,
          name: 'bg',
          url: 'https://img2.baidu.com/it/u=3547734642,2083669832&fm=26&fmt=auto'
        },
        {
          type: 0,
          name: 'sadmas',
          url: 'https://img0.baidu.com/it/u=395092830,3168659300&fm=253&fmt=auto&app=120&f=JPEG?w=400&h=300'
        },
        {
          type: 1,
          name: 'sadmas',
          url: 'http://vali-g1.cp31.ott.cibntv.net/youku/67746b9cc753e71a7bbfd6daf/0300080100619CCB69A02F7C09B5AFD85DBBA2-98DC-4873-BB4A-7D076FDF1A19.mp4?sid=163887661000010005833_00_B95a4eb2a72ce3a0e814c8ca85f168508&sign=15c45e22ad53f7f06ba1edd2ba4cd7de&ctype=50&si=183&psid=d23c127bc780fbcaaec53fa9d6e2b4c343346'
        }
      ],
      playerOptions: {
        autoplay: true, // 如果true,浏览器准备好时开始回放。实现自动播放，autoplay、muted都设置为true
        muted: false, // 默认情况下将会消除任何音频。
        loop: false, // 导致视频一结束就重新开始。
        preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
        language: 'zh-CN',
        aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
        sources: [
          {
            type: 'video/mp4', // 这里的种类支持很多种：基本视频格式、直播、流媒体等，具体可以参看git网址项目
            src: 'http://vali-g1.cp31.ott.cibntv.net/youku/67746b9cc753e71a7bbfd6daf/0300080100619CCB69A02F7C09B5AFD85DBBA2-98DC-4873-BB4A-7D076FDF1A19.mp4?sid=163887661000010005833_00_B95a4eb2a72ce3a0e814c8ca85f168508&sign=15c45e22ad53f7f06ba1edd2ba4cd7de&ctype=50&si=183&psid=d23c127bc780fbcaaec53fa9d6e2b4c343346' // url地址
          }
        ],
        width: document.documentElement.clientWidth, // 播放器宽度
        notSupportedMessage: '此视频暂无法播放，请稍后再试' // 允许覆盖Video.js无法播放媒体源时显示的默认信息。
      }
    }
  },
  computed: {},
  created() {},
  mounted() {
    PubSub.subscribe('loname', (msg, data) => {
      this.loname = data
    })
    this.name = this.$route.query.name
    request.get(`/api/good/search/${this.name}`).then(res => {
      this.datalist = res
    })
  },
  methods: {
    gotoshoucang() {
      if (this.shoucangjia === '加入收藏夹') {
        this.$confirm('操作成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        },
        this.shoucangjia = '移出收藏夹',
        request.post('/api/hisg/***', this.datalist[0]).then(res => {})
        )
      } else {
        // request.post('/api/hisg/find', this.FormData).then(res => {})
        this.$confirm('操作成功', '提示', {
          confirmButtonText: '确定',
          type: 'warning',
          center: true
        },
        this.shoucangjia = '加入收藏夹',
        request.post('/api/hisg/***', this.datalist[0]).then(res => {})
        )
      }
    },
    gotolink() {
      this.$prompt('请输入交易地址', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputValue: '浙江工商大学'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的交易地址是: ' + value
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        })
      })
    },
    handleChange(value) {
      console.log(value)
    },
    onPlayerLoadeddata(player) {
    // 获取资源总时长
      this.duration = player.cache_.duration
    },
    // 监听媒体是否已到达结尾，播放完
    onPlayerEnded(player) {
      this.autoplay = true
      this.interval = 3000
    },
    // 监听轮播图改变
    onChange(index) {
    // 如果是视频,就等播放完再进行下一个
      if (this.imgList[index].type === 1) {
        this.$refs.videoPlayer[0].player.src(this.playerOptions['sources'][0]['src']) // 重置进度条,再次轮播时让视频重新播放
        this.interval = this.duration * 1000
        this.autoplay = false
      }
    }
  }
}
</script>

<style>
.main {
  background:url('https://img2.baidu.com/it/u=2765856199,118165623&fm=26&fmt=auto');
  position: absolute;
  width: 70%;
  height: 70%;
/*   background-color: rgb(49, 119, 180); */
  top: 20%;
  margin: 0 auto;
  left: 20%;
}
.button6 {
  position: absolute;
  right: 30%;
  bottom: 10%;
}
.button7 {
  position: absolute;
  right: 10%;
  bottom: 10%;
}
.imgshow{
  position: absolute;
  left: 5%;
  top: 15%;
  width: 50%;
  height: 450px;
}
.datashow {
  position: absolute;
  width: 35%;
  height: 45%;
  right: 5%;
  top: 22%;

}
.count1{
  position: absolute;
  bottom: 24%;
  right: 7%;
}
</style>
