<template>
  <div class="container">
    <h1>다이어리 페이지이다.</h1>
    <h2>일단 운동 기록 기능부터 만들 것..</h2>

    <table class="table" style="background-color: palegreen">
        <thead>
            <th>운동부위</th>
            <th>운동이름</th>
            <th>운동횟수(시간)</th>
        </thead>
        <tbody>
            <tr v-for="record in this.getRecords" 
                :key="record.id">
                <td>{{record.exercisePart}}</td>
                <td>{{record.exerciseName}}</td>
                <td v-if="record.exercisePart==='유산소'">{{record.timeCnt}}</td>
                <td v-else>{{record.setCnt}}</td>
            </tr>
        </tbody>
    </table>
    

    <select id="exercisePart" v-model="exercisePart">
        <option value="" disabled>운동부위</option>
        <!-- <option v-for="exercise in this.getExerciseParts"
            :key="">
            {{record.exercisePart}}
        </option> -->
    </select>
    

  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    name: "DiaryDetail",
    data(){
        return {
            exercisePart: "",
            date: "2022-11-11",
        };
    },
    computed:{
        ...mapGetters(["getLoginUser","getRecords",
        "getExerciseParts, getExerciseNames"])
    },
    async created(){
        await this.$store.dispatch("getUserInfo", 11);
        let params ={
            // email: this.getLoginUser.email,
            email: this.getLoginUser.email,
            date: this.date,
        }
        this.$store.dispatch("getRecordList", params);
    }
}
</script>

<style>

</style>