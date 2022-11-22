import Vue from "vue";
import VueRouter from "vue-router";

import HomeView from "../views/HomeView.vue";
import LoginView from "../views/LoginView.vue";
import AboutView from "../views/AboutView.vue";

import MainPage from "../components/MainPage.vue";
import DiaryPage from "../components/DiaryPage.vue";

import LoginForm from "../components/login/LoginForm.vue";
import RegistForm from "../components/login/RegistForm.vue";
import FindpwForm from "../components/login/FindpwForm.vue";

import UserDetail from "../components/about/UserDetail.vue";
import GoalDetail from "../components/about/GoalDetail.vue";
import MoneyShop from "../components/about/MoneyShop.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: HomeView,
    children: [
      {
        path: "",
        name: "MainPage",
        component: MainPage,
      },
      {
        path: "diary",
        name: "DiaryPage",
        component: DiaryPage,
      },
    ],
  },
  {
    path: "/login",
    component: LoginView,
    children: [
      {
        path: "",
        name: "LoginForm",
        component: LoginForm,
      },
      {
        path: "regist",
        name: "RegistForm",
        component: RegistForm,
      },
      {
        path: "findpw",
        name: "FindpwForm",
        component: FindpwForm,
      },
    ],
  },
  {
    path: "/about",
    component: AboutView,
    children: [
      {
        path: "user",
        name: "UserDetail",
        component: UserDetail,
      },
      {
        path: "goal",
        name: "GoalDetail",
        component: GoalDetail,
      },
      {
        path: "shop",
        name: "MoneyShop",
        component: MoneyShop,
      },
    ],
  },
  // Calendar는 메인 페이지와 Diary 페이지에서 각각 보여야 하므로
  // diary의 child component가 아닌 개별 component로 빼둠
  // {
  //   // 임의로 설정한 calendar 경로
  //   path: "/calendar",
  //   name: "CalendarDetail",
  //   component: CalendarDetail,
  // },
  // {
  //   path: "/quest",
  //   name: "QuestDetail",
  //   component: QuestDetail,
  // },
  // {
  //   path: "/quest/update",
  //   name: "QuestUpdate",
  //   component: QuestUpdate,
  // },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
