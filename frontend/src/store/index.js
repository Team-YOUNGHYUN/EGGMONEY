import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import router from "@/router";

Vue.use(Vuex);

const REST_API = `http://localhost:9999/api`;

export default new Vuex.Store({
  state: {
    user: {},
    checkPassword: "",
    checkAnswer: "",
    quest: {},
    question: "",
    isUnqEmail: "",
    isUnqNickname: "",
    questionList: [],
    ableModifyCnt: 3,
    exerciseParts: [],
    exercises: [],
    seletedDate: "",
    records: [],
    recordDates: [],
    dayRecords: [],
    comment: "",
    // 유튜브 검색 =========================
    videos1: [],
    videos2: [],
    videos3: [],
    videos4: [],
    video1: null,
    video2: null,
    video3: null,
    video4: null,
    keyword1: "상체 운동",
    keyword2: "하체 운동",
    keyword3: "코어 운동",
    keyword4: "유산소 운동",
    // =====================================
  },
  getters: {
    getUser(state) {
      return state.user;
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
    getExerciseParts(state) {
      return state.exerciseParts;
    },
    getExercises(state) {
      return state.exercises;
    },
    getCheckPassword(state) {
      return state.checkPassword;
    },
    getSelectedDate(state) {
      return state.seletedDate;
    },
    getRecords(state) {
      return state.records;
    },
    getRecordDates(state) {
      return state.recordDates;
    },
    getDayRecords(state) {
      return state.dayRecords;
    },
    getQuestion(state) {
      return state.question;
    },
    getCheckAnswer(state) {
      return state.checkAnswer;
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
    MODIFY_CNT(state) {
      state.ableModifyCnt -= 1;
    },
    SET_QUEST(state, payload) {
      state.quest = payload;
    },
    SET_EXERCISE_PART_LIST(state, payload) {
      state.exerciseParts = payload;
    },
    SET_EXERCISE_LIST(state, payload) {
      state.exercises = payload;
    },
    SET_USER(state, payload) {
      state.user = payload;
    },
    CHECK_PASSWORD(state, payload) {
      state.checkPassword = payload;
    },
    SET_SELECTED_DATE(state, payload) {
      state.seletedDate = payload;
    },
    SET_RECORDS(state, payload) {
      state.records = payload;
    },
    SET_RECORD_DATES(state, payload) {
      state.recordDates = payload;
    },
    SET_DAY_RECORDS(state, payload) {
      state.dayRecords = payload;
    },
    // 유튜브 검색 ===========================================
    SEARCH_YOUTUBE1(state, videos1) {
      state.videos1 = videos1;
    },
    SEARCH_YOUTUBE2(state, videos2) {
      state.videos2 = videos2;
    },
    SEARCH_YOUTUBE3(state, videos3) {
      state.videos3 = videos3;
    },
    SEARCH_YOUTUBE4(state, videos4) {
      state.videos4 = videos4;
    },
    SET_KEYWORD1(state, keyword1) {
      state.keyword1 = keyword1;
    },
    SET_KEYWORD2(state, keyword2) {
      state.keyword2 = keyword2;
    },
    SET_KEYWORD3(state, keyword3) {
      state.keyword3 = keyword3;
    },
    SET_KEYWORD4(state, keyword4) {
      state.keyword4 = keyword4;
    },
    SELECT_QUESTION(state, payload) {
      state.question = payload;
    },
    CHECK_ANSWER(state, payload) {
      if (payload == 1) {
        state.checkAnswer = true;
        return;
      }
      state.checkAnswer = false;
      return;
    },
    INIT_QUESTION(state) {
      state.question = "";
    },
    SELECT_COMMENT(state, payload){
      state.comment = payload;
    },

    // =======================================================
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
    setQuest({ commit }, userSeq) {
      const API_URL = `${REST_API}/quest/${userSeq}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          commit("SET_QUEST", res.data);
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
      console.log(quest);
      axios({
        url: API_URL,
        method: "PUT",
        params: quest,
      })
        .then(() => {
          commit("SET_QUEST", quest);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updateUser(context, user) {
      const API_URL = `${REST_API}/user`;
      console.log(user);
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
    setExercisePartList(context) {
      const API_URL = `${REST_API}/exercise/part`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SET_EXERCISE_PART_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setExerciseList(context) {
      const API_URL = `${REST_API}/exercise`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SET_EXERCISE_LIST", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    loginCheck(context, params) {
      const API_URL = `${REST_API}/user/login`;
      return axios({
        url: API_URL,
        method: "GET",
        params: params,
      })
        .then((res) => {
          context.commit("LOGIN_CHECK", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setUser(context, email) {
      const API_URL = `${REST_API}/user/${email}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SET_USER", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    checkPassword(context, params) {
      const API_URL = `${REST_API}/check/password`;
      return axios({
        url: API_URL,
        method: "GET",
        params: params,
      })
        .then((res) => {
          context.commit("CHECK_PASSWORD", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // 유튜브 검색 ==================================================
    searchYoutube1({ commit }, payload) {
      const YOUTUBE_URL = `https://www.googleapis.com/youtube/v3/search`;
      const YOUTUBE_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;

      axios({
        url: YOUTUBE_URL,
        method: "GET",
        params: {
          key: YOUTUBE_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResult: 10,
        },
      })
        .then((res) => {
          commit("SEARCH_YOUTUBE1", res.data.items);
        })
        .catch((err) => console.log(err));
    },
    searchYoutube2({ commit }, payload) {
      const YOUTUBE_URL = `https://www.googleapis.com/youtube/v3/search`;
      const YOUTUBE_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;

      axios({
        url: YOUTUBE_URL,
        method: "GET",
        params: {
          key: YOUTUBE_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResult: 10,
        },
      })
        .then((res) => {
          commit("SEARCH_YOUTUBE2", res.data.items);
        })
        .catch((err) => console.log(err));
    },
    searchYoutube3({ commit }, payload) {
      const YOUTUBE_URL = `https://www.googleapis.com/youtube/v3/search`;
      const YOUTUBE_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;

      axios({
        url: YOUTUBE_URL,
        method: "GET",
        params: {
          key: YOUTUBE_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResult: 10,
        },
      })
        .then((res) => {
          commit("SEARCH_YOUTUBE3", res.data.items);
        })
        .catch((err) => console.log(err));
    },
    searchYoutube4({ commit }, payload) {
      const YOUTUBE_URL = `https://www.googleapis.com/youtube/v3/search`;
      const YOUTUBE_KEY = process.env.VUE_APP_YOUTUBE_API_KEY;

      axios({
        url: YOUTUBE_URL,
        method: "GET",
        params: {
          key: YOUTUBE_KEY,
          part: "snippet",
          q: payload,
          type: "video",
          maxResult: 10,
        },
      })
        .then((res) => {
          commit("SEARCH_YOUTUBE4", res.data.items);
        })
        .catch((err) => console.log(err));
    },
    setSelectedDate(context, date) {
      context.commit("SET_SELECTED_DATE", date);
    },
    setRecords(context, email) {
      const API_URL = `${REST_API}/record/${email}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SET_RECORDS", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setRecordDates(context, email) {
      const API_URL = `${REST_API}/record/date=${email}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SET_RECORD_DATES", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    setDayRecords(context, params) {
      let recordList = [];
      for (let record of params.records) {
        if (record.regDate === params.date) {
          recordList.push(record);
        }
      }
      context.commit("SET_DAY_RECORDS", recordList);
    },
    createQuest(context, userSeq) {
      const API_URL = `${REST_API}/quest/${userSeq}`;
      return axios({
        url: API_URL,
        method: "POST",
      })
        .then(() => {
          context.commit();
        })
        .catch((err) => {
          console.log(err);
        });
    },
    selectQuestion(context, userSeq) {
      const API_URL = `${REST_API}/question/${userSeq}`;
      return axios({
        url: API_URL,
        method: "GET",
      })
        .then((res) => {
          context.commit("SELECT_QUESTION", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    checkAnswer(context, params) {
      const API_URL = `${REST_API}/check/findpw`;
      return axios({
        url: API_URL,
        method: "GET",
        params: params,
      })
        .then((res) => {
          context.commit("CHECK_ANSWER", res.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    updatePassword(context, params) {
      const API_URL = `${REST_API}/check/password`;
      return axios({
        url: API_URL,
        method: "PUT",
        params: params,
      })
        .then(() => {
          context.commit();
        })
        .catch((err) => {
          console.log(err);
        });
    },
    insertRecord(context, params){
      const API_URL = `${REST_API}/record`;
      return axios({
        url: API_URL,
        method: "POST",
        params: params
      })
        .then(() => {
          context.commit();
        })
        .catch((err) => {
          console.log(err);
        });
    },
    createComment(context, params){
      const API_URL = `${REST_API}/comment`;
      return axios({
        url: API_URL,
        method: "POST",
        params: params
      })
        .then(() => {
          context.commit();
        })
        .catch((err) => {
          console.log(err);
        }); 
    },
    updateComment(context, params){
      const API_URL = `${REST_API}/comment`;
      return axios({
        url: API_URL,
        method: "PUT",
        params: params
      })
        .then(() => {
          context.commit();
        })
        .catch((err) => {
          console.log(err);
        }); 
    },
    selectComment(context, params){
      const API_URL = `${REST_API}/comment`;
      return axios({
        url: API_URL,
        method: "POST",
        params: params
      })
        .then((res) => {
          context.commit("SELECT_COMMENT", res.data);
        })
        .catch((err) => {
          console.log(err);
        }); 
    },
  },
  modules: {},
});
