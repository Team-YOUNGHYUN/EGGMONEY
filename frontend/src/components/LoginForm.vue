<template>
  <div class="container">
    <h1>이 줄부터 LoginForm 내용이다.</h1>
    <h2 class="title">로그인</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />
    </fieldset>
    <div id="button">
      <!-- <button class="btn btn-success" @click="login">로그인</button> -->
      <router-link to="/user/regist">회원가입</router-link>
    </div>
  </div>
</template>

<script>
export default {
  name: "LoginForm",
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
