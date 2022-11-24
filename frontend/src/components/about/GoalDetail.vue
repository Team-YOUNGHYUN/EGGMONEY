<template>
  <b-container>
    <b-row align-h="center">
      <h1 class="quest-title" style="font-size: 2.5em">목표 관리</h1>
      <b-col class="d-flex flex-column align-item-center">
        <br />
        <!-- loginUser로부터 키, 몸무게, 체지방률, 골격근량을 받아와 show -->
        <h2 class="title">현재 신체 정보</h2>
        <div class="body-status" v-if="modifyMode == 0">
          <div class="input-group mb-3">
            <span class="input-group-text">키(cm)</span>
            <input
              type="number"
              id="height"
              v-model="getUser.height"
              disabled
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">몸무게(kg)</span>
            <input
              type="number"
              id="weight"
              v-model="getUser.weight"
              disabled
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">체지방률(%)</span>
            <input
              type="number"
              id="bodyFat"
              v-model="getUser.bodyFat"
              disabled
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">골격근량(kg)</span>
            <input
              type="number"
              id="muscleMass"
              v-model="getUser.muscleMass"
              disabled
              style="text-align: right"
            />
          </div>

          <b-button variant="dark" @click="activeModifyMode">수정</b-button>
        </div>
        <!-- 신체 정보 수정 -->
        <div class="body-status" v-else-if="modifyMode == 1">
          <div class="input-group mb-3">
            <span class="input-group-text">키(cm)</span>
            <input
              type="number"
              id="height"
              v-model="getUser.height"
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">몸무게(kg)</span>
            <input
              type="number"
              id="weight"
              v-model="getUser.weight"
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">체지방률(%)</span>
            <input
              type="number"
              id="bodyFat"
              v-model="getUser.bodyFat"
              style="text-align: right"
            />
          </div>
          <div class="input-group mb-3">
            <span class="input-group-text">골격근량(kg)</span>
            <input
              type="number"
              id="muscleMass"
              v-model="getUser.muscleMass"
              style="text-align: right"
            />
          </div>
          <b-button variant="dark" @click="updateUser">완료</b-button>
        </div>
      </b-col>

      <!-- 목표 설정 및 등록 -->
      <b-col class="col-right">
        <h2 class="title">목표 설정</h2>
        <fieldset>
          <div class="d-flex flex-column align-item-center">
            <div class="input-group mb-3">
              <input type="radio" v-model="type" value="1" id="weight" />
              <span class="input-group-text">체중(kg)</span>
              <input type="number" v-model="goal" v-if="type == 1" />
              <input
                type="number"
                v-else-if="type == 0 && getQuest.type == 1"
                v-model="goal"
                disabled
              />
              <input type="number" v-else disabled />
            </div>

            <div class="input-group mb-3">
              <input type="radio" v-model="type" value="2" id="bodyFat" />
              <span class="input-group-text">체지방률(%)</span>
              <input type="number" v-model="goal" v-if="type == 2" />
              <input
                type="number"
                v-else-if="type == 0 && getQuest.type == 2"
                v-model="goal"
                disabled
              />
              <input type="number" v-else disabled />
            </div>

            <div class="input-group mb-3">
              <input type="radio" v-model="type" value="3" id="muscleMass" />
              <span class="input-group-text">골격근량(kg)</span>
              <input type="number" v-model="goal" v-if="type == 3" />
              <input
                type="number"
                v-else-if="type == 0 && getQuest.type == 3"
                v-model="goal"
                disabled
              />
              <input type="number" v-else disabled />
            </div>
            <h3 v-if="this.type == 1">
              목표까지 {{ this.goal - this.getUser.weight }}kg!
            </h3>
            <h3 v-else-if="this.type == 2">
              목표까지 {{ this.goal - this.getUser.bodyFat }}%!
            </h3>
            <h3 v-else-if="this.type == 3">
              목표까지 {{ this.goal - this.getUser.muscleMass }}kg!
            </h3>
            <h3 v-else-if="this.getQuest.type == 1">
              목표까지 {{ this.goal - this.getUser.weight }}kg!
            </h3>
            <h3 v-else-if="this.getQuest.type == 2">
              목표까지 {{ this.goal - this.getUser.bodyFat }}%!
            </h3>
            <h3 v-else-if="this.getQuest.type == 3">
              목표까지 {{ this.goal - this.getUser.muscleMass }}kg!
            </h3>
          </div>
          <label form="dueDate">목표 날짜</label>
          <input type="date" id="dueDate" v-model="dueDate" class="view" />
          <div class="modCnt">
            현재까지 목표 수정 횟수: {{ this.getQuest.modifyCnt }}번
          </div>
        </fieldset>
        <br />
        <b-button variant="dark" @click="updateQuest">등록</b-button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";
import router from "@/router";

export default {
  name: "GoalDetail",
  data() {
    return {
      type: 0,
      goal: 0,
      dueDate: "",
      modifyCnt: 0,
      modifyMode: 0,
    };
  },
  computed: {
    ...mapGetters(["getUser", "getQuest"]),
  },
  methods: {
    activeModifyMode() {
      this.modifyMode = 1;
    },
    updateUser() {
      this.$store.dispatch("updateUser", this.getUser);
      (this.modifyMode = 0), router.push("/about/goal");
    },
    updateQuest() {
      console.log(this.dueDate);
      let quest = {
        id: 0,
        type: this.type,
        goal: this.goal,
        dueDate: this.dueDate,
        modifyCnt: this.modifyCnt + 1,
        userSeq: this.getUser.userSeq,
      };
      this.$store.dispatch("updateQuest", quest);
      router.push("/about/goal");
      this.type = 0;
    },
  },
  async created() {
    await this.$store.dispatch("setQuest", this.getUser.userSeq);
    // this.type = this.getQuest.type;
    this.goal = this.getQuest.goal;
    this.dueDate = this.getQuest.dueDate;
    this.modifyCnt = this.getQuest.modifyCnt;
  },
};
</script>

<style scoped>
.container {
  margin-top: 30px;
  margin-bottom: 30px;
  padding-top: 30px;
  padding-bottom: 30px;
  padding-left: 100px;
  padding-right: 100px;
  background: hsl(33, 97%, 87%);
  color: black;
}

.input-group-text {
  width: 115px;
}

.input-group {
  width: 380px;
  margin: 0 auto;
}

.modCnt {
  margin-top: 15px;
}

input {
  margin-right: 5px;
}

label {
  margin-right: 10px;
}
</style>
