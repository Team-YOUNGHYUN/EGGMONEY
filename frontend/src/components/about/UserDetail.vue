<template>
  <b-container>
    <h1>회원정보 수정</h1>
    <b-row  style="margin-top: 50px">
      <h2>나의 회원 정보</h2>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-4 mb-3">
          <span class="input-group-text" id="basic-addon1">이 메 일</span>
          <input type="email" class="form-control" v-model="getUser.email" disabled
            placeholder="E-mail" aria-label="Username" aria-describedby="basic-addon1">
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호</span>
          <input type="password" class="form-control" v-model="password"
            placeholder="password" aria-label="Username" aria-describedby="basic-addon1">
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">비밀번호 확인</span>
          <input type="password" class="form-control" v-model="confirmPassword" 
            placeholder="confirm password" aria-label="Username" aria-describedby="basic-addon1">
          <span class="input-group-text" style="width: 35px" id="false" v-if="password === '' || confirmPassword === ''">!</span> 
          <span class="input-group-text" id="true" style="width: 35px" 
            v-else-if="password === confirmPassword">✓</span> 
          <span class="input-group-text" style="width: 35px" id="false" v-else>!</span> 
        </div>
      </b-col>
    </b-row>

      <!-- <label for="password">새 비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="getUser.password"
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
        v-if="getUser.password === '' || confirmPassword === ''"
      />
      <div
        class="msg"
        id="true"
        v-else-if="getUser.password === confirmPassword"
      >
        일치합니다.
      </div>
      <div class="msg" id="false" v-else>일치하지 않습니다.</div>
      <br /> -->


    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-5 mb-3">
          <span class="input-group-text" id="basic-addon1">이름</span>
          <input type="text" class="form-control" v-model="getUser.name" disabled
            placeholder="name" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        <!-- <label for="name">이름</label>
        <input type="text" id="name" v-model="name" class="view" /><br /> -->
      </b-col>
    </b-row>


    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">성별</span>
          <div class="input-group-text" style="width: 280px" v-if="getUser.gender===male">
             <input class="form-check-input mt-0" type="radio"
                id="male" v-model="getUser.gender" value="male" checked disabled
                style="margin-left:25px"/>
             <label for="male" style="margin-left:15px; margin-right:70px">남자</label>
             <input class="form-check-input mt-0" type="radio"
                id="female" v-model="getUser.gender" value="female" disabled/>
             <label for="female" style="margin-left:15px">여자</label>
          </div>
          <div class="input-group-text" style="width: 280px" v-else>
             <input class="form-check-input mt-0" type="radio"
                id="male" v-model="getUser.gender" value="male" disabled
                style="margin-left:25px"/>
             <label for="male" style="margin-left:15px; margin-right:70px">남자</label>
             <input class="form-check-input mt-0" type="radio"
                id="female" v-model="getUser.gender" value="female" checked disabled/>
             <label for="female" style="margin-left:15px">여자</label>
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
          <input type="text" class="form-control" v-model="getUser.nickname" 
            placeholder="nickname" aria-label="Username" aria-describedby="basic-addon1">
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
          >비밀번호 찾기 질문</label>
          <select v-model="getUser.pwFindQuestionId" class="form-select"
          id="pwFindQuestionId" style="width:275px">
            <option value="" disabled>질문을 선택하세요.</option>
            <option v-for="item in this.getQuestionList" 
              :key="item.question" :value="item.id">
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
            >비밀번호 찾기 답변</span>
          <input type="text" class="form-control" v-model="getUser.pwFindAnswer" 
            placeholder="answer" aria-label="Username" aria-describedby="basic-addon1">
        </div>
      </b-col>
    </b-row>

    <b-row style="margin-top: 50px">
      <h2>나의 신체 정보</h2>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mt-4 mb-3">
          <span class="input-group-text" id="basic-addon1">키</span>
          <input type="number" class="form-control" v-model="getUser.height" 
            placeholder="height" aria-label="Username" aria-describedby="basic-addon1">
          <span class="input-group-text" style="width: 45px">cm</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">몸무게</span>
          <input type="number" class="form-control" v-model="getUser.weight" 
            placeholder="weight" aria-label="Username" aria-describedby="basic-addon1">
          <span class="input-group-text" style="width: 45px">kg</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">체지방률</span>
          <input type="number" class="form-control" v-model="getUser.bodyFat" 
            placeholder="body fat" aria-label="Username" aria-describedby="basic-addon1">
          <span class="input-group-text" style="width: 45px">%</span>
        </div>
      </b-col>
    </b-row>

    <b-row align-h="center">
      <b-col cols="6">
        <div class="input-group mb-3">
          <span class="input-group-text" id="basic-addon1">골격근량</span>
          <input type="number" class="form-control" v-model="getUser.muscleMass" 
            placeholder="muscle mass" aria-label="Username" aria-describedby="basic-addon1">
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
          <button id="button" class="btn btn-dark" @click="updateUser" style="width: 200px"
            v-if="!password || !confirmPassword || password !== confirmPassword ||
            !getUser.nickname || (!getIsUnqNickname &&  originalNickname!==getUser.nickname)"
            disabled>수정</button>
            <button id="button" class="btn btn-dark" @click="updateUser" style="width: 200px"
            v-else>수정</button>
            <!-- <button @click="test">confirm</button> -->
        </b-col>
        
      </b-row>

  </b-container>
  <!-- <div class="container">
    <h1>router: 여기부터 UserDetail 영역이다!</h1>
    <h1>회원정보 수정 페이지이다.</h1>
    <fieldset class="required-input">
      <legend>필수 입력사항</legend>

      <label for="email">이메일</label>
      <input
        type="email"
        id="email"
        v-model="getUser.email"
        class="view"
        disabled
      /><br />

      <label for="password">새 비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="getUser.password"
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
        v-if="getUser.password === '' || confirmPassword === ''"
      />
      <div
        class="msg"
        id="true"
        v-else-if="getUser.password === confirmPassword"
      >
        일치합니다.
      </div>
      <div class="msg" id="false" v-else>일치하지 않습니다.</div>
      <br />

      <label for="name">이름</label>
      <input
        type="text"
        id="name"
        v-model="getUser.name"
        class="view"
        disabled
      /><br />

      <label for="nickname">닉네임</label>
      <input
        type="text"
        id="nickname"
        v-model="getUser.nickname"
        class="view"
      />
      <button @click="checkNickname">중복확인</button><br />

      <label for="pwFindQuestionId">비밀번호찾기질문</label>
      <select v-model="pwFindQuestionId" id="pwFindQuestionId">
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
        v-if="pwFindQuestionId !== this.getUser.pwFindQuestionId"
        type="text"
        id="pwFindAnswer"
        v-model="getUser.pwFindAnswer"
        value="pwFindAnswer"
        class="view"
      />
      <input v-else type="text" disabled />
      <br />

      <label for="gender">성별</label>
      <div id="gender" v-if="(getUser.gender = 'male')">
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
        v-model="getUser.height"
        class="view"
      /><br />
      <label for="weight">몸무게</label>
      <input
        type="number"
        id="weight"
        v-model="getUser.weight"
        class="view"
      /><br />
      <label for="bodyFat">체지방률</label>
      <input
        type="number"
        id="bodyFat"
        v-model="getUser.bodyFat"
        class="view"
      /><br />
      <label for="muscleMass">골격근량</label>
      <input
        type="number"
        id="muscleMass"
        v-model="getUser.muscleMass"
        class="view"
      /><br />
      <button id="button" class="btn btn-success" @click="updateUser">
        등록
      </button>
    </fieldset>
  </div> -->
