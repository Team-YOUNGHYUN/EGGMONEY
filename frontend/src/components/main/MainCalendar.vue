<template>
  <div class="main-calendar">
    <vc-calendar
      color="blue"
      is-dark
      class="vc-main-calendar"
      :attributes="attributes"
      :columns="$screens({ default: 1, lg: 1 })"
      disable-page-swipe
      is-expanded
    />
  </div>
</template>

<script>
export default {
  name: "MainCalendar",
  data() {
    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth();
    const date = today.getDate();
    // const day = today.getDay();

    return {
      attributes: [
        {
          // 오늘 날짜 표시
          key: 1,
          highlight: "yellow",
          dates: new Date(year, month, date),
        },
        {
          // 다이어리가 작성된 날짜에 표시
          key: 2,
          highlight: {
            style: {
              backgroundColor: "brown",
            },
          },
          dates: ["2022-11-11", "2022-11-05"],
        },
      ],
    };
  },
};
</script>

<style>
.main-calendar {
  width: 90%;
  margin: 10px auto;
}
</style>
