<template>
  <form action="ws/auth/logout" method="GET" class="navbar-form navbar-right">
    <span class="logged-in-message">Logged in as: USER</span>
    <button type="link" class="btn btn-link">Logout</button>
  </form>
</template>

<script>
export default {
  name: 'logout.vue'
}
</script>

<style scoped>
  .logged-in-message {
    margin: 0;
    color: gray;
    vertical-align: middle;
  }
  .logged-in-message > span {
    margin: 0;
    color: green;
    vertical-align: middle;
  }
</style>
