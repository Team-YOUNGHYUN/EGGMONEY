<template>
  <div class="container">
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <!-- get data from loginUser data -->
    <h2 class="title">현재 신체 정보</h2>
    <label for="height">키</label>
    <input
      type="number"
      id="height"
      v-model="getLoginUser.height"
      class="view"
    /><br />
    <label for="weight">몸무게</label>
    <input
      type="number"
      id="weight"
      v-model="getLoginUser.weight"
      class="view"
    /><br />
    <label for="bodyFat">체지방률</label>
    <input
      type="number"
      id="bodyFat"
      v-model="getLoginUser.bodyFat"
      class="view"
    /><br />
    <label for="muscleMass">골격근량</label>
    <input
      type="number"
      id="muscleMass"
      v-model="getLoginUser.muscleMass"
      class="view"
    /><br /><br /><br />

    <!-- actual quest updates are made here -->
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

    <!-- checkbox for modification confirmation -->
    <b-form-checkbox
      id="check-update"
      name="check-update"
      value="agree"
      unchecked-value="disagree"
    >
      목표 변경 가능 횟수 : {{ getModifyCnt }}회
    </b-form-checkbox>
    <br />
    <b-button @click="modifyCnt, checkUpdate">수정</b-button>
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
      goalWeight: 0,
      goalBodyFat: 0,
      goalMuscleMass: 0,
      selected: "",
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
    checkUpdate() {
      // 수정에 동의하는 checkbox가 check 되었는지 확인
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
