<template>
  <div class="donorInfoPage">
    <div class="jumbotron">
      <div class="container">
      <b-card :title="donor.name">
        <b-form @submit="onFormSubmit" class="form-horizontal" >
          <input type="hidden" name="donor_id" v-model="donor.id">
          <h5>Full Name: </h5>
          <b-form-input    v-model="donor.name"
                           required
                           placeholder="Enter name.."
                           name="name">
          </b-form-input>
          <h5>Email: </h5>
          <b-form-input    v-model="donor.email"
                           required
                           placeholder="Enter email addresss.."
                           name="email">
          </b-form-input>
          <h5>Phone Number: </h5>
          <b-form-input    v-model="donor.phone"
                           required
                           placeholder="Enter phone number.."
                           name="email">
          </b-form-input>
          <h5>Address: </h5>
          <b-form-input    v-model="donor.address"
                           required
                           placeholder="Address.."
                           name="email">
          </b-form-input>
          <h5>City: </h5>
          <b-form-input    v-model="donor.city"
                           required
                           placeholder="Enter city.."
                           name="city">
          </b-form-input>
          <h5>State: </h5>
          <b-form-input    v-model="donor.state"
                           required
                           placeholder="Enter state of residency.."
                           name="state">
          </b-form-input>
          <h5>Zip: </h5>
          <b-form-input    v-model="donor.zip"
                           required
                           placeholder="Enter postal/zip code.."
                           name="zip">
          </b-form-input>
          <br>
          <b-button type="submit" variant="success">Submit</b-button>
        </b-form>
      </b-card>
    </div>
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
    onFormSubmit(evt) {
      evt.preventDefault();
      updateDonor(this.donor);
    }
  }
};
</script>

<style scoped>

</style>
