<template>
  <div class="about">
    <h1>AboutView 페이지에용 ^.^</h1>
    <img alt="Vue logo" src="../assets/logo.png" />
    <router-view />
  </div>
</template>

<script>
import router from '../router';
export default {
    created(){
      if(!JSON.parse(window.sessionStorage.getItem("user"))){
        router.push("/login");
      }
    }
};
</script>

<style></style>
