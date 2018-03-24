<template>
  <div></div>
</template>

<script>
export default {
  name: 'helper.vue',
  methods: {
    formatDate(dateString) {
      let date = new Date(dateString);
      return date.toLocaleDateString();
    }
  }
};
</script>

<style scoped>

</style>
