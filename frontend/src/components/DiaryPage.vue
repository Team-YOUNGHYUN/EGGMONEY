<template>
  <div class="container">
    <diary-calendar style="float: left; width: 40%; margin: 0px 5%" />
    <diary-detail style="float: left; width: 40%; margin: 0px 5%" />
  </div>
</template>

<script>
// import MainCalendar from "../components/diary";
import DiaryCalendar from "./diary/DiaryCalendar.vue";
import DiaryDetail from "./diary/DiaryDetail.vue";

export default {
  data() {
    return {};
  },
  components: {
    DiaryCalendar,
    DiaryDetail,
  },
};
</script>

<style>
.container {
  height: 500px;
}
</style>
