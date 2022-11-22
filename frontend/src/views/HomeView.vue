<template>
  <div class="home">
    <h1>HomeView 페이지에용 ^.^</h1>
    <img alt="Vue logo" src="../assets/logo.png" />
    <router-view></router-view>
  </div>
</template>

<script>

// import router from '../router';
export default {
  name: "HomeView",
  components: {

  },
  created(){
    // if(!this.$store.getters.getCurrUser){
    //   router.push("/login");
    // }
  }
};
</script>
