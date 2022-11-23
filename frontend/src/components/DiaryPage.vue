<template>
  <div class="container">
    <h1>router: 여기부터 DiaryPage 영역이다!</h1>
    <diary-calendar style="float: left; width:40%; margin:0px 5%"/>
    <diary-detail style="float: left; width:40%; margin:0px 5%"/>
  </div>
</template>

<script>
// import MainCalendar from "../components/diary";
import DiaryCalendar from "./diary/DiaryCalendar.vue";
import DiaryDetail from './diary/DiaryDetail.vue'

export default {
    data(){
        return{
            
        }
    },
    components: {
        DiaryCalendar, DiaryDetail,
    },
};
</script>

<style>
.container{
    height: 500px;
}
</style>
