<template>
    <div>
        <h1>router: 여기부터 MainPage 영역이다!</h1>
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
    components:{
        MainCalendar, MainGoal, MainVideo,
    }
}
</script>

<style>

</style>