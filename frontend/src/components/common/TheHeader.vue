<template>
  <header>
    <nav class="header-nav">
      <br />
      <br />
      <br />
      <br />
      <div class="pjt-logo">
        <router-link to="/"
          ><img
            src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/6da11fd5-8e22-4270-847f-56034229dc41/logo_%282%29.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T002351Z&X-Amz-Expires=86400&X-Amz-Signature=9223c0421359790487d3716bab390ded29bcd24e99cf1c4fd46d1fefc094eb2a&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22logo%2520%282%29.png%22&x-id=GetObject"
            class="eggmoney-logo"
            alt="로고"
        /></router-link>
      </div>
      <div class="header-index" style="font-size: 1.6em">
        <!-- HomeView : <router-link to="/"></router-link> -->
        <router-link to="/diary" class="index">다이어리</router-link>&nbsp;
        <router-link to="/about/goal" class="index">목표</router-link>&nbsp;
        <router-link to="/about/shop" class="index">상점</router-link>&nbsp;
        <router-link to="/about/user" class="index">내 정보</router-link>&nbsp;
        <a v-if="getUser" @click="logout" class="index" style="cursor: pointer"
          >로그아웃</a
        >
      </div>
      <div class="header-index" style="font-size: 1.3em" v-if="!getUser">
        <router-link to="/login" class="index">로그인</router-link>&nbsp;
        <router-link to="/login/regist" class="index">회원가입</router-link>
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
  background-color: #ffd95b;
  height: 190px;
}

.header-index {
  float: right;
}

.eggmoney-logo {
  width: 200px;
}

.pjt-logo {
  float: left;
}

.index {
  font-weight: bold;
  text-decoration: none;
  color: white;
}
</style>
