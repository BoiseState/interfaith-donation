<template>
  <div class="needs">
    <div class="jumbotron">
      <div class="container">
        <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Need&raquo;</a></p>
        <form class="form-horizontal" action="/searchneed" method="GET">
          <div class="form-group">
            <label class="control-label col-sm-2">Search:</label>
            <input name="searchterm" type="text" width="50">
            <button type="submit">Search</button>
          </div>
        </form>
        <br>
        <h3>Needs</h3>
        <table class="table">
          <thead>
          <tr>
            <th>Need</th>
            <th>Callout</th>
            <th>Quantity Needed</th>
            <th>Quantity Given</th>
            <th>Link</th>
            <th>Date Created</th>
            <th>Status</th>
          </tr>
          </thead>
          <tbody id ="fullNeedTBody">
          </tbody>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "need-list"
  }
</script>

<style scoped>

</style>