</template>

<script>
import { mapGetters } from "vuex";
import router from '@/router';
export default {
  name: "UserDetail",
  data() {
    return {
      password: "",
      confirmPassword: "",
      originalNickname: "",
      pwFindQuestionId: "",
    };
  },
  computed: {
    ...mapGetters(["getUser", "getIsUnqNickname", "getQuestionList"]),
  },
  methods: {
    test(){
      // console.log(!this.password);
      // console.log(!this.confirmPassword);
      // console.log(this.password !== this.confirmPassword);
      // console.log(!this.getUser.nickname);
      // console.log(!this.getIsUnqNickname);
      console.log(this.originalNickname)
      console.log(this.getUser.nickname)
      console.log(this.originalNickname!==this.getUser.nickname);
      console.log(!this.password || !this.confirmPassword || this.password !== this.confirmPassword ||
            !this.getUser.nickname || (!this.getIsUnqNickname &&  this.originalNickname!==this.getUser.nickname))
    },
    async updateUser() {
      // 필수 입력사항 전부 입력하였는지 확인
      if (
        this.password === "" ||
        this.confirmPassword === "" ||
        this.getUser.nickname === ""
      ) {
        alert("필수 입력사항을 모두 작성해주세요.");
        return;
      }

      // 비밀번호 확인 완료여부 확인
      if (this.password !== this.confirmPassword) {
        alert("비밀번호 확인을 정확히 입력하세요.");
        return;
      }

      // 닉네임 중복확인 완료여부 확인
      // 값이 true || 원래 닉이랑 같은 경우만 통과
      if (
        !this.getIsUnqNickname &&
        this.originalNickname !== this.getUser.nickname
      ) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }
      await this.$store.dispatch("checkNickname", this.getUser.nickname);
      if (
        !this.getIsUnqNickname &&
        this.originalNickname !== this.getUser.nickname
      ) {
        alert("닉네임 중복확인 여부를 확인해주세요.");
        return;
      }

      let user = {
        userSeq: this.getUser.userSeq,
        email: this.getUser.email,
        password: this.password,
        name: this.getUser.name,
        nickname: this.getUser.nickname,
        pwFindQuestionId: this.getUser.pwFindQuestionId,
        pwFindAnswer: this.getUser.pwFindAnswer,
        gender: this.getUser.gender,
        height: this.getUser.height,
        weight: this.getUser.weight,
        bodyFat: this.getUser.bodyFat,
        muscleMass: this.getUser.muscleMass,
        point: this.getUser.point,
        rprsnAchvmId: this.getUser.rprsnAchvmId,
      };
      await this.$store.dispatch("updateUser", user);
      await this.$store.dispatch("setUser");
      await JSON.stringify(window.sessionStorage.setItem(this.getUser));
      router.push("/");
    },
    checkNickname() {
      // 닉네임 중복 검사
      if (this.getUser.nickname === "") {
        alert("내용을 입력해주세요.");
        return;
      }
      if (this.getUser.nickname === this.originalNickname) {
        alert("현재 닉네임입니다.");
        return;
      }
      this.$store
        .dispatch("checkNickname", this.getUser.nickname)
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
  },
  created() {
    this.$store.dispatch("questionList");
    this.originalNickname = this.getUser.nickname;
    this.pwFindQuestionId = this.getUser.pwFindQuestionId;
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
#basic-addon1{
  width: 145px;
}
</style>
