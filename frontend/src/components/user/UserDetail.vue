<template>
  <div class="container">
    <h1>회원정보 수정 페이지이다.</h1>
    <fieldset class="required-input">
      <legend>필수 입력사항</legend>

      <label for="email">이메일</label>
      <input type="email" id="email" v-model="getLoginUser.email" class="view" disabled/><br/>
      
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
      <input type="text" id="name" v-model="getLoginUser.name" class="view" disabled/><br />

      <label for="nickname">닉네임</label>
      <input type="text" id="nickname" v-model="getLoginUser.nickname" class="view" />
      <button @click="checkNickname">중복확인</button><br />

      <label for="pwFindQuestionId">비밀번호찾기질문</label>
      <select v-model="getLoginUser.pwFindQuestionId" id="pwFindQuestionId">
      <option value="" disabled>질문을 선택하세요.</option>
      <option
        v-for="item in this.getQuestionList"
        :key="item.question"
        :value="item.id"
        >{{ item.question }}
      </option>
      </select><br/>
      <label for="pwFindAnswer">비밀번호찾기답변</label>
      <input type="text" id="pwFindAnswer" v-model="getLoginUser.pwFindAnswer" value="pwFindAnswer" class="view" /><br />

      <label for="gender">성별</label>
      <div id="gender" v-if="getLoginUser.gender='male'">
        <input type="radio" checked disabled>
        <label for="male">남성</label>
        <input type="radio" id="female" v-model="gender" value="female" class="view"  style="margin-left: 7px"/>
        <label for="female">여성</label>
      </div>
      <div id="gender" v-else>
        <input type="radio" id="male" v-model="gender" value="male" class="view"/>
        <label for="male">남성</label>
        <input type="radio" id="female" v-model="gender" value="female" class="view"  checked style="margin-left: 7px"/>
        <label for="female">여성</label>
      </div>
      <br />
    </fieldset>
    <br/>
    <fieldset class="optional">
      <legend>선택 입력사항</legend>
      <label for="height">키</label>
      <input type="number" id="height" v-model="height" class="view" /><br />
      <label for="weight">몸무게</label>
      <input type="number" id="weight" v-model="weight" class="view" /><br />
      <label for="bodyFat">체지방률</label>
      <input type="number" id="bodyFat" v-model="bodyFat" class="view" /><br />
      <label for="muscleMass">골격근량</label>
      <input type="number" id="muscleMass" v-model="muscleMass" class="view" /><br />
      <!-- <button id="button" class="btn btn-success" @click="regist">등록</button> -->
      <button @click="test">dd</button>
    </fieldset>
  </div>
</template>

<script>
import { mapGetters } from "vuex"
export default {
    name: "UserDetail",
    data() {
        return {
            userSeq: "",
            email: "aaa",
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
            confirmPassword: "",
        }
    },
    computed:{
     ...mapGetters(["getLoginUser", "getQuestionList"]),
    },
    methods:{
        test(){
            console.log(this.getLoginUser.name);
            
        },
        setUser(){
            let user = this.getLoginUser;

            this.userSeq= user.userSeq,
            this.email = user.email,
            this.name = user.name,
            this.nickname = user.nickname,
            this.pwFindQuestionId = user.pwFindQuestionId,
            this.pwFindAnswer = user.pwFindAnswer,
            this.gender = user.gender,
            this.height = user.height,
            this.weight = user.weight,
            this.bodyFat = user.bodyFat,
            this.muscleMass = user.muscleMass
        },
        checkNickname(){
            // 닉네임 중복 검사
            if(this.nickname === ""){
                alert("내용을 입력해주세요.");
                return;
            }
            this.$store.dispatch("checkNickname", this.nickname);
        },
    },
    created(){
        // 아래 기능은 실제로는 메인페이지 created에 구현될 것이다.
        this.$store.dispatch("getUserInfo", 11);
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
  .requ{
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