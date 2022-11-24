<template>
  <b-container>
    <b-row align-h="center">
        <b-col>
            <diary-calendar/>
        </b-col>
        <b-col cols="1"></b-col>
        <b-col>
            <diary-detail/>
        </b-col>
    </b-row>
  </b-container>
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

<style scoped>
.container {
  background-color: #fee0bc;
  margin-top: 100px;
  margin-bottom: 100px;
  padding-top: 100px;
  padding-bottom: 50px;
  padding-left: 80px;
  padding-right: 80px;
  height: auto;
}
</style>
