<template>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <!-- If statement for logged in or not???  Current Default is "logged in" -->
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Interfaith Sanctuary Administrator Tool</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
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
      </div><!--/.navbar-collapse -->
    </div>
  </nav>
</template>

<script>
  export default {
    name: "login"
  }
</script>

<style scoped>

</style>
