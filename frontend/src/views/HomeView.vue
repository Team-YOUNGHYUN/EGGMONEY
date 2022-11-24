<template>
  <div class="home">
    <router-view></router-view>
  </div>
</template>

<script>
import router from "../router";
import { mapGetters } from "vuex";

export default {
  name: "HomeView",
  components: {},
  computed: {
    ...mapGetters(["getUser"]),
  },
  async created() {
    if (!JSON.parse(window.sessionStorage.getItem("user"))) {
      router.push("/login");
    }
    await this.$store.dispatch(
      "setUser",
      JSON.parse(window.sessionStorage.getItem("user")).email
    );
    this.$store.dispatch("setQuest", this.getUser.userSeq);
    this.$store.dispatch("setRecords", this.getUser.email);
    this.$store.dispatch("setRecordDates", this.getUser.email);
    // 오늘 날짜 세팅
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const date = today.getDate();
    this.$store.dispatch("setSelectedDate", year + "-" + month + "-" + date);
  },
};
</script>

<style scoped>
.home{
  background-color: #fee0bc;
  padding-bottom: 100px;
  margin-bottom: 20px;
  height: auto;
}
</style>