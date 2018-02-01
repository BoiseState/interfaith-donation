<template>
  <div class="logout">
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
          <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Interfaith Sanctuary Home</a>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/registeradmin.jsp" role="button">Register Admin</a>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/adminprefs.jsp" role="button">Admin Preferences </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <form action="ws/auth/logout" method="GET" class="navbar-form navbar-right">
                <span style="color:gray;vertical-align: middle;margin: 0;">Logged in as: <span
                  style="margin: 0;color:green; vertical-align: middle">User Name Goes Here!</span>
                    <button type="link" class="btn btn-link">Logout</button>
                </span>
          </form>
        </div>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: 'logout.vue'
}
</script>

<style scoped>

</style>
