<template>
  <div>
    <h1>router: 여기부터 FindpwForm 영역이다!</h1>
    <h2>이메일과 질문의 답변을 올바르게 입력하면 비밀번호를 수정할 수 있습니다.</h2>
    <label for="emailForm">이메일</label>
    <input type="text" id="emailForm" v-model="email" @keyup.enter="checkEmail"/>
    <b-button @click="checkEmail">확인</b-button><br/>

    <div v-if="this.getQuestion">
        비밀번호 찾기 질문: {{this.getQuestion.question}}<br/>
        <label for="answerForm">답: </label>
        <input type="text" id="answerForm" v-model="answer" @keyup.enter="checkAnswer"/>
        <b-button @click="checkAnswer">확인</b-button><br/>
    
        <div v-if="this.modifyPw">
            <label for="password">새 비밀번호: </label>
            <input type="password" id="password" v-model="password"/>
            
            <div class="msg" id="none" v-if="password === '' || confirmPassword === ''"/>
            <div class="msg" id="true" v-else-if="password === confirmPassword">
                일치합니다.
            </div>
            <div class="msg" id="false" v-else>일치하지 않습니다.</div>
            <br />

            <label for="confirmPassword">새 비밀번호 확인: </label>
            <input type="password" id="confirmPassword" v-model="confirmPassword"/>

            <b-button v-if="password!=='' && confirmPassword!=='' && password===confirmPassword"
            @click="updatePassword">
            비밀번호 변경</b-button>
            <b-button v-else disabled>비밀번호 변경</b-button>
        </div>
        

    </div>


  </div>
</template>

<script>
import {mapGetters} from "vuex";
import router from '@/router';
export default {
    name: "FindpwForm",
    data(){
        return{
            email: "",
            answer: "",
            modifyPw: "",
            password: "",
            confirmPassword: "",
        }
    },
    computed:{
        ...mapGetters(["getIsUnqEmail","getUser", "getQuestion", "getCheckPassword", "getCheckAnswer"])
    },
    methods:{
        async checkEmail(){
            await this.$store.dispatch("checkEmail", this.email);
            if(this.getIsUnqEmail){
                alert('존재하지 않는 이메일입니다!');
                return;
            }
            await this.$store.dispatch("setUser", this.email);
            this.$store.dispatch("selectQuestion", this.getUser.userSeq);
        },
        async checkAnswer(){
            let params = {
                email: this.getUser.email,
                pwFindAnswer: this.answer
            }
            await this.$store.dispatch("checkAnswer", params);
            if(!this.getCheckAnswer){
                alert('비밀번호 찾기 답변이 틀렸습니다!');
                return;
            }
            this.modifyPw = true;
        },
        async updatePassword(){
            let params = {
                email: this.getUser.email,
                password: this.password
            }
            await this.$store.dispatch("updatePassword", params);
            alert("비밀번호가 정상적으로 변경되었습니다.");
            router.push('/login');
        }
    },
    created(){
        this.$store.state.question = null;
    }
}
</script>

<style>

</style>