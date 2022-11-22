import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import DiaryView from "../views/DiaryView.vue";
import LoginForm from "../components/LoginForm.vue";
import UserRegist from "../components/user/UserRegist.vue";
import UserDetail from "../components/user/UserDetail.vue";
import QuestDetail from "../components/quest/QuestDetail.vue";
import QuestUpdate from "../components/quest/QuestUpdate.vue";
import DiaryDetail from "../components/diary/DiaryDetail.vue";
import CalendarDetail from "../components/diary/CalendarDetail.vue";

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
      },
    ],
  },
  // Calendar는 메인 페이지와 Diary 페이지에서 각각 보여야 하므로
  // diary의 child component가 아닌 개별 component로 빼둠
  {
    // 임의로 설정한 calendar 경로
    path: "/calendar",
    name: "CalendarDetail",
    component: CalendarDetail,
  },
  {
    path: "/quest",
    name: "QuestDetail",
    component: QuestDetail,
  },
  {
    path: "/quest/update",
    name: "QuestUpdate",
    component: QuestUpdate,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
