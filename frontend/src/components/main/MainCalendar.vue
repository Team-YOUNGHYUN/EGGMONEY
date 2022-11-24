<template>
  <div class="main-calendar">
    <vc-calendar
      color="blue"
      class="vc-main-calendar"
      :attributes="attributes"
      :columns="$screens({ default: 1, lg: 1 })"
      disable-page-swipe
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
.main-calendar {
  width: 90%;
  margin: 10px auto;
}
</style>
