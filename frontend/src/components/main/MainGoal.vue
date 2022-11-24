<template>
  <div class="main-goal">
    <br />
    <br />
    <h1 v-if="this.getQuest.type == 1">
        🔥 목표 체중까지 단 {{ this.getQuest.goal - this.getUser.weight }}kg! 🔥
    </h1>
    <h1 v-else-if="this.getQuest.type == 2">
        🔥 목표 체지방률까지 단 {{ this.getQuest.goal - this.getUser.bodyFat }}%! 🔥
    </h1>
    <h1 v-else-if="this.getQuest.type == 3">
        🔥 목표 골격근량까지 단 {{ this.getQuest.goal - this.getUser.muscleMass }}kg! 🔥
    </h1>
    <h1 v-else>아직 목표를 설정하지 않았습니다..</h1>
    <br />
    <div class="goal-text">
      <h3>기한: ~{{this.getQuest.dueDate}}까지</h3>
      <router-link to="/about/goal" class="updateBtn" style="color: black"> → 변경하러가기</router-link>
    </div>
    <br />
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
export default {
  name: "MainGoal",
  computed:{
    ...mapGetters(["getQuest", "getUser"])
  },
  methods:{
    test(){
        // console.log(this.getQuest)
        // console.log(this.getUser)
    }
  }
};
</script>

<style>
/* .main-goal {
  background-color: #;
  color: black;
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 2%;
} */

.updateBtn {
  text-decoration: none;
  color: white;
}
</style>
