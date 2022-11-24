<template>
  <div class="diary">
    <div class="record-list">
      <h2 style="text-align: left">오늘 나는...</h2>
      <!-- record list 받아올 수 있음 -->
      <ul class="list-group">
        <li v-for="(recordItem, index) in records" :key="index">
          {{ recordItem }}
          <span
            class="removeBtn"
            typeof="button"
            @click="removeRecord(recordItem, index)"
          >
            <i class="bi bi-backspace"></i>
            <!-- 삭제 아이콘 -->
          </span>
        </li>
      </ul>
    </div>

    <div class="add-list">
      <h2 style="text-align: left">그리고...</h2>
      <table class="table" style="background-color: #ffd95b">
        <thead>
          <th>운동부위</th>
          <th>운동이름</th>
          <th>운동횟수(시간)</th>
        </thead>
        <tbody>
          <tr v-for="(record, index) in this.getDayRecords" :key="index">
            <td>{{ record.exercisePart }}</td>
            <td>{{ record.exerciseName }}</td>
            <td v-if="record.exercisePart !== '유산소'">
              {{ record.setCnt }}회
            </td>
            <td v-else>{{ record.timeCnt }}분</td>
          </tr>
        </tbody>
      </table>

      <select id="part" v-model="exercisePart" @change="initExerciseName">
        <option value="" disabled>운동부위</option>
        <option
          v-for="(part, index) in this.getExerciseParts"
          :key="index"
          :value="part"
        >
          {{ part }}
        </option>
      </select>

      <select v-if="!exercisePart" id="part" @change="initExerciseCnt" disabled>
        <option value="">운동이름</option>
      </select>
      <input
        v-else-if="exerciseName === 'custom'"
        v-model="customExerciseName"
      />
      <select v-else id="part" v-model="exerciseName" @change="initExerciseCnt">
        <option value="" disabled>운동이름</option>
        <option
          v-for="exercise in this.activeExercises"
          :key="exercise.id"
          :value="exercise.name"
        >
          {{ exercise.name }}
        </option>
        <option value="custom">직접 입력</option>
      </select>

      <input v-if="!exerciseName" type="number" value="0" disabled />
      <input
        v-else-if="exercisePart !== '유산소'"
        type="number"
        v-model="setCnt"
      />
      <input v-else type="number" v-model="timeCnt" />

      <b-button variant="dark" @click="test">추가</b-button>
    </div>

    <div class="comment-box">
      <h2 style="text-align: left">하루 갈무리</h2>
      <div class="form-group">
        <textarea
          class="form-control"
          id="exampleFormControlTextarea1"
          rows="3"
        ></textarea>
        <br />
        <b-button variant="dark">등록</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "DiaryDetail",
  data() {
    return {
      exercisePart: "",
      exerciseName: "",
      customExerciseName: "",
      setCnt: 0,
      timeCnt: 0,
      activeExercises: [],
    };
  },
  computed: {
    ...mapGetters([
      "getUser",
      "getRecords",
      "getRecordDates",
      "getDayRecords",
      "getExerciseParts",
      "getExercises",
      "getSelectedDate",
    ]),
  },
  methods: {
    test() {
      console.log(this.exercisePart);
      if (this.exerciseName !== "custom") {
        console.log(this.exerciseName);
      } else {
        console.log(this.customExerciseName);
      }
      if (this.exercisePart !== "유산소") {
        console.log(this.setCnt);
      } else {
        console.log(this.timeCnt);
      }
    },
    initExerciseName() {
      this.exerciseName = "";
      this.activeExercises = [];
      this.initExerciseCnt();
      for (let item of this.getExercises) {
        if (item.part === this.exercisePart) {
          this.activeExercises.push(item);
        }
      }
    },
    initExerciseCnt() {
      this.setCnt = 0;
      this.timeCnt = 0;
    },
  },
  async created() {
    // 오늘 날짜 세팅
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const date = today.getDate();
    this.$store.dispatch("setSelectedDate", year + "-" + month + "-" + date);
    this.$store.dispatch("setExercisePartList");
    this.$store.dispatch("setExerciseList");
    let params = {
      records: this.getRecords,
      date: this.getSelectedDate,
    };
    this.$store.dispatch("setDayRecords", params);
  },
};
</script>

<style>
.diary {
  background-color: #fee0bc;
}

textarea {
  resize: none;
}

.record-list,
.add-list,
.comment-box {
  margin-bottom: 25px;
}
</style>
