<template>
  <div class="login">
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