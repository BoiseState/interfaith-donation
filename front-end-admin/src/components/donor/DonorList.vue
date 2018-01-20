<template>
  <div class="jumbotron">
    <div class="container">
      <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerdonor.jsp" role="button">Add Donor&raquo;</a></p>
      <form class="form-horizontal" action="/searchdonor" method="GET">
        <div class="form-group">

          <label class="control-label col-sm-2">Search:</label>
          <input name="searchterm" type="text" width="50">
          <button type="submit">Search</button>
        </div>
      </form>
      <br>
      <h3>Donors</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Donor Name</th>
          <th>Email</th>
          <th>Display Name</th>
          <th>Joined On</th>
        </tr>
        </thead>
        <tbody id="fullDonorTBody">
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: "donor-list"
  }
</script>

<style scoped>

</style>
