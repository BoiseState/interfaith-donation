<template>
  <div class="jumbotron">
    <div class="container">
      <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerdonation.jsp" role="button">Add Manual Donation&raquo;</a></p>
      <form class="form-horizontal" action="/searchdonor" method="GET">
        <div class="form-group">
          <label class="control-label col-sm-2">Search:</label>
          <input name="searchterm" type="text" width="50">
          <button type="submit">Search</button>
        </div>
      </form>
      <br>
      <h3>Recent Donations</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Donor Name</th>
          <th>Need Donated</th>
          <th>Quantity</th>
          <th>Date</th>
        </tr>
        </thead>
        <tbody id="fullGiftTBody">
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "gifts-list"
  }
</script>

<style scoped>

</style>
