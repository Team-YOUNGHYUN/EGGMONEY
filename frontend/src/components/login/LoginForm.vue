<template>
  <div class="container">
    <h1>이 줄부터 LoginForm 내용이다.</h1>
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
      /><br />
    </fieldset>
    <div id="button">
      <!-- <button class="btn btn-success" @click="doLogin">로그인</button> -->
      <button class="btn btn-success" @click="doLogin">로그인</button> |  
      <router-link to="/login/regist" tag="button" class="btn btn-success">회원가입</router-link>
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
    ...mapGetters(["getCurrUser","getLoginUser"])
  },
  methods:{
    async doLogin(){
      if(this.email===""){
        alert("이메일을 입력하세요.");
        return;
      }
      if(this.password===""){
        alert("비밀번호를 입력하세요.");
        return;
      }
      let params = {
        email: this.email,
        password: this.password,
      }
      await this.$store.dispatch("loginCheck", params);
      if(this.password !== this.getLoginUser.password){
        alert("이메일 또는 비밀번호를 잘못 입력했습니다.");
        return;
      }
      await window.sessionStorage.setItem("user", JSON.stringify(this.getLoginUser));
      await this.$store.dispatch("setCurrUser");
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
