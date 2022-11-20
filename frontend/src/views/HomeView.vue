<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
    <LoginForm msg="로그인 페이지 구현중입니다."></LoginForm>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import LoginForm from '@/components/LoginForm.vue'

export default {
  name: 'HomeView',
  components: {
    // HelloWorld
    LoginForm
  }
}
</script>
