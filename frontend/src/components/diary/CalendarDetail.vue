<template>
  <b-row>
    <b-col md="auto">
      <b-calendar
        selected-variant="warning"
        today-variant="warning"
        v-model="value"
        @context="onContext"
      ></b-calendar>
    </b-col>
    <b-col>
      <p>
        Value: <b>`{{ value }}`</b>
      </p>
      <p class="mb-0">Context:</p>
      <pre class="small">{{ context }}</pre>
    </b-col>
  </b-row>
</template>

<script>
export default {
  data() {
    return {
      value: "",
      context: null,
      hideHeader: true,
    };
  },
  methods: {
    onContext(ctx) {
      this.context = ctx;
    },
  },
};
</script>

<style></style>
