import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import DiaryView from "../views/DiaryView.vue"
import LoginForm from "../components/LoginForm.vue";
import UserRegist from "../components/user/UserRegist.vue";
import UserDetail from "../components/user/UserDetail.vue";
import QuestDetail from "../components/quest/QuestDetail.vue";
import QuestRegist from "../components/quest/QuestRegist.vue";
import DiaryDetail from "../components/diary/DiaryDetail.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  { path: "/login", name: "loginForm", component: LoginForm },
  {
    path: "/user",
    component: UserView,
    children: [
      {
        path: "regist",
        name: "UserRegist",
        component: UserRegist,
      },
      {
        path: "detail",
        name: "UserDetail",
        component: UserDetail,
      },
    ],
  },
  {
    path: "/diary",
    component: DiaryView,
    children: [
      {
        path: "",
        name: "DiaryDetail",
        component: DiaryDetail,
      }
    ]
  },
  {
    path: "/quest",
    name: "QuestDetail",
    component: QuestDetail,
  },
  {
    path: "/quest/regist",
    name: "QuestRegist",
    component: QuestRegist,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
