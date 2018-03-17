<template>
  <div class="addneed">
    <div class="jumbotron">
      <div class="container">
        <h2>Register Need</h2>
        <form class="form-horizontal" action="/createneed" method="POST">
          <div class="form-group">
            <label class="control-label col-sm-2">Need Name:</label>
            <input name="need_name" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Quantity:</label>
            <input id="need_quantity" name="need_quantity" type="number" min="1" step="1" value ="1"/>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Unit Type: <i>(optional)</i></label>
            <input name="need_unit" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Need URL: <i>(optional)</i></label>
            <input name="need_url" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Need Description: <i>(optional)</i></label>
            <input name="need_description" type="text" width="50">
          </div>
          <!-- <div class="form-group">
            <label class="control-label col-sm-2>">Associated Callout (optional)</label>
            <select name="callout_id">
              <option value="{{callout.callout_id}}">{{ callout.callout_title }} - {{callout.update_date}}</option>
            </select>
            </div> -->
          <div class="form-group">
            <label class="control-label col-sm-2>">Status: </label>
            <input type="checkbox" name="active" value="active">Active?<br></div>
          <br>
          <button type="submit">Create Need</button>
        </form>
        <br>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'register-need'
};
</script>

<style scoped>

</style>
