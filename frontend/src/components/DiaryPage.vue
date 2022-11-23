<template>
  <div>
    <h1>router: 여기부터 DiaryPage 영역이다!</h1>
    <diary-calendar />
    <diary-detail />
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

<style></style>
