<template>
  <div class="container">
    <h1 class="quest-title">목표 관리</h1>
    <br />
    <h2 class="title">현재 신체 정보</h2>
    <label for="height">키</label>
    <input type="number" id="height" v-model="height" class="view" /><br />
    <label for="weight">몸무게</label>
    <input type="number" id="weight" v-model="weight" class="view" /><br />
    <label for="bodyFat">체지방률</label>
    <input type="number" id="bodyFat" v-model="bodyFat" class="view" /><br />
    <label for="muscleMass">골격근량</label>
    <input
      type="number"
      id="muscleMass"
      v-model="muscleMass"
      class="view"
    /><br /><br /><br />

    <!-- actual quest updates are made here -->
    <h2 class="title">운동 목표</h2>
    <fieldset class="text-center">
      <label form="dueDate">목표 날짜</label>
      <input type="date" id="dueDate" v-model="dueDate" class="view" />
      <br />
      <b-form-group>
        <br />
        <b-form-radio v-model="selected" value="weight">
          <label for="weight">체중(kg)</label>
          <input type="number" id="weigth" v-model="weight" class="view" />
        </b-form-radio>
        <b-form-radio v-model="selected" value="bodyFat">
          <label for="bodyFat">체지방률(%)</label>
          <input type="number" id="bodyFat" v-model="bodyFat" class="view" />
        </b-form-radio>
        <b-form-radio v-model="selected" value="muscleMass">
          <label for="muscleMass">골격근량(kg)</label>
          <input
            type="number"
            id="muscleMass"
            v-model="muscleMass"
            class="view"
          />
        </b-form-radio>
      </b-form-group>
    </fieldset>
    <br />
    <b-button>수정</b-button>
  </div>
</template>

<script>
export default {
  name: "QuestDetail",
};
</script>

<style></style>
