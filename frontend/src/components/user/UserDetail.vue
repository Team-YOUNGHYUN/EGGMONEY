<template>
  <div class="container">
    <h1>회원정보 수정 페이지이다.</h1>
    <fieldset class="required-input">
      <legend>필수 입력사항</legend>

      <label for="email">이메일</label>
      <input
        type="email"
        id="email"
        v-model="getLoginUser.email"
        class="view"
        disabled
      /><br />

      <label for="password">새 비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="getLoginUser.password"
        class="view"
      /><br />

      <label for="confirmPassword">새 비밀번호확인</label>
      <input
        type="password"
        id="confirmPassword"
        v-model="confirmPassword"
        class="view"
      />
      <div
        class="msg"
        id="none"
        v-if="getLoginUser.password === '' || confirmPassword === ''"
      />
      <div
        class="msg"
        id="true"
        v-else-if="getLoginUser.password === confirmPassword"
      >
        일치합니다.
      </div>
      <div class="msg" id="false" v-else>일치하지 않습니다.</div>
      <br />

      <label for="name">이름</label>
      <input
        type="text"
        id="name"
        v-model="getLoginUser.name"
        class="view"
        disabled
      /><br />

      <label for="nickname">닉네임</label>
      <input
        type="text"
        id="nickname"
        v-model="getLoginUser.nickname"
        class="view"
      />
      <button @click="checkNickname">중복확인</button><br />

      <label for="pwFindQuestionId">비밀번호찾기질문</label>
      <select v-model="getLoginUser.pwFindQuestionId" id="pwFindQuestionId">
        <option
          v-for="item in getQuestionList"
          :key="item.question"
          :value="item.id"
        >
          {{ item.question }}
        </option></select
      ><br />
      <label for="pwFindAnswer">비밀번호찾기답변</label>
      <input
        type="text"
        id="pwFindAnswer"
        v-model="getLoginUser.pwFindAnswer"
        value="pwFindAnswer"
        class="view"
      /><br />

      <label for="gender">성별</label>
      <div id="gender" v-if="(getLoginUser.gender = 'male')">
        <input
          type="radio"
          id="male"
          value="male"
          class="view"
          disabled
          checked
        />
        <label for="male">남성</label>
        <input
          type="radio"
          id="female"
          value="female"
          class="view"
          style="margin-left: 7px"
          disabled
        />
        <label for="female">여성</label>
      </div>
      <div id="gender" v-else>
        <input type="radio" id="male" value="male" class="view" disabled />
        <label for="male">남성</label>
        <input
          type="radio"
          id="female"
          value="female"
          class="view"
          style="margin-left: 7px"
          disabled
          checked
        />
        <label for="female">여성</label>
      </div>
      <br />
    </fieldset>
    <br />
    <fieldset class="optional">
      <legend>선택 입력사항</legend>
      <label for="height">키</label>
      <input
        type="number"
        id="height"
        v-model="getLoginUser.height"
        class="view"
      /><br />
      <label for="weight">몸무게</label>
      <input
        type="number"
        id="weight"
        v-model="getLoginUser.weight"
        class="view"
      /><br />
      <label for="bodyFat">체지방률</label>
      <input
        type="number"
        id="bodyFat"
        v-model="getLoginUser.bodyFat"
        class="view"
      /><br />
      <label for="muscleMass">골격근량</label>
      <input
        type="number"
        id="muscleMass"
        v-model="getLoginUser.muscleMass"
        class="view"
      /><br />
      <button id="button" class="btn btn-success" @click="updateUser">
        등록
      </button>
    </fieldset>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  name: "UserDetail",
  data() {
    return {
      confirmPassword: "",
      originalNickname: "",
    };
  },
  computed: {
    ...mapGetters(["getLoginUser", "getIsUnqNickname", "getQuestionList"]),
  },
  methods: {
    async updateUser() {
      // 필수 입력사항 전부 입력하였는지 확인
      if (
        this.getLoginUser.password === "" ||
        this.confirmPassword === "" ||
        this.getLoginUser.nickname === "" ||
        this.getLoginUser.pwFindQuestionId === "" ||
        this.getLoginUser.pwFindAnswer === ""
      ) {
        alert("필수 입력사항을 모두 작성해주세요.");
        return;
      }

      // 비밀번호 확인 완료여부 확인
      if (this.getLoginUser.password !== this.confirmPassword) {
        alert("비밀번호 확인을 정확히 입력하세요.");
        return;
      }

      // 닉네임 중복확인 완료여부 확인
      // 값이 true || 원래 닉이랑 같은 경우만 통과
      if (
        !this.getIsUnqNickname &&
        this.originalNickname !== this.getLoginUser.nickname
      ) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }
      await this.$store.dispatch("checkNickname", this.getLoginUser.nickname);
      if (
        !this.getIsUnqNickname &&
        this.originalNickname !== this.getLoginUser.nickname
      ) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }

      let user = {
        userSeq: this.getLoginUser.userSeq,
        email: this.getLoginUser.email,
        password: this.getLoginUser.password,
        name: this.getLoginUser.name,
        nickname: this.getLoginUser.nickname,
        pwFindQuestionId: this.getLoginUser.pwFindQuestionId,
        pwFindAnswer: this.getLoginUser.pwFindAnswer,
        gender: this.getLoginUser.gender,
        height: this.getLoginUser.height,
        weight: this.getLoginUser.weight,
        bodyFat: this.getLoginUser.bodyFat,
        muscleMass: this.getLoginUser.muscleMass,
        point: this.getLoginUser.point,
        rprsnAchvmId: this.getLoginUser.rprsnAchvmId,
      };
      await this.$store.dispatch("updateUser", user).then(() => {
        this.$store.dispatch("getUserInfo", this.getLoginUser.userSeq);
      });
    },
    checkNickname() {
      // 닉네임 중복 검사
      if (this.getLoginUser.nickname === "") {
        alert("내용을 입력해주세요.");
        return;
      }
      if (this.getLoginUser.nickname === this.originalNickname) {
        alert("현재 닉네임입니다.");
        return;
      }
      this.$store
        .dispatch("checkNickname", this.getLoginUser.nickname)
        .then(() => {
          if (this.getIsUnqNickname) {
            alert("사용 가능한 닉네임입니다.");
          }
        })
        .catch(() => {
          alert("이미 존재하는 닉네임입니다.");
        });
    },
  },
  created() {
    this.$store.dispatch("questionList");
    // 아래 기능은 실제로는 메인페이지 created에 구현될 것이다.
    this.$store.dispatch("getUserInfo", 11).then(() => {
      this.originalNickname = this.getLoginUser.nickname;
    });
  },
};
</script>

<style scoped>
.container {
  margin-top: 70px;
  padding-top: 100px;
  padding-left: 100px;
  padding-right: 100px;
  padding-bottom: 100px;
  background: gray;
  color: white;
}
.title {
  margin-left: 160px;
  margin-bottom: 50px;
}
.requ {
  margin-left: 100px;
  margin-right: 200px;
}
#button {
  margin-top: 50px;
  text-align: center;
}
.msg {
  display: inline;
  margin-left: 6px;
}
#true {
  color: palegreen;
}
#false {
  color: crimson;
}
#gender {
  display: inline;
  margin-left: 13px;
}
</style>
