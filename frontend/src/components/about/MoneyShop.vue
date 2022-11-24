<template>
  <div class="eggmoney-shop">
    <h1 class="shop-title">EGGMONEY SHOP</h1>

    <!-- ========================= 모달창 ============================= -->
    <div class="black-bg" v-show="modalOpen">
      <div class="white-bg">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7ca0314f-6f5d-4149-892b-cb08045d1573/%EC%9D%91%EC%95%A0%EA%B3%84%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T134043Z&X-Amz-Expires=86400&X-Amz-Signature=bb0b7be15340fa5b70798291bd4b705f40e7d79801a8d44e8ae16161240a6657&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%259D%2591%25EC%2595%25A0%25EA%25B3%2584%25EB%259E%2580.png%22&x-id=GetObject"
          class="egg-img"
          alt="응애계란"
        />
        <p class="popup-text">제품을 구매하였습니다.</p>
        <b-button varian="primary" @click="popItem">닫기</b-button>
      </div>
    </div>

    <!-- ======================================================= -->

    <div class="shop-items">
      <!-- 아이템1 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/14e7861b-ee43-4215-83fa-08002bc08c02/%EB%B0%98%EC%88%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074810Z&X-Amz-Expires=86400&X-Amz-Signature=5167d0532d44fb04d5af18e82e0b38174011bdb0752ac452c17234bdaff9bbe9&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EB%25B0%2598%25EC%2588%2599%25EB%259E%2580.png%22&x-id=GetObject"
          alt="반숙란"
        />
        <br />
        <p class="point">3,200 point</p>
        <input
          type="radio"
          name="buy"
          id="item1"
          value="item1"
          v-model="selected"
        />
      </div>
      <!-- 아이템2 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/395a3f9e-d719-4024-a59f-b4300b34fb08/%EA%B5%AC%EC%9A%B4%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074832Z&X-Amz-Expires=86400&X-Amz-Signature=e3048abcdc800aede983a5179678203cf2d5e113685438634426f75caeb85783&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B5%25AC%25EC%259A%25B4%25EB%259E%2580.png%22&x-id=GetObject"
          alt="구운란"
        />
        <br />
        <p class="point">2,800 point</p>
        <input
          type="radio"
          name="buy"
          id="item2"
          value="item2"
          v-model="selected"
        />
      </div>
      <!-- 아이템3 -->
      <div class="item">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f830884a-f71d-4a23-b329-75cc67cf21f5/%EA%B0%90%EB%8F%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221123%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221123T074904Z&X-Amz-Expires=86400&X-Amz-Signature=37c052aabc6b006a337146742ef290a94d6efa083c5286b329de6a716176c399&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B0%2590%25EB%258F%2599%25EB%259E%2580.png%22&x-id=GetObject"
          alt="감동란"
        />
        <br />
        <p class="point">1,200 point</p>
        <input
          type="radio"
          name="buy"
          id="item3"
          value="item3"
          v-model="selected"
        />
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
      // 모달을 숨겨주는 변수 선언
      modalOpen: false,
    };
  },
  methods: {
    popItem() {
      // if (this.data.selected === "item1") {
      //   console.log("반숙란");
      // } else if (this.data.selected === "item2") {
      //   console.log("감동란");
      // } else if (this.data.selected === "item3") {
      //   console.log("구운란");
      // }
      this.modalOpen = !this.modalOpen;
    },
  },
};
</script>

<style>
.eggmoney-shop {
  background-color: hsl(33, 97%, 87%);
  margin-top: 30px;
  margin-bottom: 30px;
}

.shop-items {
  justify-content: space-around;
  margin: 25px 100px;
  display: flex;
}

.item {
  background-color: slategray;
  border: 1px solid white;
}

.point {
  font-weight: bold;
}

/* modal css */
.black-bg {
  width: 100%;
  height: 50%;
  background: hsl(33, 97%, 87%);
  position: absolute;
}

.white-bg {
  width: 90%;
  margin: 80px auto;
  background: white;
  border-radius: 5px; /* 모서리 곡률..아마도? */
  padding: 20px 0;
}

.close {
  cursor: pointer;
  border: none;
  background: #6667ab;
  color: white;
  font-weight: bold;
  border-radius: 5px;
  padding: 5px 15px;
}

.close:hover {
  color: white;
  font-weight: bold;
  transform: scale(1.1);
  transition: all 0.5s;
}

.egg-img {
  width: 250px;
  height: 250px;
}

.popup-text,
.shop-title {
  color: black;
}
</style>
