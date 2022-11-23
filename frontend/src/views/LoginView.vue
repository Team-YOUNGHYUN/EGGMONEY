<template>
  <div class="login">
    <h1>Login 페이지에용 ^.^</h1>
    <img alt="Vue logo" src="../assets/logo.png" />
    <router-view />
  </div>
</template>

<script>
import router from '../router'
export default {
    created(){
        if(JSON.parse(window.sessionStorage.getItem("user"))){
          router.push("/");
        }
    }
}
</script>

<style>
.msg {
  display: inline;
  margin-left: 6px;
}
#true {
  color: palegreen;
}
#false {
  color: crimson;
}
</style>