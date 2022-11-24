<template>
  <div class="about">
    <router-view />
  </div>
</template>

<script>
import router from "../router";
export default {
  async created() {
    if (!JSON.parse(window.sessionStorage.getItem("user"))) {
      router.push("/login");
    }
    await this.$store.dispatch(
      "setUser",
      JSON.parse(window.sessionStorage.getItem("user")).email
    );
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

<style></style>
