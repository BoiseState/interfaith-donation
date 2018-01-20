<template>
  <div class="addcallout">
    <div class="jumbotron">
      <div class="container">
        <h2>Register Callout</h2>
        <!-- action="/ws/callout/register"-->
        <form class="form-horizontal" id ="createCalloutForm">
          <div class="form-group">
            <label class="control-label col-sm-2">Title:</label>
            <input id = "callout-name-label" name="callout_title" type="text" width="50" required>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">URL: <i>(optional)</i></label>
            <input id = "callout-url-label" name="callout_url" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Body:</label>
            <textarea id = "callout-body-label" rows="4" cols="50" name="callout_description" form="createCalloutForm"></textarea>
          </div>
          <div class="form-group">
            <label id = "callout-active-label" class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="active" value="active">Active?<br>
          </div>
          <div class="form-group">
            <label id = "callout-pinned-label" class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="pinned" value="pinned">Pinned?<br>
          </div>
          <button type="submit">Create Callout</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "register-callout"
  }
</script>

<style scoped>

</style>
