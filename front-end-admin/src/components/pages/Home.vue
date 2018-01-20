<template>
  <div class="home">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <!--<p>Welcome back, <% out.print(user.getUsername()); %>! </p>-->
        <div class="col-md-6">
          <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerdonor.jsp" role="button">Add Donor&raquo;</a></p>
          <form class="form-horizontal" action="/searchdonor" method="GET">
            <div class="form-group">
              <label class="control-label col-sm-2">Search:</label>
              <input name="searchterm" type="text" width="50">
              <button type="submit">Search</button>
            </div>
          </form>
          <p><a href="${pageContext.request.contextPath}/donorlist.jsp">Click here for full donor list</a></p>
          <h3>Recent Donors</h3>
          <table class="table">
            <thead>
            <tr>
              <th>Donor Name</th>
              <th>Email</th>
              <th>Joined On</th>
            </tr>
            </thead>
            <tbody id="topDonorTBody">
            </tbody>
          </table>
        </div>
        <div class="col-md-6">
          <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Need&raquo;</a></p>
          <form class="form-horizontal" action="/searchneeds" method="GET">
            <div class="form-group">
              <label class="control-label col-sm-2">Search:</label>
              <input name="searchterm" type="text" width="50">
              <button type="submit">Search</button>
            </div>
          </form>
          <p><a href="${pageContext.request.contextPath}/needslist.jsp">Click here for full need list</a></p>
          <h3>Recent Needs</h3>
          <table class="table">
            <thead>
            <tr>
              <th>Need</th>
              <th>Create Date</th>
              <th>Link</th>
            </tr>
            </thead>
            <tbody id="needTBody">
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "home"
  }
</script>

<style scoped>

</style>
