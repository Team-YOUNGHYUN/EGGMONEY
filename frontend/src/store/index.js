import Vue from 'vue'
import Vuex from 'vuex'
import axios from "axios";
import router from '@/router';
// import router from "../router";

Vue.use(Vuex)

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state: {
    user: {},
    loginUser: null,

  },
  getters: {
  },
  mutations: {
  },
  actions: {
    registUser({commit}, user) {
      const API_URL = `${REST_API}/user`;
      let params = null
      if(user) params = user;
      axios({
        url: API_URL,
        method: "POST",
        params: params,
      })
      .then(()=>{
        alert('회원가입이 완료되었습니다.');
        commit("REGIST_USER", params);
        router.push("/login");
      })
      .catch((err)=>{
        console.log(err);
      })
    }
  },
  modules: {
  }
})
