<template>
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <h2>Needs</h2>
        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/needslist.jsp" role="button">View Needs &raquo;</a>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Need &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>Donations</h2>
        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/giftslist.jsp" role="button">View Gifts &raquo;</a>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/registerdonation.jsp" role="button">Add Donation &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>Callouts</h2>
        <p><a class="btn btn-primary" href="${pageContext.request.contextPath}/calloutlist.jsp" role="button">View Callouts &raquo;</a>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/registercallout.jsp" role="button">Add Callout &raquo;</a></p>
      </div>
    </div>
  </div> <!-- /container -->
</template>

<script>
  export default {
    name: "navigation"
  }
</script>

<style scoped>

</style>
