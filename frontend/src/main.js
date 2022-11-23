import Vue from "vue";
import "./plugins/axios";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import Vcalendar from "v-calendar";
import BootstrapVue from "bootstrap-vue";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(Vcalendar, {
  componentPrefix: "vc",
  // 커스텀 사이즈 설정
  // screens: {
  //   tablet: "575px",
  //   laptop: "990px",
  //   desktop: "1200px",
  // },
});

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
