<template>
  <div class="container">
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <!-- loginUser로부터 키, 몸무게, 체지방률, 골격근량을 받아와 show -->
    <h2 class="title">현재 신체 정보</h2>
    <label for="height">키(cm)</label>
    <input
      type="number"
      id="height"
      v-model="getLoginUser.height"
      disabled
    /><br />
    <label for="weight">몸무게(kg)</label>
    <input
      type="number"
      id="weight"
      v-model="getLoginUser.weight"
      disabled
    /><br />
    <label for="bodyFat">체지방률(%)</label>
    <input
      type="number"
      id="bodyFat"
      v-model="getLoginUser.bodyFat"
      disabled
    /><br />
    <label for="muscleMass">골격근량(kg)</label>
    <input
      type="number"
      id="muscleMass"
      v-model="getLoginUser.muscleMass"
      disabled
    /><br /><br /><br />

    <!-- 목표 설정 및 등록 -->
    <h2 class="title">목표 설정</h2>
    <fieldset class="text-center">
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
      <div v-if="(getQuest.type = 1)">
        <br />
        <b-form-radio v-model="selected" value="goalWeight" disabled>
          <label for="goalWeight">체중(kg)</label>
          <input
            type="number"
            id="goalWeigth"
            v-model="getQuest.goal"
            class="view"
            disabled
          />
        </b-form-radio>
      </div>
      <!-- 두 번째: 체지방률 -->
      <div v-else-if="(getQuest.type = 2)">
        <br />
        <b-form-radio v-model="selected" value="goalBodyFat" disabled>
          <label for="goalBodyFat">체지방률(%)</label>
          <input
            type="number"
            id="goalBodyFat"
            v-model="getQuest.goal"
            class="view"
            disabled
          />
        </b-form-radio>
      </div>
      <!-- 세 번째: 골격근량 -->
      <div v-else-if="(getQuest.type = 3)">
        <br />
        <b-form-radio v-model="selected" value="goalMuscleMass" disabled>
          <label for="goalMuscleMass">골격근량(kg)</label>
          <input
            type="number"
            id="goalMuscleMass"
            v-model="getQuest.goal"
            class="view"
            disabled
          />
        </b-form-radio>
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
    ...mapGetters(["getLoginUser", "getQuest"]),
  },
  created() {
    this.$store.dispatch("getUserInfo", 9);
    this.$store.dispatch("getQuest", 9);
  },
  methods: {
    test() {
      console.log(this.getLoginUser);
      console.log(this.getQuest);
    },
    // getQuest() {
    // let quest = {
    //   id: this.getQuest.id,
    //   dueDate: this.dueDate,
    //   type: this.selected,
    //   goal: this.goal,
    //   modifyCnt: this.getModifyCnt,
    //   userSeq: this.getLoginUser.userSeq,
    // };
    // this.$store.dispatch("getQuest", this.getLoginUser.userSeq);
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
