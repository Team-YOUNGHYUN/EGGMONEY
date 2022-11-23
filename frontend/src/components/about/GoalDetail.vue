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
            <input type="number" v-else disabled/>
            kg
            <br/>

            <input type="radio" v-model="type" value=2 id="bodyFat"/>
            <label for="bodyFat">체지방률:</label>
            <input type="number" v-model="goal" v-if="type==2" />
            <input type="number" v-else disabled/>
            %
            <br/>


            <input type="radio" v-model="type" value=3 id="muscleMass"/>
            <label for="muscleMass">골격근량:</label>
            <input type="number" v-model="goal" v-if="type==3" />
            <input type="number" v-else disabled/>
            kg
            <br/>
            
        </div>

        <br/>

        <label form="dueDate">목표 날짜</label>
        <input type="date" id="dueDate" v-model="getQuest.dueDate" class="view"/>

    </fieldset>
    <br/>
    <!-- <button @click="test">테스트</button> -->
    <!-- <b-button @click="getQuest">등록</b-button> -->
    </b-col>
    </b-row>
  </b-container>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    name: "GoalDetail",
    data(){
        return{
            type: 1,
            goal: 0,
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
        }
    },
    async created(){
        await this.$store.dispatch("setQuest", this.getUser.userSeq);
        console.log(this.$store.quest);
        if(this.getQuest.type!=0){
            this.type = this.getQuest.type;
            this.goal = this.getQuest.goal;
        }
        
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