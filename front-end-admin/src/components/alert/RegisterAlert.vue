<template>
  <div class="addcallout">
    <div class="jumbotron">
      <div class="container">
        <h2>Register Alert</h2>
        <form class="form-horizontal" action="/createalert" method="POST" id="alertform">
          <div class="form-group">
            <label class="control-label col-sm-2">Title:</label>
            <input name="alert_title" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Body:</label>
            <textarea rows="4" cols="50" name="alert_body" form="alertform"></textarea>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2>">Associated Callout (optional)</label>
            <select name="callout_id">
              <option value="{{callout.callout_id}}">{{ callout.callout_title }} - {{callout.update_date}}</option>
            </select> </div>
          <div class="form-group">
            <label class="control-label col-sm-2>">Associated Need (optional)</label>
            <select name="callout_id">
              <option value="{{need.need_id}}">{{ need.need_title }}</option>
            </select> </div>
          <br>
          <button type="submit">Create Alert</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "register-alert"
    }
</script>

<style scoped>

</style>
