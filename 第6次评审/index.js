import Vue from 'vue'
import VueRouter from 'vue-router'
/* import Home from '../views/Home.vue' */
import Login from '../components/Sell/Login.vue'
import Reset from '../components/Sell/Reset.vue'
import Sell from '../components/Sell.vue'
import Message from '../components/Message.vue'
import shopf from '../components/Sell/Shopinf.vue'
import cust from '../components/Sell/Custlogin.vue'
import ShopCard from '../components/Sell/ShopCard.vue'
import Use from '../components/Sell/Use.vue'
import Food from '../components/Sell/Food.vue'
import Digtal from '../components/Sell/Digtal.vue'
import Main1 from '../components/customer/main.vue'
import Main from '../components/Main.vue'
import Homedjgood from '../components/Main/Homedjgood.vue'
import Homelishi from '../components/Main/Homelishi.vue'
import Homefabugood from '../components/Main/Homefabugood.vue'
import Homeinofmai from '../components/Main/Homeinofmai.vue'
Vue.use(VueRouter)

const routes = [
  /* {
    path: '/',
    name: 'Home',
    component: Home
  }, */
  {
    path: '/message',
    name: 'Message',
    component: Message
  },
  {
    path: '/cust',
    name: 'cust',
    component: cust
  },
  {
    path: '',
    redirect: '/sell'
  },
  {
    path: '/cust/main',
    name: 'main',
    component: Main1
  },
  {
    path: '/main',
    name: 'Main',
    component: Main,
    children: [

      {
        path: 'Homelishi',
        name: 'Homelishi',
        component: Homelishi
      },
      {
        path: 'Homeinofmai',
        name: 'Homeinofmai',
        component: Homeinofmai
      },
      {
        path: 'Homefabugood',
        name: 'Homefabugood',
        component: Homefabugood
      },
      {
        path: 'Homedjgood',
        name: 'Homedjgood',
        component: Homedjgood
      }
    ]
  },

  {
    path: '/sell',
    name: 'Sell',
    component: Sell,
    children: [
      {
        path: 'login',
        name: 'Login',
        component: Login
      },
      {
        path: 'reset',
        name: 'Reset',
        component: Reset
      },
      {
        path: 'use',
        name: 'use',
        component: Use
      },
      {
        path: 'shopcard',
        name: 'shopcard',
        component: ShopCard
      },
      {
        path: 'digtal',
        name: 'digtal',
        component: Digtal
      },
      {
        path: 'food',
        name: 'food',
        component: Food
      },
      {
        path: 'shopf',
        name: 'shopf',
        component: shopf
      },
      {
        path: '',
        redirect: '/sell/shopcard'
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
