<template>
  <header>
    <nav class="header-nav">
      <div class="pjt-logo">
        <router-link to="/"
          ><img
            src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/59c4fd18-f590-47d2-b66a-20cc289f7fc0/logo.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T152739Z&X-Amz-Expires=86400&X-Amz-Signature=0e7903be679f8a7821828f44ca15b4a0f3290735cab92a309886e205de7e11ec&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22logo.png%22&x-id=GetObject"
            class="eggmoney-logo"
            alt="로고"
        /></router-link>
      </div>
      <div>
        HomeView : <router-link to="/">Main</router-link> |
        <router-link to="/diary">Diary</router-link>
      </div>
      <div>
        AboutView : <router-link to="/about/user">UserDetail</router-link> |
        <router-link to="/about/goal">GoalDetail</router-link> |
        <router-link to="/about/shop">MoneyShop</router-link>
      </div>
      <div>
        LoginView : <router-link to="/login">Login</router-link> |
        <router-link to="/login/regist">Regist</router-link> |
        <router-link to="/login/findpw">Findpw</router-link> |
        <a
          v-if="getUser"
          @click="logout"
          style="cursor: pointer; text-decoration: underline"
          >Logout</a
        >
      </div>
    </nav>
  </header>
</template>

<script>
import router from "@/router";
import { mapGetters } from "vuex";
export default {
  name: "TheHeader",
  date() {
    return {};
  },
  computed: {
    ...mapGetters(["getUser"]),
  },
  methods: {
    async logout() {
      this.$store.dispatch("doLogout");
      window.sessionStorage.removeItem("user");
      router.push("/login");
    },
  },
};
</script>

<style>
.header-nav {
  background-color: #1a202c;
}

.eggmoney-logo {
  width: 200px;
}

.pjt-logo {
  float: left;
}
</style>
