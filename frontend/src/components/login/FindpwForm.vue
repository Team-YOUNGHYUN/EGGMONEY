<template>
  <b-container>
    <b-row>
        <h1>비밀번호 찾기</h1>
    </b-row>
    <b-row align-h="center">
        <b-col cols="5">
            <div class="input-group mt-4 mb-3">
                <span class="input-group-text" id="basic-addon1">이 메 일</span>
                <input type="email" class="form-control" v-model="email" @keyup.enter="checkEmail"
                    placeholder="E-mail" aria-label="Username" aria-describedby="basic-addon1" v-if="!this.getQuestion">
                <input type="email" class="form-control" v-model="email" @keyup.enter="checkEmail"
                placeholder="E-mail" aria-label="Username" aria-describedby="basic-addon1" v-else disabled>
            </div>
        </b-col>
    </b-row>

    <b-row>
        <b-col>
            <b-button v-if="!this.email" class="btn btn-dark" style="width: 350px" disabled>확인</b-button>
            <b-button v-else-if="!this.getQuestion" class="btn btn-dark" @click="checkEmail" style="width: 350px">확인</b-button>
            <b-button v-else class="btn btn-dark" @click="deleteQuestion" style="width: 350px">이메일 다시 입력</b-button>
        </b-col>
    </b-row>
    
    <div v-if="this.getQuestion">
        <b-row align-h="center">
            <b-col cols="5">
                <div class="input-group mt-5 mb-1">
                <span class="input-group-text" id="basic-addon1">비밀번호 찾기 질문</span>
                    <input type="text" class="form-control" v-model="getQuestion.question"
                        aria-label="Username" aria-describedby="basic-addon1" disabled>
                </div>
            </b-col>
        </b-row>

        <b-row align-h="center">
            <b-col cols="5">
                <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">비밀번호 찾기 답변</span>
                    <input type="text" class="form-control" v-model="answer" @keyup.enter="checkAnswer"
                        aria-label="Username" aria-describedby="basic-addon1">
                </div>
            </b-col>
        </b-row>
        <!-- <label for="answerForm">답: </label>
        <input type="text" id="answerForm" v-model="answer" @keyup.enter="checkAnswer"/>
        <b-button @click="checkAnswer">확인</b-button><br/> -->

        <b-row>
            <b-col>
                <b-button v-if="!anwser" class="btn btn-dark" @click="checkAnswer" style="width: 350px">확인</b-button>
                <b-button v-else class="btn btn-dark" @click="checkAnswer" style="width: 350px" disabled>확인</b-button>
            </b-col>
        </b-row>
        
        
    
        <div v-if="this.modifyPw">
            <b-row align-h="center">
                <b-col cols="5">
                    <div class="input-group mt-5 mb-1">
                    <span class="input-group-text" id="basic-addon1">새 비밀번호</span>
                    <input type="password" class="form-control" v-model="password"
                        placeholder="password" aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                </b-col>
            </b-row>

            <b-row align-h="center">
                <b-col cols="5">
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
<!--             
            <label for="password">새 비밀번호: </label>
            <input type="password" id="password" v-model="password"/>
            
            <div class="msg" id="none" v-if="password === '' || confirmPassword === ''"/>
            <div class="msg" id="true" v-else-if="password === confirmPassword">
                일치합니다.
            </div>
            <div class="msg" id="false" v-else>일치하지 않습니다.</div>
            <br />

            <label for="confirmPassword">새 비밀번호 확인: </label>
            <input type="password" id="confirmPassword" v-model="confirmPassword"/> -->

            <b-row>
                <b-col>
                    <b-button v-if="password!=='' && confirmPassword!=='' && password===confirmPassword" 
                        class="btn btn-dark" style="width: 350px" @click="updatePassword">비밀번호 변경</b-button>
                    <b-button v-else class="btn btn-dark" style="width: 350px" disabled>비밀번호 변경</b-button>
                </b-col>
            </b-row>
            
        </div>
    </div>


  </b-container>
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
                alert('존재하지 않는 이메일입니다.');
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
                alert('비밀번호 찾기 답변이 틀렸습니다.');
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
        },
        deleteQuestion(){
            this.$store.commit("INIT_QUESTION");
            this.email = "",
            this.answer = "",
            this.modifyPw = "",
            this.password = "",
            this.confirmPassword = ""
        }
    },
    created(){
        this.$store.state.question = null;
    }
}
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
#basic-addon1{
  width: 145px;
}
</style>