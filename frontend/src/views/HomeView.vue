<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
// import LoginForm from '@/components/LoginForm.vue'
// import UserRegist from '@/components/user/UserRegist.vue'

export default {
  name: 'HomeView',
  components: {
    HelloWorld
  }
}
</script>
