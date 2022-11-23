<template>
  <div class="main-goal">
    <br />
    <br />
    <h1>목표</h1>
    <br />
    <div class="goal-text">
      Due dueDate
      <b-button variant="light"
        ><router-link to="/about/goal">변경</router-link></b-button
      >
    </div>
    <br />
    <p>오늘의 명언</p>
  </div>
</template>

<script>
export default {
  name: "MainGoal",
};
</script>

<style>
.main-goal {
  background-color: #1a202c;
  color: white;
}
</style>
