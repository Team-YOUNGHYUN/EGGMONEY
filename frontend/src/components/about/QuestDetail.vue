<template>
  <div class="container">
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <!-- loginUser로부터 키, 몸무게, 체지방률, 골격근량을 받아와 show -->
    <legend>현재 신체 정보</legend>
    <label for="height">키(cm)</label>
    <input
      type="number"
      id="userHeight"
      v-model="getUser.height"
      class="view"
      disabled
    /><br />

    <label for="weight">몸무게(kg)</label>
    <input
      type="number"
      id="userWeight"
      v-model="getUser.weight"
      class="view"
      disabled
    /><br />
    <label for="bodyFat">체지방률(%)</label>
    <input
      type="number"
      id="userBodyFat"
      v-model="getUser.bodyFat"
      class="view"
      disabled
    /><br />
    <label for="muscleMass">골격근량(kg)</label>
    <input
      type="number"
      id="muscleMass"
      v-model="getUser.muscleMass"
      class="view"
      disabled
    /><br /><br /><br />

    <!-- 목표 설정 및 등록 -->
    <fieldset class="text-center">
      <legend>목표 설정</legend>
      <label form="dueDate">목표 날짜</label>
      <input
        type="date"
        id="dueDate"
        v-model="getQuest.dueDate"
        class="view"
        disabled
      />
      <br />

      <!-- 첫 번째: 체중 -->
      <div id="quest-type" v-if="(getQuest.type = 1)">
        <label for="goalWeight">체중(kg)</label>
        <input
          type="number"
          id="goalWeight"
          v-model="getQuest.goal"
          class="view"
          disabled
          checked
        />
      </div>
      <!-- 두 번째: 체지방률 -->
      <div id="quest-type" v-else-if="(getQuest.type = 2)">
        <br />
        <label for="goalBodyFat">체지방률(%)</label>
        <input
          type="number"
          id="goalBodyFat"
          v-model="getQuest.goal"
          class="view"
          disabled
          checked
        />
      </div>
      <!-- 세 번째: 골격근량 -->
      <div v-else-if="(getQuest.type = 3)">
        <br />
        <label for="goalMuscleMass">골격근량(kg)</label>
        <input
          type="number"
          id="goalMuscleMass"
          v-model="getQuest.goal"
          class="view"
          disabled
          checked
        />
      </div>
    </fieldset>
    <button @click="test">테스트</button>
    <br />

    <b-button><router-link to="/quest/update">수정</router-link></b-button>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "QuestRegist",
  data() {
    return {
      height: 0,
      weight: 0,
      bodyFat: 0,
      muscleMass: 0,
      dueDate: 0,
      selected: "",
      goal: 0,
      userSeq: 0,
    };
  },
  computed: {
    ...mapGetters(["getUser", "getQuest"]),
  },
  created() {
    this.$store.dispatch("getUserInfo", 1);
    this.$store.dispatch("getQuest", 1);
  },
  methods: {
    test() {
      console.log(this.getUser);
      console.log(this.getQuest);
    },
    // getQuest() {
    // let quest = {
    //   id: this.getQuest.id,
    //   dueDate: this.dueDate,
    //   type: this.selected,
    //   goal: this.goal,
    //   modifyCnt: this.getModifyCnt,
    //   userSeq: this.getUser.userSeq,
    // };
    // this.$store.dispatch("getQuest", this.getUser.userSeq);
    // },
  },
};
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
