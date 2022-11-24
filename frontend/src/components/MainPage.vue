<template>
  <div class="main-page">
    <main-goal></main-goal>
    <main-calendar></main-calendar>
    <main-video></main-video>
  </div>
</template>

<script>
import MainCalendar from "../components/main/MainCalendar.vue";
import MainGoal from "../components/main/MainGoal.vue";
import MainVideo from "../components/main/MainVideo.vue";
export default {
  components: {
    MainCalendar,
    MainGoal,
    MainVideo,
  },
};
</script>

<style>
.main-page {
  margin-top: 15px;
}
</style>
