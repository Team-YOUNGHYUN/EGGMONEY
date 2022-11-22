<template>
  <header>
    <nav class="header-nav">
      <div><router-link to="/">EGGM🍳NEY</router-link></div>
      <div>
        <router-link to="/quest">Quest</router-link> |
        <router-link to="/diary">Diary</router-link>
      </div>
      <div v-if="getCurrUser" @click="logout">
        Logout
      </div>
    </nav>
  </header>
</template>

<script>
import router from "@/router";
import { mapGetters } from "vuex"
export default {
  name: "TheHeader",
  date(){
    return{

    }
  },
  computed:{
    ...mapGetters(["getCurrUser"])
  },
  methods:{
    async logout(){
      this.$store.dispatch("doLogout");
      window.sessionStorage.removeItem("user");
      router.push("/login");
    }
  }

};
</script>

<style></style>
