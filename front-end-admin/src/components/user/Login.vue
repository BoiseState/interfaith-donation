<template>
  <b-form action="ws/auth/login" method="GET" class="navbar-form navbar-right">
    <div class="form-group">
      <input name="userName" type="text" placeholder="User Name" class="form-control">
    </div>
    <div class="form-group">
      <input name="password" type="password" placeholder="Password" class="form-control">
    </div>
    <b-button type="submit" variant="success">Sign in</b-button>
    <!-- <a class="btn btn-link" href="${pageContext.request.contextPath}/registeradmin.jsp" role="button">Register</a> -->
    <router-link class="btn btn-link" to="register-user" role="button">Register</router-link>
  </b-form>
</template>

<script>
export default {
  name: 'login'
};
</script>

<style scoped>

</style>
