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

    <!-- 목표 설정 및 변경 -->
    <h2 class="title">목표 설정</h2>
    <fieldset class="text-center">
      <label form="dueDate">목표 날짜</label>
      <input type="date" id="dueDate" v-model="dueDate" class="view" />
      <br />
      <b-form-group>
        <br />
        <b-form-radio v-model="selected" value="goalWeight">
          <label for="goalWeight">체중(kg)</label>
          <input type="number" id="goalWeigth" class="view" />
        </b-form-radio>
        <b-form-radio v-model="selected" value="goalBodyFat">
          <label for="goalBodyFat">체지방률(%)</label>
          <input type="number" id="goalBodyFat" class="view" />
        </b-form-radio>
        <b-form-radio v-model="selected" value="goalMuscleMass">
          <label for="goalMuscleMass">골격근량(kg)</label>
          <input type="number" id="goalMuscleMass" class="view" />
        </b-form-radio>
      </b-form-group>
    </fieldset>
    <br />

    <!-- 변경 사항 확인을 위한 checkbox -->
    <b-form-checkbox
      id="check-update"
      name="check-update"
      value="agree"
      unchecked-value="disagree"
    >
      목표 변경 가능 횟수 : {{ getModifyCnt }}회
    </b-form-checkbox>
    <br />
    <b-button @click="modifyCnt, update">수정</b-button>
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
      dueDate: "",
      selected: "",
      goal: "",
      userSeq: "",
    };
  },
  computed: {
    ...mapGetters(["getLoginUser", "getModifyCnt"]),
  },
  created() {
    this.$store.dispatch("getUserInfo", 9);
  },
  methods: {
    modifyCnt() {
      this.$store.dispatch("modifyCnt");
    },
    update() {
      let quest = {
        id: this.id,
        dueDate: this.dueDate,
        type: this.selected, // select된 radio의 value를 저장
        goal: this.goal,
        modifyCnt: this.getModifyCnt,
        userSeq: this.getLoginUser.userSeq,
      };
      this.$store.dispatch("updateQuest", quest);
    },
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
