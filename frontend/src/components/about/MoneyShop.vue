<template>
  <div class="eggmoney-shop">
    <h1 class="shop-title">EGGMONEY SHOP</h1>
    <b-form-group>
      <b-form-radio v-model="selected">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/05d0d32d-4762-4884-8821-248557871213/egg_pic.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T065352Z&X-Amz-Expires=86400&X-Amz-Signature=6f110cff5697290756e9bafcc000a16d2acb4a76d1f95af4f1065571dd6d074b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22egg_pic.PNG.png%22&x-id=GetObject"
          class="rounded float-start"
          alt="..."
        />
      </b-form-radio>
      <b-form-radio v-model="selected">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/05d0d32d-4762-4884-8821-248557871213/egg_pic.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T065352Z&X-Amz-Expires=86400&X-Amz-Signature=6f110cff5697290756e9bafcc000a16d2acb4a76d1f95af4f1065571dd6d074b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22egg_pic.PNG.png%22&x-id=GetObject"
          class="rounded float-start"
          alt="..."
        />
      </b-form-radio>
      <b-form-radio v-model="selected">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/05d0d32d-4762-4884-8821-248557871213/egg_pic.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T065352Z&X-Amz-Expires=86400&X-Amz-Signature=6f110cff5697290756e9bafcc000a16d2acb4a76d1f95af4f1065571dd6d074b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22egg_pic.PNG.png%22&x-id=GetObject"
          class="rounded float-start"
          alt="..."
        />
      </b-form-radio>
    </b-form-group>
  </div>
</template>

<script>
export default {
  name: "MoneyShop",
  data() {
    return {
      selected: "",
    };
  },
};
</script>

<style>
.shop-box1 {
  border: 1px solid brown;
}
.shop-box2 {
  border: 1px solid brown;
}
.shop-box3 {
  border: 1px solid brown;
}
</style>
