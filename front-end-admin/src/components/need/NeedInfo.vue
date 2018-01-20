<template>
  <div class="needInfoPage">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <h2>Need Info Page for {{ need_name }}</h2>
      <form class="form-horizontal" action="/updateneed" method="POST" id="needform">
        <button type="submit">Update Need</button>
        <input type="hidden" name="need_id" value="{{ need_id }}">
        <div class="form-group">
          <label class="control-label col-sm-2">Full Name:</label>
          <input name="need_name" type="text" width="50" value="{{need_name}}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Description:</label>
          <textarea rows="4" cols="50" name="need_description" form="needform">need_description</textarea>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Need URL:</label>
          <input name="need_url" type="text" width="50" value="{{ need_url }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Quantity:</label>
          <input id="need_quantity" name="need_quantity" type="number" min="1" step="1" value ="{{need_quantity}}"/>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Units:</label>
          <input name="need_unit" type="text" width="50" value="{{ need_unit }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Associated Callout: </label>
          <a href="callouts/{{callout_id}}">link</a>
          <div class="form-group">
            <label class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="active" checked="{{active}}">Active?
          </div>
          <button type="submit">Update Need</button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: "need-info"
  }
</script>

<style scoped>

</style>
