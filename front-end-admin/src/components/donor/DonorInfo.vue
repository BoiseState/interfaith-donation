<template>
  <div class="donorInfoPage">
    <div class="jumbotron">
      <h2>Donor info page for {{donor.name}}</h2>
      <form v-on:submit.prevent="onFormSubmit" class="form-horizontal">
        <button class="btn btn-primary" type="submit">Update Donor</button>
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
      </form>
    </div>
  </div>
</template>

<script>
import { getDonorById, updateDonor } from '../../services/donor-service';

export default {
  name: 'donor-info',
  data() {
    return {
      donor: {
        name: 'Loading...',
        city: '',
        email: '',
        phone: '',
        state: '',
        zip: '',
        join_date: '2000-10-10'
      }
    };
  },
  created() {
    getDonorById(this.$route.params.id).then(donor => {
      this.donor = donor;
    });
  },
  methods: {
    onFormSubmit() {
      updateDonor(this.donor);
    }
  }
};
</script>

<style scoped>

</style>
