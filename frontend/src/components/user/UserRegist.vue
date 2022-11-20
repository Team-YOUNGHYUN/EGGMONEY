<template>
  <div class="container">
    <h1>회원가입 페이지이다.</h1>
     <h2 class="title">회원 가입</h2>
    <fieldset class="text-center">
      <label for="id">아이디</label>
      <input type="text" id="id" v-model="id" class="view" /><br />
      <label for="password">비밀번호</label>
      <input
        type="password"
        id="password"
        v-model="password"
        class="view"
      /><br />
      <label for="name">이름</label>
      <input type="text" id="name" v-model="name" class="view" /><br />
      <label for="email">이메일</label>
      <input type="email" id="email" v-model="email" class="view" /><br />
      <label for="age">나이</label>
      <input type="number" id="age" v-model="age" class="view" /><br />
      <!-- <button id="button" class="btn btn-success" @click="regist">등록</button> -->
    </fieldset>
  </div>
</template>

<script>
export default {
    name: "UserRegist",

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