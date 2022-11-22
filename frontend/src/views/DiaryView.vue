<template>
  <div class="diary">
    <h1>EGG DIARY</h1>
    <calendar-detail />
    <diary-detail />
  </div>
</template>

<script>
import CalendarDetail from "@/components/diary/CalendarDetail.vue";
import DiaryDetail from "@/components/diary/DiaryDetail.vue";

export default {
  components: {
    CalendarDetail,
    DiaryDetail,
  },
};
</script>

<style></style>
