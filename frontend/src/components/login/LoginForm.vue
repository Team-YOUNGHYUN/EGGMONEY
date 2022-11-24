<template>
  <b-container>
    <b-row align-h="center">
      <h1 class="title">로그인</h1>
    </b-row>
    <b-row align-h="center">
      <b-col cols="5">
          <div class="input-group mt-4 mb-3">
          <span class="input-group-text" id="basic-addon1">이 메 일</span>
          <input
            type="text"
            class="form-control"
            v-model="email"
            placeholder="E-mail"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
        </div>
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호</span>
          <input type="password" class="form-control" v-model="password" placeholder="password" aria-label="Username" aria-describedby="basic-addon1"
          @keyup.enter="doLogin">
        </div>
        <!-- <input type="text" id="email" v-model="email" class="view" /><br /><br />
        <input
        type="password"
        id="password"
        v-model="password"
        class="view"
        @keyup.enter="doLogin"
      /> -->
      </b-col>
    </b-row>
    <b-row align-h="center" style="margin-top: 5px">
      <b-col>
        <button class="btn btn-dark" @click="doLogin" style="width: 350px">
          로그인
        </button>
      </b-col>
    </b-row>
    <b-row align-h="center">
      <b-col style="margin-top: 13px">
        <router-link
          to="/login/regist"
          tag="button"
          class="btn btn-dark"
          style="width: 165px; margin-right: 20px"
          >회원가입</router-link
        >
        <router-link
          to="/login/findpw"
          tag="button"
          class="btn btn-dark"
          style="width: 165px"
          >비밀번호 찾기</router-link
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
import router from "@/router";
export default {
  name: "LoginForm",
  data() {
    return {
      email: "",
      password: "",
    };
  },
  computed: {
    ...mapGetters(["getUser", "getCheckPassword"]),
  },
  methods: {
    async doLogin() {
      // 0. 공백 검사
      if (this.email === "") {
        alert("이메일을 입력하세요.");
        return;
      }
      if (this.password === "") {
        alert("비밀번호를 입력하세요.");
        return;
      }

      // 1. 이메일, 비밀번호가 일치하는 user 객체의 개수 불러오기
      let params = {
        email: this.email,
        password: this.password,
      };
      await this.$store.dispatch("checkPassword", params);

      // 2-1. 해당하는 user 객체가 없으면 로그인 불가
      if (this.getCheckPassword === 0) {
        alert("이메일 또는 비밀번호를 잘못 입력했습니다.");
        return;
      }

      // 2-2. 해당하는 user 객체가 있으면 세션스토리지에 user 객체 저장
      await this.$store.dispatch("setUser", this.email);
      await window.sessionStorage.setItem("user", JSON.stringify(this.getUser));
      router.push("/");
    },
  },
  created() {},
};
</script>

<style scoped>
.container {
  margin-top: 20px;
  margin-bottom: 50px;
  padding-top: 50px;
  padding-bottom: 105px;
  background: #fee0bc;
  color: black;
  width: 900px;
  height: auto;
}
#basic-addon1{
  width: 80px;
}
</style>
