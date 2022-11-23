<template>
  <div class="eggmoney-shop">
    <h1 class="shop-title">EGGMONEY SHOP</h1>
    <div class="shop-items">
      <!-- 아이템1 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/14e7861b-ee43-4215-83fa-08002bc08c02/%EB%B0%98%EC%88%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074810Z&X-Amz-Expires=86400&X-Amz-Signature=5167d0532d44fb04d5af18e82e0b38174011bdb0752ac452c17234bdaff9bbe9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EB%25B0%2598%25EC%2588%2599%25EB%259E%2580.png%22&x-id=GetObject"
          alt="반숙란"
        />
        <br />
        <p class="point">3,200 point</p>
        <input type="radio" name="buy" id="item1" value="item1" checked />
      </div>
      <!-- 아이템2 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/395a3f9e-d719-4024-a59f-b4300b34fb08/%EA%B5%AC%EC%9A%B4%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074832Z&X-Amz-Expires=86400&X-Amz-Signature=e3048abcdc800aede983a5179678203cf2d5e113685438634426f75caeb85783&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B5%25AC%25EC%259A%25B4%25EB%259E%2580.png%22&x-id=GetObject"
          alt="구운란"
        />
        <br />
        <p class="point">2,800 point</p>
        <input type="radio" name="buy" id="item2" value="item2" />
      </div>
      <!-- 아이템3 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f830884a-f71d-4a23-b329-75cc67cf21f5/%EA%B0%90%EB%8F%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074904Z&X-Amz-Expires=86400&X-Amz-Signature=37c052aabc6b006a337146742ef290a94d6efa083c5286b329de6a716176c399&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B0%2590%25EB%258F%2599%25EB%259E%2580.png%22&x-id=GetObject"
          alt="감동란"
        />
        <br />
        <p class="point">1,200 point</p>
        <input type="radio" name="buy" id="item3" value="item3" />
      </div>
    </div>
    <b-button variant="warning" @click="popItem">Buy</b-button>
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
  methods: {
    popItem() {},
  },
};
</script>

<style>
.eggmoney-shop {
  background-color: darksalmon;
}

.shop-items {
  justify-content: space-around;
  margin: 20px 100px;
  display: flex;
}

.item {
  background-color: bisque;
  border: 1px solid brown;
}

.point {
  font-weight: bold;
}
</style>
