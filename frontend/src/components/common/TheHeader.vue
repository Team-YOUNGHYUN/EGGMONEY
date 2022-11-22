<template>
  <header>
    <nav class="header-nav">
      <div><router-link to="/">EGGM🍳NEY</router-link></div>
      <div>HomeView : 
        <router-link to="/">Main</router-link> |
        <router-link to="/diary">Diary</router-link>
      </div>
      <div>AboutView : 
        <router-link to="/about/user">UserDetail</router-link> |
        <router-link to="/about/goal">GoalDetail</router-link> |
        <router-link to="/about/shop">MoneyShop</router-link>
      </div>
      <div>LoginView :
        <router-link to="/login">Login</router-link> |
        <router-link to="/login/regist">Regist</router-link> |
        <router-link to="/login/findpw">Findpw</router-link> |
        <div v-if="getCurrUser" @click="logout">Logout</div>
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

<style>
.header-nav{
  background-color: yellow;
}
</style>
