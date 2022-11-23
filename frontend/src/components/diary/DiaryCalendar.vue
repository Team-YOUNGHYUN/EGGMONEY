<template>
  <div class="text-center section">
    <h2 class="h2">EGG DIARY</h2>
    <vc-calendar
    @dayclick="selectDate"
      color="blue"
      is-range
      :colums="$screens({ default: 1, lg: 2 })"
      class="custom-calendar max-w-full"
      :attributes="attributes"
    />
  <button @click="test">콘솔</button>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
export default {
  data() {
    // const today = new Date();
    // const year = today.getFullYear();
    // const month = today.getMonth();
    // const date = today.getDate();
    // const day = today.getDay();

    return {
      // attributes: [
      //   {
      //     // 오늘(시스템) 날짜에 yellow highlight 표시
      //     key: 1,
      //     highlight: "yellow",
      //     dates: new Date(year, month, date),
      //   },

        // {
        //   key: 2,
        //   dot: true,
        //   dates: new Date(year, month, 2),
        // },

        // {
        //   key: 3,
        //   highlight: {
        //     color: "yellow",
        //     fillmode: "outline",
        //   },
        //   dates: new Date(year, month, 5),
        // },

        // {
        // start ~ end 구간 표시
        //   key: 4,
        //   highlight: {
        //     start: { fillMode: "outline" },
        //     base: { fillMode: "light" },
        //     end: { fillMode: "outline" },
        //   },
        //   dates: {
        //     start: new Date(year, month + 1, 14),
        //     end: new Date(year, month + 1, 18),
        //   },
        // },

        // {
        //   // dates에 diary가 작성된 날짜를 저장하고 표시하는 것 까지는 구현 가능
        //   // 날짜와 diary를 link하는건 고민
        //   key: 5,
        //   highlight: {
        //     style: {
        //       backgroundColor: "yellow",
        //     },
        //   },
        //   // 여기 dates에 필요한 내용을 insert
        //   dates: [new Date(year, month, 7), new Date(year, month, 2)],
        // },
      // ],
    };
  },
  computed:{
    ...mapGetters(["getSelectedDate","getRecords"]),
  },
  methods:{
    test(){
      console.log(this.getSelectedDate);
      
    },
    async selectDate(date){
      await this.$store.dispatch("setSelectedDate", date.id);
      let params = {
        records: this.getRecords,
        date: this.getSelectedDate,
      }
      this.$store.dispatch("setDayRecords", params);
    }
  },
  created(){
    
  }
};
</script>

<style></style>
