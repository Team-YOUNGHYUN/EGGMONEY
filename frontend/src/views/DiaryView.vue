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
import router from '../router';

export default {
  components: {
    CalendarDetail,
    DiaryDetail,
  },
  created(){
    if(!this.$store.getters.getCurrUser){
      router.push("/login");
    }
  }
};
</script>

<style></style>
