<template>
  <div class="home">
    <h1>HomeView 페이지에용 ^.^</h1>
    <img alt="Vue logo" src="../assets/logo.png" />
    <router-view></router-view>
  </div>
</template>

<script>
<<<<<<< HEAD
import router from '../router';
import {mapGetters} from "vuex";

export default {
  name: "HomeView",
  components: {

  },
  computed: {
    ...mapGetters(["getUser"])
  },
  async created(){
    if(!JSON.parse(window.sessionStorage.getItem("user"))){
      router.push("/login");
    }
    await this.$store.dispatch("setUser", JSON.parse(window.sessionStorage.getItem("user")).email);
    this.$store.dispatch("setRecords", this.getUser.email);
    this.$store.dispatch("setRecordDates", this.getUser.email);
    // 오늘 날짜 세팅
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const date = today.getDate();
    this.$store.dispatch("setSelectedDate", year+'-'+month+'-'+date);
  }
=======
import router from "../router";
export default {
  name: "HomeView",
  components: {},
  created() {
    if (!JSON.parse(window.sessionStorage.getItem("user"))) {
      router.push("/login");
    }
  },
>>>>>>> main
};
</script>
