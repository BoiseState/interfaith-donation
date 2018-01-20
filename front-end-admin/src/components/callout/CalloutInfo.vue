<template>
  <div class="addcallout">
    <div class="jumbotron">
      <div class="container">
        <h2>{{callout_title}}</h2>
        <h3>Add Need</h3>
        <form class="form-horizontal" action="/createcalloutneed" method="POST">
          <div class="form-group">
            <label class="control-label col-sm-2">Need Name:</label>
            <input name="need_name" type="text" width="50">
          </div>

          <!-- Quantity needed, not sure if correct -->
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
          <div class="form-group">
            <input type="hidden" value="{{callout_id}}" name="callout_id" id="callout_id" />
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2>">Status: </label>
            <input type="checkbox" name="active" value="active">Active?<br></div>
          <br>
          <button type="submit">Create Need</button>
        </form>

        <h3>Associated Needs</h3>
        <table class="table">
          <thead>
          <tr>
            <th>Need</th>
            <th>Status</th>
            <th>Quantity Needed</th>
            <th>Quantity Given</th>
            <th>Link</th>
            <th>Date Created</th>
            <th>Callout</th>
          </tr>
          </thead>
          <tbody id="associatedNeedsTBody">
          </tbody>
        </table>
        <i>last updated: {{update_date}} </i>
        <br>
        <h2>Update Callout Information</h2>
        <form id="calloutform" class="form-horizontal" action="/updatecallout" method="POST">
          <button type="submit">Update Callout</button>
          <div class="form-group">
            <input type="hidden" value="{{callout_id}}" name="calloutid" id="calloutid"/>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Title:</label>
            <input name="callout_title" type="text" width="50" value="{{callout_title}}">
          </div>

          <div class="form-group">
            <label class="control-label col-sm-2">URL: <i>(optional)</i></label>
            <input name="callout_url" type="text" width="50" value="{{callout_url}}">
          </div>

          <div class="form-group">
            <label class="control-label col-sm-2">Body:</label>
            <textarea rows="4" cols="50" name="need_description" form="calloutform">{{callout_body}}</textarea>
          </div>

          <div class="form-group">
            <label class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="active" checked="{{active}}">Active?<br>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="pinned" checked="{{pinned}}">Pinned?<br>
          </div>
          <br>
          <button type="submit">Update Callout</button>
        </form>
      </div>
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
