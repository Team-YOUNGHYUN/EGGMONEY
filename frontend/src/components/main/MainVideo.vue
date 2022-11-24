<template>
  <div class="content-box">
    <br />
    <h2 class="mv-title">오늘의 운동 추천 영상</h2>
    <div class="video-list">
      <!-- 상체 영상 랜덤 -->
      <div class="part-video">
        <legend class="video-header">상체</legend>
        <iframe
          :src="`https://www.youtube.com/embed/${this.randomVideo1.id.videoId}`"
          frameborder="0"
          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
          class="each-video"
        ></iframe>
      </div>

      <!-- 하체 영상 랜덤 -->
      <div class="part-video">
        <legend class="video-header">하체</legend>
        <iframe
          :src="`https://www.youtube.com/embed/${this.randomVideo2.id.videoId}`"
          frameborder="0"
          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
          class="each-video"
        ></iframe>
      </div>

      <!-- 코어 영상 랜덤 -->
      <div class="part-video">
        <legend class="video-header">코어</legend>
        <iframe
          :src="`https://www.youtube.com/embed/${this.randomVideo3.id.videoId}`"
          frameborder="0"
          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
          class="each-video"
        ></iframe>
      </div>

      <!-- 유산소 영상 랜덤 -->
      <div class="part-video">
        <legend class="video-header">유산소</legend>
        <iframe
          :src="`https://www.youtube.com/embed/${this.randomVideo4.id.videoId}`"
          frameborder="0"
          allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
          class="each-video"
        ></iframe>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import _ from "lodash";

export default {
  computed: {
    ...mapState(["videos1", "videos2", "videos3", "videos4"]),
    randomVideo1() {
      return _.sample(this.videos1);
    },
    randomVideo2() {
      return _.sample(this.videos2);
    },
    randomVideo3() {
      return _.sample(this.videos3);
    },
    randomVideo4() {
      return _.sample(this.videos4);
    },
  },
};
</script>

<style>
.mv-title {
  text-align: left;
  color: black;
}

.content-box {
  background-color: #fee0bc;
  margin: auto 10%;
  border-radius: 2%;
}

.video-list {
  width: 90%;
  margin: 10px auto;
  display: flex;
}

.part-video {
  flex: 1;
  width: 20%;
  box-sizing: border-box;
  color: black;
}

.each-video {
  width: auto;
  height: auto;
  border-radius: 5%;
}
</style>
