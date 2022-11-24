<template>
  <div class="diary-container">
    <h1 class="diary-title">EGG DIARY</h1>
    <diary-calendar style="float: left; width: 40%; margin: 0px 5%" />
    <diary-detail style="float: left; width: 40%; margin: 5% 5%" />
  </div>
</template>

<script>
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
.diary-container {
  background-color: hsl(33, 97%, 87%);
  min-height: 800px;
  margin: 20px 40px;
  padding-top: 3%;
  padding-bottom: 3%;
}
</style>
