<template>
  <div class="adduser">
    <div class="jumbotron">
      <div class="container">
        <!-- <form class="form-horizontal" action="/createdonor" method="POST"> -->
        <!-- <form id="app" @submit="checkForm" action="https://vuejs.org/" method="post"> https://vuejs.org/v2/cookbook/form-validation.html -->
        <form class="form-horizontal">
          <p v-if="errors.length"><b>Please correct the following error(s):</b>
            <ul><li v-for="error in errors" :key="error">{{ error }}</li></ul>
          </p>
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
      },
      errors: []
    };
  },
  methods: {
    createUser: function (e) {
      console.log('submit button clicked');
      // validate here
      if (!this.validateForm()) {
        e.preventDefault();
      } else {
        console.log('passed client side validation');
        // send this somewhere databasey for server side validation and addition to database
        // get id
        // go to donor info page and reload with donor
      }
    },

    validateForm: function () {
      this.errors = [];
      this.validateFullname();
      this.validatePassword();
      this.validateEmail();
      this.validateDisplayname();
      if (!this.errors.length) return true;
    },

    validateFullname: function () {
      // TODO: what is too long?
      if (this.donor.name.length === 0) {
        this.errors.push('Need a Full Name');
      }
    },

    validateDisplayname: function () {
      // TODO: what is too long?
      if (this.donor.displayname.length === 0) {
        this.errors.push('Need a Display Name');
      }
    },

    validatePassword: function () {
      var minPassLength = 4;
      if (this.donor.password.length < minPassLength) {
        this.errors.push('Password needs to be at least ' + minPassLength + ' characters long');
      }
      if (this.donor.password !== this.donor.confirm) {
        this.errors.push('Passwords do not match');
      }
    },

    validateEmail: function () {
      var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
      if (!re.test(this.donor.email)) {
        this.errors.push('Email not valid');
      }
    }
  }
};
</script>

<style scoped>

</style>
