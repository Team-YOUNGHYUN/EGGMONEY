import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserView from '../views/UserView.vue'
import LoginForm from '../components/LoginForm.vue'
import UserRegist from '../components/user/UserRegist.vue'
import UserDetail from '../components/user/UserDetail.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  { path: '/login',
    name: 'loginForm',
    component: LoginForm,
  },
  { path: '/user',
    component: UserView,
    children: [
      {
        path: 'regist',
        name: 'UserRegist',
        component: UserRegist,
      },
      {
        path: 'detail',
        name: 'UserDetail',
        component: UserDetail,
      },
    ]
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
