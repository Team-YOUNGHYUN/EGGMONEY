<template>
  <div class="about">
    <router-view />
  </div>
</template>

<script>
import router from "../router";
export default {
  created() {
    if (!JSON.parse(window.sessionStorage.getItem("user"))) {
      router.push("/login");
    }
  },
};
</script>

<style></style>
