<template>
  <div class="eggmoney-shop">
    <h1 class="shop-title" style="font-size: 2.5em">EGGMONEY 상점</h1>
    <!-- ========================= 모달창 ============================= -->
    <div class="black-bg" v-show="modalOpen">
      <div class="white-bg">
        <img
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/7ca0314f-6f5d-4149-892b-cb08045d1573/%EC%9D%91%EC%95%A0%EA%B3%84%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T183147Z&X-Amz-Expires=86400&X-Amz-Signature=e68edc6ece7e8b02a198f972906195395379cc96b9c2fb8cb6d506efb4828ecb&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%259D%2591%25EC%2595%25A0%25EA%25B3%2584%25EB%259E%2580.png%22&x-id=GetObject"
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
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/14e7861b-ee43-4215-83fa-08002bc08c02/%EB%B0%98%EC%88%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T183121Z&X-Amz-Expires=86400&X-Amz-Signature=63817b3abdbaf4176d715295a2be9a3d13a9532743a6249f8cdb0bb494910274&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EB%25B0%2598%25EC%2588%2599%25EB%259E%2580.png%22&x-id=GetObject"
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
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/395a3f9e-d719-4024-a59f-b4300b34fb08/%EA%B5%AC%EC%9A%B4%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T183211Z&X-Amz-Expires=86400&X-Amz-Signature=383b673668f46421108624f5e9276062b24c7866de29c4575981decc7433840b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B5%25AC%25EC%259A%25B4%25EB%259E%2580.png%22&x-id=GetObject"
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
          src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/f830884a-f71d-4a23-b329-75cc67cf21f5/%EA%B0%90%EB%8F%99%EB%9E%80.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221124%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221124T183232Z&X-Amz-Expires=86400&X-Amz-Signature=b9c2cfa9ceaba562958e35218ee191b628c79870e76c6ad99fa42074f54cd490&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B0%2590%25EB%258F%2599%25EB%259E%2580.png%22&x-id=GetObject"
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
    <b-button variant="dark" @click="popItem">구매</b-button>
  </div>
</template>

<script>
export default {
  name: "MoneyShop",
  data() {
    return {
      selected: "",
      modalOpen: false,
    };
  },
  methods: {
    popItem() {
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
  background-color: beige;
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
