<template>
  <div class="container">
    <h1>회원가입 페이지이다.</h1>
     <h2 class="title">회원 가입</h2>
    <fieldset class="text-center">

      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" class="view" />
      <button @click="checkEmail">중복확인</button><br />
      
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />

      <label for="confirmPassword">비밀번호확인</label>
      <input
        type="password"
        id="confirmPassword"
        v-model="confirmPassword"
        class="view"
      />
      <div class="msg" id="none" v-if="password === '' || confirmPassword === ''"/> 
      <div class="msg" id="true" v-else-if="password === confirmPassword">일치합니다.</div>
      <div class="msg" id="false" v-else>일치하지 않습니다.</div>
      <br />

      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" class="view" /><br />

      <label for="nickname">닉네임</label>
      <input type="text" id="nickname" v-model="nickname" class="view" />
      <button @click="checkNickname">중복확인</button><br />

      <label for="pwFindQuestionId">비밀번호찾기질문</label>
      <select v-model="pwFindQuestionId" id="pwFindQuestionId">
      <option value="" disabled>질문을 선택하세요.</option>
      <option
        v-for="item in this.getQuestionList"
        :key="item.question"
        :value="item.id"
        >{{ item.question }}
      </option>
      </select><br/>
      <label for="pwFindAnswer">비밀번호찾기답변</label>
      <input type="text" id="pwFindAnswer" v-model="pwFindAnswer" class="view" /><br />

      <label for="gender">성별</label>
      <div id="gender">
        <input type="radio" id="male" v-model="gender" value="male" class="view" />
        <label for="male">남성</label>
        <input type="radio" id="female" v-model="gender" value="female" class="view"  style="margin-left: 7px"/>
        <label for="female">여성</label>
      </div>
      <br />

      <br />
      <label for="height">키</label>
      <input type="number" id="height" v-model="height" class="view" /><br />
      <label for="weight">몸무게</label>
      <input type="number" id="weight" v-model="weight" class="view" /><br />
      <label for="bodyFat">체지방률</label>
      <input type="number" id="bodyFat" v-model="bodyFat" class="view" /><br />
      <label for="muscleMass">골격근량</label>
      <input type="number" id="muscleMass" v-model="muscleMass" class="view" /><br />
      <button id="button" class="btn btn-success" @click="regist">등록</button>
    </fieldset>
  </div>
</template>

<script>
import { mapGetters } from "vuex"
export default {
    name: "UserRegist",
    data(){
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
  
        }
    },
    computed:{
        ...mapGetters(["getIsUnqEmail", "getIsUnqNickname", "getQuestionList"]),
    },
    methods:{
        regist(){
            // 필수 입력사항 전부 입력하였는지 확인
            if(
                this.email === "" ||
                this.password === "" ||
                this.confirmPassword === "" ||
                this.name === "" ||
                this.nickname.length === "" ||
                this.pwFindQuestionId === "" ||
                this.pwFindAnswer === "" ||
                this.gender === ""
            ) {
                alert("필수 입력사항을 모두 작성해주세요.");
                return;
            }

            // 이메일 중복확인 완료여부 확인
            if(!this.getIsUnqEmail) {
                alert("이메일 중복확인 여부를 확인해주세요.");
                return;
            }

            // 비밀번호 확인 완료여부 확인
            if(this.password !== this.confirmPassword) {
                alert("비밀번호 확인을 정확히 입력하세요.");
                return;
            }

            // 닉네임 중복확인 완료여부 확인
            if(!this.getIsUnqNickname) {
                alert("닉네임 중복확인 여부를 확인해주세요.");
                return;
            }

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
                rprsnAchvmId: this.rprsnAchvmId
            };

            this.$store.dispatch("registUser", user);
        },
        checkEmail(){
            // 이메일 중복 검사
            if(this.email === ""){
                alert("내용을 입력해주세요.");
                return;
            }
            this.$store.dispatch("checkEmail", this.email);
            
        },
        checkNickname(){
            // 닉네임 중복 검사
            if(this.nickname === ""){
                alert("내용을 입력해주세요.");
                return;
            }
            this.$store.dispatch("checkNickname", this.nickname);
        },
        getQuestionList(){
            this.$store.dispatch("questionList");
        }
    },
    created(){
        this.$store.dispatch("initIsUnq");
        this.$store.dispatch("questionList");
    },
}
</script>

<style scoped>
   .container{
    margin-top: 70px;
    padding-top: 100px;
    padding-left: 100px;
    padding-right: 100px;
    padding-bottom: 100px;
    background: gray;
    color: white;
  }
  .title{
    margin-left: 160px;
    margin-bottom: 50px;
  }
  .text-center{
    margin-left: 100px;
    margin-right: 200px;
  }
  #button{
    margin-top: 50px;
    text-align: center;
  }
  .msg{
    display: inline;
    margin-left: 6px;
  }
  #true{
    color: palegreen;
  }
  #false{
    color: crimson;
  }
  #gender{
    display: inline;
    margin-left: 13px;
  }
</style>