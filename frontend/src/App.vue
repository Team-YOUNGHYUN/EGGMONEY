<template>
  <div id="app">
    <the-header></the-header>
    <router-view></router-view>
    <the-footer></the-footer>
  </div>
</template>

<script>
import TheHeader from "./components/common/TheHeader.vue";
import TheFooter from "./components/common/TheFooter.vue";
import { mapState } from "vuex";
export default {
  components: {
    TheHeader,
    TheFooter,
  },
  computed: {
    ...mapState(["keyword1", "keyword2", "keyword3", "keyword4"]),
  },
  created() {
    this.$store.dispatch("searchYoutube1", this.keyword1);
    this.$store.dispatch("searchYoutube2", this.keyword2);
    this.$store.dispatch("searchYoutube3", this.keyword3);
    this.$store.dispatch("searchYoutube4", this.keyword4);
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
