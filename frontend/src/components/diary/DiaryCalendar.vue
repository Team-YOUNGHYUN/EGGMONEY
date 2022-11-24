<template>
  <div class="calendar">
    <div class="diary-title">
      <h2 class="h2">EGG DIARY</h2>
    </div>
    <vc-calendar
      @dayclick="selectDate"
      color="blue"
      is-range
      :colums="$screens({ default: 1, lg: 1 })"
      class="vc-container"
      :attributes="attributes"
      is-expanded
    />
  </div>
</template>

<script>
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      attributes: [],
    };
  },
  computed: {
    ...mapGetters([
      "getSelectedDate",
      "getRecords",
      "getDayRecords",
      "getRecordDates",
      "getUser"
    ]),
  },
  methods: {
    async selectDate(date) {
      await this.$store.dispatch("setSelectedDate", date.id);
      let params = {
        records: this.getRecords,
        date: this.getSelectedDate,
      };
      this.$store.dispatch("setDayRecords", params);
      this.selectComment();
    },
    selectComment(){
        let params = {
            email: this.getUser.email,
            date: this.getSelectedDate
        }
        this.$store.dispatch("setComment", params);
        this.getComment.comment;
    },
  },
  created() {
    for (let index in this.getRecordDates) {
      let attribute = {
        key: index,
        highlight: {
          style: {
            backgroundColor: "yellow",
          },
        },
        dates: this.getRecordDates[index],
      };
      this.attributes.push(attribute);
      this.selectDate();
    }
  },
};
</script>

<style>
.diary-title {
  margin-bottom: 8%;
}

.calendar {
  background-color: #fee0bc;
  height: 500px;
}
</style>
