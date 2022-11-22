<template>
  <div class="user">
    <img alt="Vue logo" src="../assets/logo.png" />
    <router-view />
  </div>
</template>

<script>
import router from '../router';
export default {
    data(){
      return {

      }
    },
    created(){
      if(!this.$store.getters.getCurrUser){
        router.push("/login");
      }
    }

};
</script>

<style></style>
