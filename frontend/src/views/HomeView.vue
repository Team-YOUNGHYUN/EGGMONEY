<template>
  <div class="home">
    <img
      alt="Vue logo"
      src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/05d0d32d-4762-4884-8821-248557871213/egg_pic.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221121%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221121T061549Z&X-Amz-Expires=86400&X-Amz-Signature=a983cc6c5fae56f111ff3b1302d902adc68d56e4e590cae0108f644a49f40cae&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22egg_pic.PNG.png%22&x-id=GetObject"
    />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
// import LoginForm from '@/components/LoginForm.vue'
// import UserRegist from '@/components/user/UserRegist.vue'

export default {
  name: "HomeView",
  components: {
    HelloWorld,
  },
};
</script>
