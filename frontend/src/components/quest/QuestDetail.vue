<template>
  <div class="container">
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <fieldset class="title">
      <legend>현재 신체 정보</legend>
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
        v-model="bodyFat"
        class="view"
        disabled
      /><br />
      <label for="muscleMass">골격근량(kg)</label>
      <input
        type="number"
        id="muscleMass"
        v-model="muscleMass"
        class="view"
        disabled
      /><br /><br /><br />
    </fieldset>

    <fieldset class="title">
      <legend>운동 목표</legend>
      <label form="dueDate">목표 날짜</label>
      <input type="date" id="dueDate" v-model="dueDate" class="view" disabled />
      <br />
      <br />
      <label for="weight">체중(kg)</label>
      <input type="number" id="weigth" v-model="weight" class="view" disabled />
      <br />
      <label for="bodyFat">체지방률(%)</label>
      <input
        type="number"
        id="bodyFat"
        v-model="bodyFat"
        class="view"
        disabled
      />
      <br />
      <label for="muscleMass">골격근량(kg)</label>
      <input
        type="number"
        id="muscleMass"
        v-model="muscleMass"
        class="view"
        disabled
      />
    </fieldset>
    <br />
    <b-button> <router-link to="quest/regist">수정</router-link> </b-button>
  </div>
</template>

<script>
export default {
  name: "QuestDetail",
  data() {
    return {
      height: 0,
      weight: 0,
      bodyFat: 0,
      muscleMass: 0,
      dueDate: 0,
      type: 0,
      goal: "",
      userSeq: 0,
    };
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
