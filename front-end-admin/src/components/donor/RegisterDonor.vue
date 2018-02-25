<template>
  <div class="adduser">
    <div class="jumbotron">
      <h2>Create New Donor</h2>
      <form v-on:submit.prevent="onFormSubmit" class="form-horizontal">
        <div class="form-group">
          <label class="control-label col-sm-2">Full Name:</label>
          <input v-model="donor.name" name="name" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Email Address:</label>
          <input v-model="donor.email" name="email" type="email" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Phone:</label>
          <input v-model="donor.phone" name="phone" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Address:</label>
          <input v-model="donor.address" name="address" type="text" width="100" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">City:</label>
          <input v-model="donor.city" name="city" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">State:</label>
          <input v-model="donor.state" name="state" type="text" width="2" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Postal Code:</label>
          <input v-model="donor.zip" name="zip" type="text" width="10" required>
        </div>
        <!-- <div class="form-group">
          <label class="control-label col-sm-2">Password:</label>
          <input v-model="donor.password" name="password" type="text" width="10" required>
        </div> -->
        <button type="submit">Create Donor</button>
      </form>
    </div>
  </div>
</template>

<script>
import {createDonor} from '../../services/donor-service';

export default {
  name: 'register-donor',
  data () {
    return {
      donor: {
        name: '',
        email: '',
        address: '',
        city: '',
        state: '',
        zip: '',
        phone: '',
        joinDate: '2000-10-10'
        //password: ''
      },
      errors: []
    };
  },
  methods: {
    onFormSubmit () {
      createDonor(this.donor);
    }
  }
};
</script>

<style scoped>

</style>
