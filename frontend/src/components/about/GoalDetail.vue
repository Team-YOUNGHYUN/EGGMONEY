<template>
  <b-container>
    <h1>router: 여기부터 goalDetail 영역이다!</h1>

    <b-row>
    <b-col>
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <!-- loginUser로부터 키, 몸무게, 체지방률, 골격근량을 받아와 show -->
    <h2 class="title">현재 신체 정보</h2>

    <div v-if="modifyMode==0">
        <label for="height">키: </label>
        <input type="number" id="height" v-model="getUser.height" disabled style="text-align: right;"/>cm<br />
        <label for="weight">몸무게: </label>
        <input type="number" id="weight" v-model="getUser.weight" disabled style="text-align: right;"/>kg<br />
        <label for="bodyFat">체지방률: </label>
        <input
        type="number"
        id="bodyFat"
        v-model="getUser.bodyFat"
        disabled
        style="text-align: right;"
        />%<br />
        <label for="muscleMass">골격근량: </label>
        <input
        type="number"
        id="muscleMass"
        v-model="getUser.muscleMass"
        disabled
        style="text-align: right;"
        />kg<br /><br /><br />
        <button @click="activeModifyMode">신체 정보 갱신하기</button>
    </div>

    <div v-else-if="modifyMode==1">
        <label for="height">키: </label>
        <input type="number" id="height" v-model="getUser.height" style="text-align: right;"/>cm<br />
        <label for="weight">몸무게: </label>
        <input type="number" id="weight" v-model="getUser.weight" style="text-align: right;"/>kg<br />
        <label for="bodyFat">체지방률: </label>
        <input
        type="number"
        id="bodyFat"
        v-model="getUser.bodyFat"
        style="text-align: right;"
        />%<br />
        <label for="muscleMass">골격근량: </label>
        <input
        type="number"
        id="muscleMass"
        v-model="getUser.muscleMass"
        style="text-align: right;"
        />kg<br /><br /><br />
        <button @click="updateUser">갱신</button>
    </div>

    
    
    </b-col>


    <!-- 목표 설정 및 등록 -->
    <b-col>
    <h2 class="title">목표 설정</h2>
    <fieldset class="text-center">
        <div>
            <input type="radio" v-model="type" value=1 id="weight"/>
            <label for="weight">체중:</label>
            <input type="number" v-model="goal" v-if="type==1"/>
            <input type="number" v-else-if="type==0 && getQuest.type==1" v-model="goal" disabled/>
            <input type="number" v-else disabled/>
            kg
            <br/>

            <input type="radio" v-model="type" value=2 id="bodyFat"/>
            <label for="bodyFat">체지방률:</label>
            <input type="number" v-model="goal" v-if="type==2" />
            <input type="number" v-else-if="type==0 && getQuest.type==2" v-model="goal" disabled/>
            <input type="number" v-else disabled/>
            %
            <br/>


            <input type="radio" v-model="type" value=3 id="muscleMass"/>
            <label for="muscleMass">골격근량:</label>
            <input type="number" v-model="goal" v-if="type==3" />
            <input type="number" v-else-if="type==0 && getQuest.type==3" v-model="goal" disabled/>
            <input type="number" v-else disabled/>
            kg
            <br/>
            <h3 v-if="this.type==1">목표까지 {{this.goal-this.getUser.weight}}kg!</h3>
            <h3 v-else-if="this.type==2">목표까지 {{this.goal-this.getUser.bodyFat}}%!</h3>
            <h3 v-else-if="this.type==3">목표까지 {{this.goal-this.getUser.muscleMass}}kg!</h3>
            <h3 v-else-if="this.getQuest.type==1">목표까지 {{this.goal-this.getUser.weight}}kg!</h3>
            <h3 v-else-if="this.getQuest.type==2">목표까지 {{this.goal-this.getUser.bodyFat}}%!</h3>
            <h3 v-else-if="this.getQuest.type==3">목표까지 {{this.goal-this.getUser.muscleMass}}kg!</h3>
            <div>당신은 지금까지 목표를 {{this.getQuest.modifyCnt}}번 수정했다..</div>


        </div>

        <br/>

        <label form="dueDate">목표 날짜</label>
        <input type="date" id="dueDate" v-model="dueDate" class="view"/>

    </fieldset>
    <br/>
    <!-- <button @click="test">테스트</button> -->
    <b-button @click="updateQuest">등록</b-button>
    </b-col>
    </b-row>
  </b-container>
</template>

<script>
import {mapGetters} from 'vuex';
import router from '@/router';

export default {
    name: "GoalDetail",
    data(){
        return{
            type: 0,
            goal: 0,
            dueDate: '',
            modifyCnt: 0,
            modifyMode: 0,
        }
    },
    computed:{
        ...mapGetters(["getUser", "getQuest"]),
    },
    methods:{
        activeModifyMode(){
            this.modifyMode = 1;
        },
        updateUser(){
            this.$store.dispatch("updateUser", this.getUser);
            this.modifyMode = 0,
            router.push("/about/goal");
        },
        updateQuest(){
            console.log(this.dueDate)
            let quest = {
                id: 0,
                type: this.type,
                goal: this.goal,
                dueDate: this.dueDate,
                modifyCnt: this.modifyCnt+1,
                userSeq: this.getUser.userSeq
            }
            this.$store.dispatch("updateQuest", quest);
            router.push("/about/goal");
            this.type = 0;
        }
    },
    async created(){
        await this.$store.dispatch("setQuest", this.getUser.userSeq);
        // this.type = this.getQuest.type;
        this.goal = this.getQuest.goal;
        this.dueDate = this.getQuest.dueDate;
        this.modifyCnt = this.getQuest.modifyCnt;
    }
}
</script>

<style>
.container {
  /* margin-top: 70px;
    padding-top: 100px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 100px; */
  background: gray;
  color: white;
}
</style>