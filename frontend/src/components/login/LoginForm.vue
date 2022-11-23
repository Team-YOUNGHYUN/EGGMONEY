<template>
  <div class="container">
    <h1>router: 여기부터 LoginForm 영역이다!</h1>
    <h2 class="title">로그인</h2>
    <fieldset class="text-center">
      <label for="id">이메일</label>
      <input type="text" id="email" v-model="email" class="view" /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
        @keyup.enter="doLogin"
      /><br />
    </fieldset>
    <div id="button">
      <!-- <button class="btn btn-success" @click="doLogin">로그인</button> -->
      <button class="btn btn-success" @click="doLogin">로그인</button> |  
      <router-link to="/login/regist" tag="button" class="btn btn-success">회원가입</router-link> |
      <router-link to="/login/findpw" tag="button" class="btn btn-success">비밀번호 찾기</router-link>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import router from "@/router";
export default {
  name: "LoginForm",
  data(){
    return{
      email: "",
      password: "",
    }
  },
  computed:{
    ...mapGetters(["getUser", "getCheckPassword"])
  },
  methods:{
    async doLogin(){
      // 0. 공백 검사
      if(this.email===""){
        alert("이메일을 입력하세요.");
        return;
      }
      if(this.password===""){
        alert("비밀번호를 입력하세요.");
        return;
      }

      // 1. 이메일, 비밀번호가 일치하는 user 객체의 개수 불러오기
      let params = {
        email: this.email,
        password: this.password,
      }
      await this.$store.dispatch("checkPassword", params);

      // 2-1. 해당하는 user 객체가 없으면 로그인 불가
      if(this.getCheckPassword === 0){
        alert("이메일 또는 비밀번호를 잘못 입력했습니다.");
        return;
      }
      
      // 2-2. 해당하는 user 객체가 있으면 세션스토리지에 user 객체 저장
      await this.$store.dispatch("setUser", this.email);
      await window.sessionStorage.setItem("user", JSON.stringify(this.getUser));
      router.push("/");
    }
  },
  created(){
    
  }
};
</script>

<style scoped>
.container {
  /* margin-top: 70px;
    padding-top: 100px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 100px; */
  background: gray;
  color: white;
}
</style>
