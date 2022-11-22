<template>
  <FuncdtionalCalendar v-model="calendarData" @changeMonth="changeMonth">
  </FuncdtionalCalendar>
</template>

<script>
import FuncdtionalCalendar from "vue-functional-calendar";

export default {
  components: {
    FuncdtionalCalendar,
  },
  data() {
    return {
      calendarDate: {},
      calendarConfigs: {
        sundayStart: true,
        dateFormat: "yyyy/mm/dd",
        isDatePicker: false,
        isDateRange: false,
      },
    };
  },
};
</script>

<style></style>
