<template>
  <div class="addDonorPage">
    <b-jumbotron>
      <div class="container">
        <b-card :title="titleText">
          <b-form @submit="onFormSubmit" class="form-horizontal">
            <h5>Full Name: </h5>
            <b-form-input v-model="donor.name"
                          required
                          placeholder="Enter name.."
                          name="name">
            </b-form-input>
            <h5>Email: </h5>
            <b-form-input v-model="donor.email"
                          required
                          placeholder="Enter email addresss.."
                          name="email">
            </b-form-input>
            <h5>Phone Number: </h5>
            <b-form-input v-model="donor.phone"
                          required
                          placeholder="Enter phone number.."
                          name="email">
            </b-form-input>
            <h5>Address: </h5>
            <b-form-input v-model="donor.address"
                          required
                          placeholder="Address.."
                          name="email">
            </b-form-input>
            <h5>City: </h5>
            <b-form-input v-model="donor.city"
                          required
                          placeholder="Enter city.."
                          name="city">
            </b-form-input>
            <h5>State: </h5>
            <b-form-input v-model="donor.state"
                          required
                          placeholder="Enter state of residency.."
                          name="state">
            </b-form-input>
            <h5>Zip: </h5>
            <b-form-input v-model="donor.zip"
                          required
                          placeholder="Enter postal/zip code.."
                          name="zip">
            </b-form-input>
            <h5>Password: </h5>
            <b-form-input    v-model="donor.password"
                             required
                             placeholder="Enter a password.."
                             name="password"
                             type="password">
            </b-form-input>
            <b-form-group label="Active:"
                          label-for="register-need-active"
            >
              <b-form-checkbox id="register-need-active"
                               v-model="donor.active"
              >
              </b-form-checkbox>
            </b-form-group>
            <br>
            <b-button type="submit" variant="success">Submit</b-button>
          </b-form>
        </b-card>
      </div>
    </b-jumbotron>
  </div>
</template>

<script>
import { createDonor } from '../../services/donor-service';
import { createUser } from '../../services/user-service';

export default {
  name: 'register-donor',
  data() {
    return {
      donor: {
        id: '',
        name: '',
        email: '',
        address: '',
        city: '',
        state: '',
        zip: '',
        phone: '',
        joinDate: '',
        password: '',
        active: true
      },
      titleText: 'Add a New Donor'
    };
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      const userToCreate = {
        userName: this.donor.name,
        permissions: 'BASIC_USER',
        active: this.donor.active,
        password: this.donor.password,
        email: this.donor.email
      };
      createUser(userToCreate).then(user => {
        console.log(user);
        this.donor.userId = user.id;
        createDonor(this.donor);
      });
    }
  }
};
</script>

<style scoped>

</style>
