<template>
  <b-container>
    <h1>회원가입</h1>
    <b-row style="margin-top: 50px">
      <h2>필수 입력사항</h2>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-4 mb-3">
          <span class="input-group-text" id="basic-addon1">이 메 일</span>
          <input
            type="email"
            class="form-control"
            v-model="email"
            placeholder="E-mail"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <!-- <label for="email">이메일</label>
          <input type="email" id="email" v-model="email" class="view" /> -->
          <button @click="checkEmail" class="btn btn-dark">중복확인</button>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호</span>
          <input
            type="password"
            class="form-control"
            v-model="password"
            placeholder="password"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <!-- <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            v-model="password"
            class="view"
          /> -->
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호 확인</span>
          <input
            type="password"
            class="form-control"
            v-model="confirmPassword"
            placeholder="confirm password"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <span
            class="input-group-text"
            style="width: 35px"
            id="false"
            v-if="password === '' || confirmPassword === ''"
            >!</span
          >
          <span
            class="input-group-text"
            id="true"
            style="width: 35px"
            v-else-if="password === confirmPassword"
            >✓</span
          >
          <span class="input-group-text" style="width: 35px" id="false" v-else
            >!</span
          >
          <!-- 
        <label for="confirmPassword">비밀번호확인</label>
      <input
        type="password"
        id="confirmPassword"
        v-model="confirmPassword"
        class="view"
      /> -->

          <!-- <div
        class="msg"
        id="none"
        v-if="password === '' || confirmPassword === ''"
      />
      <div class="msg" id="true" v-else-if="password === confirmPassword">
        일치합니다.
      </div>
      <div class="msg" id="false" v-else>일치하지 않습니다.</div> -->
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-5 mb-3">
          <span class="input-group-text" id="basic-addon1">이름</span>
          <input
            type="text"
            class="form-control"
            v-model="name"
            placeholder="name"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
        </div>
        <!-- <label for="name">이름</label>
        <input type="text" id="name" v-model="name" class="view" /><br /> -->
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">성별</span>
          <div class="input-group-text" style="width: 280px">
            <input
              class="form-check-input mt-0"
              type="radio"
              id="male"
              v-model="gender"
              value="male"
              style="margin-left: 25px"
            />
            <label for="male" style="margin-left: 15px; margin-right: 70px"
              >남자</label
            >
            <input
              class="form-check-input mt-0"
              type="radio"
              id="female"
              v-model="gender"
              value="female"
            />
            <label for="female" style="margin-left: 15px">여자</label>
          </div>
        </div>
        <!-- 
              <label for="gender">성별</label>
              <div id="gender">
                <input
                  type="radio"
                  id="male"
                  v-model="gender"
                  value="male"
                  class="view"
                />
                <label for="male">남성</label>
                <input
                  type="radio"
                  id="female"
                  v-model="gender"
                  value="female"
                  class="view"
                  style="margin-left: 7px"
                />
                <label for="female">여성</label>
              </div>
              <br /> -->
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">닉네임</span>
          <input
            type="text"
            class="form-control"
            v-model="nickname"
            placeholder="nickname"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <button class="btn btn-dark" @click="checkNickname">중복확인</button>
          <!-- <label for="nickname">닉네임</label>
          <input type="text" id="nickname" v-model="nickname" class="view" /> -->
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <label class="input-group-text" for="pwFindQuestionId"
            >비밀번호 찾기 질문</label
          >
          <select
            v-model="pwFindQuestionId"
            class="form-select"
            id="pwFindQuestionId"
            style="width: 275px"
          >
            <option value="" disabled>질문을 선택하세요.</option>
            <option
              v-for="item in this.getQuestionList"
              :key="item.question"
              :value="item.id"
            >
              {{ item.question }}
            </option>
          </select>
          <!-- <label for="pwFindQuestionId">비밀번호찾기질문</label> -->
          <!-- <select v-model="pwFindQuestionId" id="pwFindQuestionId"
          style="width:275px">
          <option value="" disabled>질문을 선택하세요.</option>
          <option
            v-for="item in this.getQuestionList"
            :key="item.question"
            :value="item.id"
          >
          {{ item.question }}
          </option></select> -->
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1"
            >비밀번호 찾기 답변</span
          >
          <input
            type="text"
            class="form-control"
            v-model="pwFindAnswer"
            placeholder="answer"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <!-- <label for="pwFindAnswer">비밀번호찾기답변</label>
          <input
            type="text"
            id="pwFindAnswer"
            v-model="pwFindAnswer"
            class="view"
          /> -->
        </div>
      </b-col>
    </b-row>

    <!-- <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">이름</span>
          <input type="text" class="form-control" v-model="name" 
            placeholder="name" aria-label="Username" aria-describedby="basic-addon1">
        </div>
      </b-col>
    </b-row> -->

    <b-row style="margin-top: 50px">
      <h2>선택 입력사항</h2>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-4 mb-3">
          <span class="input-group-text" id="basic-addon1">키</span>
          <input
            type="number"
            class="form-control"
            v-model="height"
            placeholder="height"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <span class="input-group-text" style="width: 45px">cm</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">몸무게</span>
          <input
            type="number"
            class="form-control"
            v-model="weight"
            placeholder="weight"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <span class="input-group-text" style="width: 45px">kg</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">체지방률</span>
          <input
            type="number"
            class="form-control"
            v-model="bodyFat"
            placeholder="body fat"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <span class="input-group-text" style="width: 45px">%</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">골격근량</span>
          <input
            type="number"
            class="form-control"
            v-model="muscleMass"
            placeholder="muscle mass"
            aria-label="Username"
            aria-describedby="basic-addon1"
          />
          <span class="input-group-text" style="width: 45px">kg</span>
        </div>
      </b-col>
    </b-row>
    <!-- 
    <fieldset class="optional">
      
      <label for="height">키</label>
      <input type="number" id="height" v-model="height" class="view" /><br />
      <label for="weight">몸무게</label>
      <input type="number" id="weight" v-model="weight" class="view" /><br />
      <label for="bodyFat">체지방률</label>
      <input type="number" id="bodyFat" v-model="bodyFat" class="view" /><br />
      <label for="muscleMass">골격근량</label>
      <input
        type="number"
        id="muscleMass"
        v-model="muscleMass"
        class="view"
      /><br />  -->

    <b-row align-h="center">
      <b-col>
        <button
          id="button"
          class="btn btn-dark"
          @click="regist"
          style="width: 200px"
        >
          등록
        </button>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "RegistForm",
  data() {
    return {
      userSeq: 0,
      email: "",
      password: "",
      name: "",
      nickname: "",
      pwFindQuestionId: "",
      pwFindAnswer: "",
      gender: "",
      height: "",
      weight: "",
      bodyFat: "",
      muscleMass: "",
      point: 0,
      rprsnAchvmId: 0,
      confirmPassword: "",
    };
  },
  computed: {
    ...mapGetters(["getIsUnqEmail", "getIsUnqNickname", "getQuestionList"]),
  },
  methods: {
    async regist() {
      // 필수 입력사항 전부 입력하였는지 확인
      
      if (
        this.email === "" ||
        this.password === "" ||
        this.confirmPassword === "" ||
        this.name === "" ||
        this.nickname === "" ||
        this.pwFindQuestionId === "" ||
        this.pwFindAnswer === "" ||
        this.gender === ""
      ) {
        alert("필수 입력사항을 모두 작성해주세요.");
        return;
      }

      // 이메일 중복확인 완료여부 확인
      if (!this.getIsUnqEmail) {
        alert("이메일 중복확인 여부를 확인해주세요.");
        return;
      }
      await this.$store.dispatch("checkEmail", this.email);
      if (!this.getIsUnqEmail) {
        alert("이메일 중복확인 여부를 확인해주세요.");
        return;
      }

      // 비밀번호 확인 완료여부 확인
      if (this.password !== this.confirmPassword) {
        alert("비밀번호 확인을 정확히 입력하세요.");
        return;
      }

      // 닉네임 중복확인 완료여부 확인
      if (!this.getIsUnqNickname) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }
      await this.$store.dispatch("checkNickname", this.nickname);
      if (!this.getIsUnqNickname) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }
      console.log('ok')
      let user = {
        userSeq: this.userSeq,
        email: this.email,
        password: this.password,
        name: this.name,
        nickname: this.nickname,
        pwFindQuestionId: this.pwFindQuestionId,
        pwFindAnswer: this.pwFindAnswer,
        gender: this.gender,
        height: this.height,
        weight: this.weight,
        bodyFat: this.bodyFat,
        muscleMass: this.muscleMass,
        point: this.point,
        rprsnAchvmId: this.rprsnAchvmId,
      };

      await this.$store.dispatch("registUser", user);
      await this.$store.dispatch("createQuest", this.userSeq);
      this.$store.dispatch("setQuest", this.userSeq);
    },
    checkEmail() {
      // 이메일 중복 검사
      if (this.email === "") {
        alert("내용을 입력해주세요.");
        return;
      }
      this.$store
        .dispatch("checkEmail", this.email)
        .then(() => {
          if (this.getIsUnqEmail) {
            alert("사용 가능한 이메일입니다.");
            return;
          }
          alert("이미 존재하는 이메일입니다.");
        })
        .catch(() => {
          alert("오류가 발생했습니다.");
        });
    },
    checkNickname() {
      // 닉네임 중복 검사
      if (this.nickname === "") {
        alert("내용을 입력해주세요.");
        return;
      }
      this.$store
        .dispatch("checkNickname", this.nickname)
        .then(() => {
          if (this.getIsUnqNickname) {
            alert("사용 가능한 닉네임입니다.");
            return;
          }
          alert("이미 존재하는 닉네임입니다.");
        })
        .catch(() => {
          alert("오류가 발생했습니다.");
        });
    },
    getQuestionList() {
      this.$store.dispatch("questionList");
    },
  },
  created() {
    this.$store.dispatch("initIsUnq");
    this.$store.dispatch("questionList");
  },
};
</script>

<style scoped>
.container {
  margin-top: 20px;
  margin-bottom: 50px;
  padding-top: 50px;
  padding-bottom: 100px;
  background: #fee0bc;
  color: black;
  width: 900px;
  height: auto;
}
.title {
  margin-left: 160px;
  margin-bottom: 50px;
}
.text-center {
  margin-left: 100px;
  margin-right: 200px;
}
#button {
  margin-top: 50px;
  text-align: center;
}
#gender {
  display: inline;
  margin-left: 13px;
}
/* .form-control{
  width: 350px;
} */
#basic-addon1 {
  width: 145px;
}
</style>
