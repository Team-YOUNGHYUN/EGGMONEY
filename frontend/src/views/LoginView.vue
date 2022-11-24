<template>
  <div class="login">
    <h1>Welcome ^.^</h1>
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
  color: green;
}
#false {
  color: crimson;
}
</style>