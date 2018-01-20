<template>
  <div class="adduser">
    <div class="jumbotron">
      <div class="container">
        <form class="form-horizontal" action="/createdonor   " method="POST">
          <div class="form-group">
            <label class="control-label col-sm-2">Full Name:</label>
            <input name="donor_name" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Email:</label>
            <input name="donor_email" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>
            <input name="donor_password" type="password" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Confirm Password:</label>
            <input name="confirm" type="password" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Display Name:</label>
            <input name="displayname" type="text" width="50">
          </div>
          <br>
          <p>Mailing Information</p>
          <div class="form-group">
            <label class="control-label col-sm-2">Address:</label>
            <input name="donor_address" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">City:</label>
            <input name="donor_city" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">State:</label>
            <input name="donor_state" type="text" width="2">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Postal Code:</label>
            <input name="donor_zip" type="text" width="10">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Phone:</label>
            <input name="donor_phone" type="text" width="50">
          </div>
          <button type="submit">Create Account</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "register-donor"
  }
</script>

<style scoped>

</style>
