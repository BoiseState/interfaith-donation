<template>
  <div class="donorInfoPage">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <h2>Donor Info Page for {{ donor_name }}</h2>
      <form class="form-horizontal" action="/updatedonor" method="POST">
        <button type="submit">Update Donor</button>
        <input type="hidden" name="donor_id" value="{{ donor_id }}">
        <div class="form-group">
          <label class="control-label col-sm-2">Full Name:</label>
          <input name="donor_name" type="text" width="50" value="{{donor_name}}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Email:</label>
          <input name="donor_email" type="text" width="50" value="{{ donor_email }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Display Name:</label>
          <input name="displayname" type="text" width="50" value="{{ displayname }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Phone:</label>
          <input name="donor_phone" type="text" width="50" value="{{ donor_phone }}">
        </div>

        <div class="form-group">
          <label class="control-label col-sm-2">Address:</label>
          <input name="donor_address" type="text" width="100" value="{{ donor_address }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">City:</label>
          <input name="donor_city" type="text" width="50" value="{{ donor_city }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">State:</label>
          <input name="donor_state" type="text" width="2" value="{{ donor_state }}">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Postal Code:</label>
          <input name="donor_zip" type="text" width="10" value="{{ donor_zip }}">
        </div>
        <button type="submit">Update Donor</button>
      </form>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'donor-info'
  }
</script>

<style scoped>

</style>
