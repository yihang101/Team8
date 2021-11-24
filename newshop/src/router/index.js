import Vue from 'vue'
import VueRouter from 'vue-router'
/* import Home from '../views/Home.vue' */
import Login from '../components/Sell/Login.vue'
import Reset from '../components/Sell/Reset.vue'
import Sell from '../components/Sell.vue'
import Message from '../components/Message.vue'
import ShopCard from '../components/Sell/ShopCard.vue'
import Main from '../components/Main.vue'
import Homedjgood from '../components/Main/Homedjgood.vue'
import Homelishi from '../components/Main/Homelishi.vue'
import Homefabugood from '../components/Main/Homefabugood.vue'
import Homeinofmai from '../components/Main/Homeinofmai.vue'
import Custlogin from '../components/Sell/Custlogin.vue'
import Register from '../components/Sell/Register.vue'
import Custlishi from '../components/Sell/Custlishi.vue'
import Homecustinf from '../components/Main/Homecustinf.vue'
import Homecustlishi from '../components/Main/Homecustlishi.vue'
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
    path: '',
    redirect: '/sell'
  },
  {
    path: '/main',
    name: 'Main',
    component: Main,
    children: [
      {
        path: 'Homecustinf',
        name: 'Homecustinf',
        component: Homecustinf
      },
      {
        path: 'Homecustlishi',
        name: 'Homecustlishi',
        component: Homecustlishi
      },
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
      },
      {
        path: '',
        redirect: '/main/Homelishi'
      }
    ]
  },

  /*  {
    path: '/Main',
    component: Main,
    children: [
      {
        path: '/Homelishi',
        name: 'Homelishi',
        component: Homelishi
      },
      {
        path: '/Homeinofmai',
        name: 'Homeinofmai',
        component: Homeinofmai
      },
      {
        path: '/Homefabugood',
        name: 'Homefabugood',
        component: Homefabugood
      },
      {
        path: '/Homedjgood',
        name: 'Homedjgood',
        component: Homedjgood
      }
    ]
  }, */

  {
    path: '/sell',
    name: 'Sell',
    component: Sell,
    children: [
      {
        path: 'custlishi',
        name: 'Custlishi',
        component: Custlishi
      },
      {
        path: 'register',
        name: 'Register',
        component: Register
      },
      {
        path: 'custlogin',
        name: 'Custlogin',
        component: Custlogin
      },
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
        path: 'shopcard',
        name: 'shopcard',
        component: ShopCard
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
