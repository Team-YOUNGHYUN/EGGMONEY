<template>
  <div>
    <h2>오늘의 운동 추천</h2>
    <!-- 아래 코드는 randomVideo가 잘 동작하는지 확인하는 코드 -->
    <!-- <p>{{ this.randomVideo }}</p> -->
    <iframe
      width="560"
      height="315"
      :src="`https://www.youtube.com/embed/${this.randomVideo.id.videoId}`"
      frameborder="0"
      allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture"
      allowfullscreen
    ></iframe>
  </div>
</template>

<script>
import { mapState } from "vuex";
import _ from "lodash";

export default {
  computed: {
    ...mapState(["videos"]),
    randomVideo() {
      return _.sample(this.videos);
    },
  },
};
</script>

<style>
.youtube-list {
  text-align: left;
}
</style>
