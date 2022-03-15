<template>
  <div id="box" class="dv">
    <ul v-if="searchResult.length>0" class="ul">
      <li v-for="(v,index) in searchResult" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：$   {{ v.price }}</p>
        <router-link :to="{ path:'/sell/shopinf' , query:{ name:datalist[index].name } }">
          <el-button style="margin-left:53px;" type="primary" round class="button">
            购买
          </el-button>
        </router-link>
      </li>
    </ul>

    <ul v-else class="ul">
      <li v-for="(v,index) in datalist" :key="index">
        <img :src="v.url" alt="">
        <h4>{{ v.name }}</h4>
        <p>售价：$   {{ v.price }}</p>
        <router-link :to="{ path:'/sell/shopinf' , query:{ name:datalist[index].name } }">
          <el-button style="margin-left:53px;" type="primary" round class="button">
            移出收藏夹
          </el-button>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<style>
.ul{
  margin-top:65px ;
  overflow:scroll;
  height: 850px;
}
  ::-webkit-scrollbar {
	width: 6px;
	height: 8px;
	background-color: white;
}

/*定义滚动条轨道 内阴影+圆角*/
::-webkit-scrollbar-track {
	border-radius: 10px;
	background-color: #F5F5F5;
}

/*定义滑块 内阴影+圆角*/
::-webkit-scrollbar-thumb {
	border-radius: 10px;
	background-color: #9E9E9E;
}
  #box ul{
		display: flex;
		flex-wrap: wrap;
	}
  #box li{
		padding: 3px;
		list-style: none;
		margin-right: 15px;
    height: 300px;
		border: 1px solid #eee;
	}
  .input{
  position: relative;
  left: 420px;
  top:5px;
  width:300px;
  text-align: center;
  font-size: 20px;
       border: 2px solid #B8B8B8;
      height: 40px;
      width: 15%;
      font-size: 16px;
}
  #box img{
		width: 200px;
		height: 150px;
	}
    .image {
    width: 50%;
    display: block;
    position: relative;
  left: 210px;
  }
    h4{
    text-align: center;
  }
  p{
    text-align: center;
  }
</style>

<script>
import request from '/src/config/request.js'
import { throttle } from '../libs/utils'
export default {
  data() {
    return {
      searchResult: [],
      currentDate: new Date(),
      option: '',
      datalist: [
        { name: '天然榉木碗',
          price: 18.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg1.99114.com%2Fgroup1%2FM00%2FBF%2F1D%2FwKgGS1kXbB-ABY_3AAFMmGV770I881_600_600.jpg&refer=http%3A%2F%2Fimg1.99114.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452345&t=d2d6f955fcd76a4e6f74327966798569',
          information: '天然卫生，易清洁'
        },
        { name: '环保牙杯',
          price: 28.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimgx.xiawu.com%2Fxzimg%2Fi3%2F429312012%2FO1CN01UkzlY61QjXRKlSb5w_%21%21429312012.jpg&refer=http%3A%2F%2Fimgx.xiawu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452283&t=b0be9348882a6b673358e6d49488f213',
          information: '全新环保材料'
        }, { name: '手工收纳篮',
          price: 12.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fwww.tbw-xie.com%2FtuxieJDEwLmFsaWNkbi5jb20vaTQvMzA2NDI4OTg1Mi9PMUNOMDEyTWVHVkhYMTVwem9JVTNfISEzMDY0Mjg5ODUyJDk.jpg&refer=http%3A%2F%2Fwww.tbw-xie.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452438&t=b649f165fba81a128260d1c3f1af3734',
          information: '节省空间，居家必备'
        },
        { name: '纽扣杯垫',
          price: 8.8,
          url: 'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fcbu01.alicdn.com%2Fimg%2Fibank%2F2015%2F799%2F073%2F2588370997_1668506035.jpg&refer=http%3A%2F%2Fcbu01.alicdn.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1641452518&t=c98b3936cf6a6418491c6bf0da265712',
          information: '隔热好物'
        }, { name: 'PS5(限量)',
          price: 10888,
          url: 'https://p6.itc.cn/images01/20210318/a1794aecc70b49bb88f0a7d8cfdf640c.png',
          information: '商品有限，先到先得'
        },
        { name: '华为折叠屏手机',
          price: 9888,
          url: 'https://i04piccdn.sogoucdn.com/b3146a50eafb65b3',
          information: '创新科技，全新体验'
        }, { name: '索爱蓝牙音箱',
          price: 128,
          url: 'https://i03piccdn.sogoucdn.com/fe4ac4d71f6e06a8',
          information: '完美音质，便携好用'
        },
        { name: '三星相机',
          price: 588,
          url: 'https://i01piccdn.sogoucdn.com/b20b6d4070e58122',
          information: '高清像素，功能多样'
        }, { name: '新鲜草莓',
          price: 28.8,
          url: 'https://img2.baidu.com/it/u=3385841003,1992474648&fm=26&fmt=auto',
          information: '新鲜草莓，厂家直发'
        },
        { name: '牛角包',
          price: 8.8,
          url: 'https://img1.baidu.com/it/u=3349008787,676681666&fm=26&fmt=auto',
          information: '精心烘焙，尽享美味'
        }, { name: '每日坚果',
          price: 12.8,
          url: 'https://img0.baidu.com/it/u=259586349,2717684003&fm=26&fmt=auto',
          information: '营养坚果，元气每天'
        },
        { name: '三文鱼派',
          price: 58.8,
          url: 'https://img1.baidu.com/it/u=1210134805,2875221101&fm=26&fmt=auto',
          information: '新鲜营养'
        },
        { name: '耐克运动鞋',
          price: 588,
          url: 'https://img.alicdn.com/imgextra/i3/92688455/O1CN01YjCDwW2CKRS3NTHzK_!!92688455.jpg_430x430q90.jpg',
          information: '9折优惠，欢迎选购'
        }
      ]
    }
  },
  mounted() {
    request.get('/api/***/get').then(res => {
      this.datalist = res
    })
  },
  methods: {
    handleclick() {
      this.$router.push('/message')
    },
    searchAction: throttle(function(e) {
      const inputValue = e.target.value

      this.searchResult = this.datalist.filter((item) => {
        if (item.name.includes(inputValue)) {
          return item
        }
      })
    }, 1000)
  }

}
</script>

