import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import LoginView from "../views/LoginView.vue";
import DiaryView from "../views/DiaryView.vue";
import LoginForm from "../components/login/LoginForm.vue";
import RegistForm from "../components/login/RegistForm.vue";
import UserDetail from "../components/user/UserDetail.vue";
import QuestDetail from "../components/quest/QuestDetail.vue";
import QuestUpdate from "../components/quest/QuestUpdate.vue";
import DiaryDetail from "../components/diary/DiaryDetail.vue";
import FindPassword from "../components/login/FindPassword.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
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
        name: "FindPassword",
        component: FindPassword,
      }
    ]
  },
  {
    path: "/user",
    component: UserView,
    children: [
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
