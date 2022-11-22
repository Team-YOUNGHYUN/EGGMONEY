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
                <td v-if="record.exercisePart!=='유산소'">{{record.setCnt}}회</td>
                <td v-else>{{record.timeCnt}}분</td>
            </tr>
        </tbody>
    </table>
    

    <select id="part" v-model="exercisePart" @change="initExerciseName">
        <option value="" disabled>운동부위</option>
        <option v-for="(part, index) in this.getExerciseParts"
            :key="index"
            :value="part">
            {{part}}
        </option>
    </select>

    <select v-if="!exercisePart" id="part" @change="initExerciseCnt" disabled>
        <option value="">운동이름</option>
    </select>
    <input v-else-if="exerciseName==='custom'" v-model="customExerciseName"/>
    <select v-else id="part" v-model="exerciseName" @change="initExerciseCnt">
        <option value="" disabled>운동이름</option>
        <option v-for="exercise in this.activeExercises" :key="exercise.id" :value="exercise.name">
            {{exercise.name}}
        </option>
        <option value="custom">직접 입력</option>
    </select>
    
    <input v-if="!exerciseName" type="number" value=0 disabled>
    <input v-else-if="exercisePart!=='유산소'" type="number" v-model="setCnt">
    <input v-else type="number" v-model="timeCnt">  

    <button @click="test">confirm</button>

  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
    name: "DiaryDetail",
    data(){
        return {
            exercisePart: "",
            exerciseName: "",
            customExerciseName: "",
            setCnt: 0,
            timeCnt: 0,
            activeExercises: [],
            date: "2022-11-11",
            
        };
    },
    computed:{
        ...mapGetters(["getUser","getRecords",
        "getExerciseParts", "getExercises"])
    },
    methods:{
        test(){
            console.log(this.exercisePart);
            if(this.exerciseName!=='custom'){
                console.log(this.exerciseName);
            } else {
                console.log(this.customExerciseName);
            }
            if(this.exercisePart!=='유산소'){
                console.log(this.setCnt);
            } else {
                console.log(this.timeCnt);
            }
            
        },
        initExerciseName(){
            this.exerciseName = "";
            this.activeExercises = [];
            this.initExerciseCnt();
            for(let item of this.getExercises){
                if(item.part === this.exercisePart){
                    this.activeExercises.push(item);
                }
            }
        },
        initExerciseCnt(){
            this.setCnt = 0;
            this.timeCnt = 0;
        },
    },
    async created(){
        this.$store.dispatch("getExercisePartList");
        this.$store.dispatch("getExerciseList");
        await this.$store.dispatch("getUserInfo", 11);
        let params ={
            email: this.getUser.email,
            date: this.date,
        }
        this.$store.dispatch("getRecordList", params);
    }
}
</script>

<style>

</style>