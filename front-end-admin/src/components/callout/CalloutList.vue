<template>
  <div class="jumbotron">
    <div class="container">
      <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registercallout.jsp" role="button">Add Callout&raquo;</a></p>
      <form class="form-horizontal" action="/searchcallout" method="GET">
        <div class="form-group">
          <label class="control-label col-sm-2">Search:</label>
          <input name="searchterm" type="text" width="50">
          <button type="submit">Search</button>
        </div>
      </form>
      <br>
      <h3>Callouts</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Title</th>
          <th>URL</th>
          <th>Last Updated</th>
          <th>Active Status</th>
          <th>Pinned Status</th>
        </tr>
        </thead>
        <tbody id="calloutTBody">
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'callout-info'
  }
</script>

<style scoped>

</style>
