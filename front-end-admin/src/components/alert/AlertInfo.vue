<template>
  <div class="alertInfoPage">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h5>Alert Info Page for Alert {{ alert_id }}</h5>
        <p>Date created: {{ create_date }}<br>
          Date last pushed: {{last_pushed_date}}</p>
        <form class="form-horizontal" action="/updatealert" method="POST" id="alertform">
          <button type="submit">Update Alert</button>
          <input type="hidden" name="alert_id" value="alert_id">
          <div class="form-group">
            <label class="control-label col-sm-2">Alert Title:</label>
            <input name="alert_title" type="text" width="50" value="alert_title">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Alert Body:</label>
            <textarea rows="4" cols="50" name="alert_body" form="alertform">alert_body</textarea>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4>">Associated Callout: </label>
            <a href="callouts/callout_id">link</a>
          </div>
          <div class="form-group">
            <input type="hidden" value="{{alert_id}}" name="alertid" id="alertid" />
          </div>
          <button type="submit">Update Need</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'alert-info'
  }
</script>

<style scoped>

</style>
