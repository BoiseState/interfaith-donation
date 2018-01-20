<template>
  <div class="addcallout">
    <div class="jumbotron">
      <div class="container">
        <h2>Choose Need to Manually Add Donation</h2>
        <!--CODE GOES HERE TO LIST GIFTS!!!! -->
        <form class="form-horizontal" action="/donation_redirect" method="POST">
          <!-- Quantity needed, not sure if correct -->
          <div class="form-group">
            <label class="control-label col-sm-2>">Choose a Need:</label>
            <!-- Link to a need which redirects to that certain need to add to it -->
            <select name="need_id">
              <option value="{{need.need_id}}">{{ need.need_name }}</option>
            </select>
          </div>
          <button type="submit">Donate to this Need</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'admin-preferences'
  }
</script>

<style scoped>

</style>
