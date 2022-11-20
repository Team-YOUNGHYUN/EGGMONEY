<template>
  <div class="container">
    <h1>회원가입 페이지이다.</h1>
     <h2 class="title">회원 가입</h2>
    <fieldset class="text-center">
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" class="view" />
      <button>중복확인</button><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" class="view" /><br />
      <label for="nickname">닉네임</label>
      <input type="nickname" id="nickname" v-model="nickname" class="view" /><br />
      <label for="pwFindQuestionId">비밀번호찾기질문</label>
      <input type="pwFindQuestionId" id="pwFindQuestionId" v-model="pwFindQuestionId" class="view" /><br />
      <label for="pwFindAnswer">비밀번호찾기답변</label>
      <input type="pwFindAnswer" id="pwFindAnswer" v-model="pwFindAnswer" class="view" /><br />
      <label for="gender">성별</label>
      <input type="gender" id="gender" v-model="gender" class="view" /><br />
      <label for="height">키</label>
      <input type="height" id="height" v-model="height" class="view" /><br />
      <label for="weight">몸무게</label>
      <input type="weight" id="weight" v-model="weight" class="view" /><br />
      <label for="bodyFat">체지방률</label>
      <input type="bodyFat" id="bodyFat" v-model="bodyFat" class="view" /><br />
      <label for="muscleMass">골격근량</label>
      <input type="muscleMass" id="muscleMass" v-model="muscleMass" class="view" /><br />
      <button id="button" class="btn btn-success" @click="regist">등록</button>
    </fieldset>
  </div>
</template>

<script>
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
        }
    },
    methods:{
        regist(){
            if(
                this.email === "" ||
                this.password === "" ||
                this.name === "" ||
                this.nickname === "" ||
                this.pwFindQuestionId === "" ||
                this.pwFindAnswer === "" ||
                this.gender === ""
            ) {
                alert("필수 입력사항을 모두 작성해주세요.");
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
        }
    }
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
</style>