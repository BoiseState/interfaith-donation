<template>
  <div class="needs">
    <div class="jumbotron">
      <div class="container">
        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Alert&raquo;</a></p>
        <form class="form-horizontal" action="ws/alerts/search" method="GET">
          <div class="form-group">
            <label class="control-label col-sm-2">Search:</label>
            <input name="searchterm" type="text" width="50">
            <button id = "btnSearch" type="submit">Search</button>
          </div>
        </form>
        <br>
        <h3>Recently Pushed Alerts</h3>
        <table class="table">
          <thead>
          <tr>
            <th>Alert Title(LINK)</th>
            <th>Push Date</th>
            <th>Date Created</th>
          </tr>
          </thead>
          <tbody id="topAlertTBody">>
          </tbody>
        </table>
        <h3>Alerts</h3>
        <table class="table">
          <thead>
          <tr>
            <th>Alert Title</th>
            <th>Date Last Pushed</th>
            <th>Date Created</th>
            <th>Callout</th>
            <th>Need</th>
          </tr>
          </thead>
          <tbody id="fullAlertTBody">
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "alert-list"
  }
</script>

<style scoped>

</style>
