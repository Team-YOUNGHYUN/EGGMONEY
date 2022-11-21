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
    isUnqEmail: '',
    isUnqNickname: '',
    questionList: [],
  },
  getters: {
    getIsUnqEmail(state){
      return state.isUnqEmail;
    },
    getIsUnqNickname(state){
      return state.isUnqNickname;
    },
    getQuestionList(state){
      return state.questionList;
    },
  },
  mutations: {
    INIT_ISUNQ(state){
      state.isUnqEmail = false;
      state.isUnqNickname = false;
    },
    CHECK_EMAIL(state, payload){
      if(payload === 0){
        state.isUnqEmail = true;
        alert("사용 가능한 이메일입니다.");
        return;
      }
      state.isUnqEmail = false;
      alert("이미 존재하는 이메일입니다.");
      return;
    },
    CHECK_NICKNAME(state, payload){
      if(payload === 0){
        state.isUnqNickname = true;
        alert("사용 가능한 닉네임입니다.");
        return;
      }
      state.isUnqNickname = false;
      alert("이미 존재하는 닉네임입니다.");
      return;
    },
    QUESTION_LIST(state, payload){
      state.questionList = payload;
    }
  },
  actions: {
    initIsUnq({commit}){
      commit("INIT_ISUNQ");
    },
    registUser({commit}, user) {
      const API_URL = `${REST_API}/user`;
      let params = null;
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
    },
    checkEmail({commit}, email){
      const API_URL = `${REST_API}/check/email=${email}`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res)=>{
        commit("CHECK_EMAIL", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
    checkNickname({commit}, nickname){
      const API_URL = `${REST_API}/check/nickname=${nickname}`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res)=>{
        commit("CHECK_NICKNAME", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
    questionList({commit}){
      const API_URL = `${REST_API}/question`;
      axios({
        url: API_URL,
        method: "GET",
      })
      .then((res)=>{
        commit("QUESTION_LIST", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
  },
  modules: {
  }
})
