<template>
  <form action="ws/auth/login" method="GET" class="navbar-form navbar-right">
    <div class="form-group">
      <input name="userName" type="text" placeholder="User Name" class="form-control">
    </div>
    <div class="form-group">
      <input name="password" type="password" placeholder="Password" class="form-control">
    </div>
    <button type="submit" class="btn btn-success">Sign in</button>
    <a class="btn btn-link" href="${pageContext.request.contextPath}/registeradmin.jsp" role="button">Register</a>
  </form>
</template>

<script>
export default {
  name: 'login'
};
</script>

<style scoped>

</style>
