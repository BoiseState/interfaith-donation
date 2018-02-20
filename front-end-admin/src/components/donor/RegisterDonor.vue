<template>
  <div class="adduser">
    <div class="jumbotron">
      <div class="container">
        <!-- <form class="form-horizontal" action="/createdonor" method="POST"> -->
        <form class="form-horizontal">
          <div class="form-group">
            <label class="control-label col-sm-2">Full Name:</label>
            <input v-model="donor.name" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Email:</label>
            <input v-model="donor.email" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>
            <input v-model="donor.password" type="password" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Confirm Password:</label>
            <input v-model="donor.confirm" type="password" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Display Name:</label>
            <input v-model="donor.displayname" type="text" width="50">
          </div>
          <br>
          <p>Mailing Information</p>
          <div class="form-group">
            <label class="control-label col-sm-2">Address:</label>
            <input v-model="donor.address" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">City:</label>
            <input v-model="donor.city" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">State:</label>
            <input v-model="donor.state" type="text" width="2">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Postal Code:</label>
            <input v-model="donor.zip" type="text" width="10">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Phone:</label>
            <input v-model="donor.phone" type="text" width="50">
          </div>
          <button v-on:click="createUser" type="submit">Create Account</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'register-donor',
  data () {
    return {
      donor: {
        name: '',
        email: '',
        password: '',
        confirm: '',
        displayname: '',
        address: '',
        city: '',
        state: '',
        zip: '',
        phone: ''
      }
    };
  },
  methods: {
    createUser: function () {
      console.log('submit button clicked');
      // send this somewhere databasey
      // get id
      // go to donor info page and reload with donor
    }
  }
};
</script>

<style scoped>

</style>
