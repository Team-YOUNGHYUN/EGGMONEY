import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state: {
    loginUser: {},
    quest: {},
    isUnqEmail: "",
    isUnqNickname: "",
    questionList: [],
    ableModifyCnt: 3,
    records: [],
    exerciseParts: [],
    exercises: [],
  },
  getters: {
    getLoginUser(state) {
      return state.loginUser;
    },
    getIsUnqEmail(state) {
      return state.isUnqEmail;
    },
    getIsUnqNickname(state) {
      return state.isUnqNickname;
    },
    getQuestionList(state) {
      return state.questionList;
    },
    getModifyCnt(state) {
      return state.ableModifyCnt;
    },
    getQuest(state) {
      return state.quest;
    },
    getRecords(state){
      return state.records;
    },
    getExerciseParts(state){
      return state.exerciseParts;
    },
    getExercises(state){
      return state.exercises;
    },
  },
  mutations: {
    INIT_ISUNQ(state) {
      state.isUnqEmail = false;
      state.isUnqNickname = false;
    },
    CHECK_EMAIL(state, payload) {
      if (payload === 0) {
        state.isUnqEmail = true;
        return;
      }
      state.isUnqEmail = false;
      return;
    },
    CHECK_NICKNAME(state, payload) {
      if (payload === 0) {
        state.isUnqNickname = true;
        return;
      }
      state.isUnqNickname = false;
      return;
    },
    QUESTION_LIST(state, payload) {
      state.questionList = payload;
    },
    GET_USER_INFO(state, payload) {
      state.loginUser = payload;
    },
    MODIFY_CNT(state) {
      state.ableModifyCnt -= 1;
    },
    GET_QUEST(state, payload) {
      state.quest = payload;
    },
    GET_RECORD_LIST(state, payload){
      state.records = payload;
    },
    GET_EXERCISE_PART_LIST(state, payload){
      state.exerciseParts = payload;
    },
    GET_EXERCISE_LIST(state, payload){
      state.exercises = payload;
    },
  },
  actions: {
    initIsUnq({ commit }) {
      commit("INIT_ISUNQ");
    },
    registUser({ commit }, user) {
      const API_URL = `${REST_API}/user`;
      let params = null;
      if (user) params = user;
      return axios({
        url: API_URL,
        method: "POST",
        params: params,
      })
        .then(() => {
          alert("회원가입이 완료되었습니다.");
          commit("REGIST_USER", params);
          router.push("/login");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    checkEmail({ commit }, email) {
      const API_URL = `${REST_API}/check/email=${email}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("CHECK_EMAIL", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    checkNickname({ commit }, nickname) {
      const API_URL = `${REST_API}/check/nickname=${nickname}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("CHECK_NICKNAME", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    questionList({ commit }) {
      const API_URL = `${REST_API}/question`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("QUESTION_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getUserInfo({ commit }, loginUserSeq) {
      const API_URL = `${REST_API}/user/${loginUserSeq}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("GET_USER_INFO", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    getQuest({ commit }, userSeq) {
      const API_URL = `${REST_API}/quest/${userSeq}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("GET_QUEST", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    modifyCnt({ commit }) {
      commit("MODIFY_CNT");
    },
    updateQuest({ commit }, quest) {
      const API_URL = `${REST_API}/quest`;
      let params = null;
      if (quest) params = quest;
      axios({
        url: API_URL,
        method: "POST",
        params: params,
      })
        .then(() => {
          alert("목표 수정이 완료되었습니다.");
          commit("UPDATE_QUEST", params);
          router.push("/quest");
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateUser(context, user) {
      const API_URL = `${REST_API}/user`;
      return axios({
        url: API_URL,
        method: "PUT",
        params: user,
      })
        .then(() => {
          alert("회원 정보가 수정되었습니다.");
        })
        .catch((err) => {
          alert("오류가 발생했습니다.");
          console.log(err);
        });
    },
    getRecordList(context, params){
      const API_URL = `${REST_API}/record`;
      return axios({
        url: API_URL,
        method: "GET",
        params: params,
      })
      .then((res)=>{
        context.commit("GET_RECORD_LIST", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
    getExercisePartList(context){
      const API_URL = `${REST_API}/exercise/part`;
      return axios({
        url: API_URL,
        method: "GET",
      })
      .then((res)=>{
        context.commit("GET_EXERCISE_PART_LIST", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
    getExerciseList(context){
      const API_URL = `${REST_API}/exercise`;
      return axios({
        url: API_URL,
        method: "GET",
      })
      .then((res)=>{
        context.commit("GET_EXERCISE_LIST", res.data);
      })
      .catch((err)=>{
        console.log(err);
      })
    },
  },
  modules: {},
});
